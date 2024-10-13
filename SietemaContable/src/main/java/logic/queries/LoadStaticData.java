package logic.queries;

import logic.DatabaseConnection;
import logic.models.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        } catch (SQLException e) {
            System.out.println("Error al guardar en la base de datos: " + e.getMessage());
        }
        
        return departmentsList;
    }
}
