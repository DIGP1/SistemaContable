package logic.queries;

import logic.DatabaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
