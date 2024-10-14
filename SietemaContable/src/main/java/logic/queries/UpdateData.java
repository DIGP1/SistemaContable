package logic.queries;

import logic.DatabaseConnection;
import logic.models.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {
    private static final DatabaseConnection dbConnection = new DatabaseConnection();
    
    public static boolean updateCompanyInformation(Empresa empresa, int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        boolean status;

        String myQuery = "UPDATE tbl_empresas SET nombre_comercial = ?, nit = ?, id_giro_comercial = ?," +
                "id_distrito = ?, id_usuario = ?, direccion = ? WHERE id = ?";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setString(1, empresa.getNombreComercial());
            pstmt.setString(2, empresa.getNit());
            pstmt.setInt(3, empresa.getGiroComercial());
            pstmt.setInt(4, empresa.getDistritoId());
            pstmt.setInt(5, empresa.getIdUsuario());
            pstmt.setString(6, empresa.getDireccion());
            pstmt.setInt(7, id);

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
