package logic.queries;

import logic.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {
    private static final DatabaseConnection dbConnection = new DatabaseConnection();
    
    public static boolean deleteCompany(int companyId){
        String myQuery = "DELETE FROM tbl_empresas WHERE id = ?";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setInt(1, companyId);

            pstmt.executeUpdate();
            if (pstmt.getUpdateCount() == 0) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
    
    public static boolean deleteUser(int userId){
        String myQuery = "DELETE FROM tbl_usuarios WHERE id = ?";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setInt(1, userId);

            pstmt.executeUpdate();
            if (pstmt.getUpdateCount() == 0) {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }
}
