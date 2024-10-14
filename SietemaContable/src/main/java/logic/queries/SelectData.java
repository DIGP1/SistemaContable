package logic.queries;

import logic.DatabaseConnection;
import logic.models.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SelectData {
    private static final DatabaseConnection dbConnection = new DatabaseConnection();

    public static int getUserID(String username) {
        String myQuery = "SELECT id FROM tbl_usuarios WHERE nombrecompleto = ?";
        int result = 0;

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    result = rs.getInt("id");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    public static int getLastCompanyId() {
        String myQuery = "SELECT MAX(id) AS max_id FROM tbl_empresas";
        int id = 0;

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery); ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                id = rs.getInt("max_id");
                if (id == 0) {
                    id = 1;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return id;
    }

    public static boolean ValidateNIT(String nit) {
        String myQuery = "SELECT nit FROM tbl_empresas WHERE nit = ?";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setString(1, nit);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return false;
    }

    public static boolean ValidateNIT(String nit, int id) {
        String myQuery = "SELECT nit FROM tbl_empresas WHERE nit = ? AND id != ?";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setString(1, nit);
            pstmt.setInt(2, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return true; // NIT exists and belongs to a different company
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return true; // Return true to indicate an error occurred
        }
        return false; // NIT does not exist or belongs to the same company
    }

    public static List<Empresa> getCompanies() {
        String myQuery = """
                SELECT
                    tbl_empresas.id,
                    nombre_comercial,
                    nit,
                    id_giro_comercial,
                    id_distrito,
                    id_usuario,
                    direccion,
                    distrito
                FROM
                    tbl_empresas
                INNER JOIN
                    tbl_distritos td
                ON
                    tbl_empresas.id_distrito = td.id""";
        List<Empresa> empresas = new ArrayList<>();

        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(myQuery);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                empresas.add(new Empresa(
                        rs.getInt("id"),
                        rs.getString("nombre_comercial"),
                        rs.getString("nit"),
                        rs.getInt("id_giro_comercial"),
                        rs.getString("direccion") + ", " + rs.getString("distrito"),
                        rs.getInt("id_distrito"),
                        rs.getInt("id_usuario")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving companies", e);
        }

        return empresas;
    }

    public static List<Empresa> getCompanieById(int id) {
        String myQuery = """
                SELECT tbl_empresas.id,
                       tbl_empresas.nombre_comercial,
                       tbl_empresas.nit,
                       tbl_empresas.id_giro_comercial,
                       tbl_empresas.id_distrito,
                       tbl_empresas.id_usuario,
                       tbl_empresas.direccion,
                       tg.id AS giro_comercial_id,
                       td2.id AS departamento_id,
                       tm.id AS municipio_id,
                       td.id AS distrito_id,
                       tg.giro_comercial AS giro_comercial,
                       td2.departamento AS departamento,
                       tm.municipio AS municipio,
                       td.distrito AS distrito
                FROM tbl_empresas
                         INNER JOIN tbl_giros_comerciales tg ON tbl_empresas.id_giro_comercial = tg.id
                         INNER JOIN tbl_distritos td ON tbl_empresas.id_distrito = td.id
                         INNER JOIN tbl_municipios tm ON td.id_municipio = tm.id
                         INNER JOIN tbl_departamentos td2 ON tm.id_departamento = td2.id
                WHERE tbl_empresas.id = ?;""";
        List<Empresa> empresas = new ArrayList<>();

        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(myQuery)) {

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    GiroComercial giro = new GiroComercial(rs.getInt("giro_comercial_id"), rs.getString("giro_comercial"));
                    Department departmento = new Department(rs.getInt("departamento_id"), rs.getString("departamento"));
                    Municipio municipio = new Municipio(rs.getInt("municipio_id"), rs.getString("municipio"));
                    Districts distrito = new Districts(rs.getInt("distrito_id"), rs.getString("distrito"));

                    empresas.add(new Empresa(
                            rs.getInt("id"),
                            rs.getString("nombre_comercial"),
                            rs.getString("nit"),
                            giro,
                            rs.getString("direccion"),
                            rs.getInt("id_distrito"),
                            rs.getInt("id_usuario"),
                            departmento,
                            municipio,
                            distrito
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving companies", e);
        }
        return empresas;
    }
}
