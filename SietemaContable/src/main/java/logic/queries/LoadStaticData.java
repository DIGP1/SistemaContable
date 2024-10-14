package logic.queries;

import logic.DatabaseConnection;
import logic.models.Department;
import logic.models.Districts;
import logic.models.Giros;
import logic.models.Municipio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoadStaticData {
    private static final DatabaseConnection dbConnection = new DatabaseConnection();

    public static List<Department> getDepartamentos() {
        String myQuery = "SELECT id, departamento FROM tbl_departamentos ORDER BY id";
        ArrayList<Department> departmentsList = new ArrayList<>();

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                departmentsList.add(new Department(rs.getInt("id"), rs.getString("departamento")));
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar en la base de datos: " + e.getMessage());
        }

        return departmentsList;
    }

    public static List<Municipio> getMunicipalities(String departmentId) {
        String myQuery = "SELECT id, municipio FROM tbl_municipios WHERE id_departamento = CAST(? AS INTEGER) ORDER BY id";
        List<Municipio> municipios = new ArrayList<>();

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setString(1, departmentId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                municipios.add(new Municipio(rs.getInt("id"), rs.getString("municipio")));
            }

            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return municipios;
    }

    public static List<Districts> getDistricts(String municipioId) {
        String myQuery = "SELECT id, distrito FROM tbl_distritos WHERE id_municipio = CAST(? AS INTEGER) ORDER BY id";
        List<Districts> distritos = new ArrayList<>();

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setString(1, municipioId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                distritos.add(new Districts(rs.getInt("id"), rs.getString("distrito")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return distritos;
    }

    public static List<Giros> getGiros() {
        String myQuery = "SELECT id, giro_comercial FROM tbl_giros_comerciales ORDER BY id";
        List<Giros> girosComerciales = new ArrayList<>();

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                girosComerciales.add(new Giros(rs.getInt("id"), rs.getString("giro_comercial")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return girosComerciales;
    }
}
