package logic.queries;

import logic.DatabaseConnection;
import logic.models.Empresa;

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

    public static List<Empresa> getCompanies() {
        String myQuery = "SELECT\n" +
                "    tbl_empresas.id,\n" +
                "    nombre_comercial,\n" +
                "    nit,\n" +
                "    id_giro_comercial,\n" +
                "    id_distrito,\n" +
                "    id_usuario,\n" +
                "    direccion,\n" +
                "    distrito\n" +
                "FROM\n" +
                "    tbl_empresas\n" +
                "INNER JOIN\n" +
                "    tbl_distritos td\n" +
                "ON\n" +
                "    tbl_empresas.id_distrito = td.id";
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
}
