package logic.queries;

import logic.DatabaseConnection;
import logic.models.Empresa;
import logic.models.Giros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertData {
    private static final DatabaseConnection dbConnection = new DatabaseConnection();

    public static boolean saveCompanyInformation(Empresa empresa) {

        String myQuery = "INSERT INTO tbl_empresas(" +
                "nombre_comercial, " +
                "nit, " +
                "id_giro_comercial, " +
                "id_distrito, " +
                "id_usuario, " +
                "direccion, " +
                "propietario ) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(myQuery)) {
            pstmt.setString(1, empresa.getNombreComercial());
            pstmt.setString(2, empresa.getNit());
            pstmt.setInt(3, empresa.getGiroComercial());
            pstmt.setInt(4, empresa.getDistritoId());
            pstmt.setInt(5, empresa.getIdUsuario());
            pstmt.setString(6, empresa.getDireccion());
            pstmt.setString(7, empresa.getPropietario());

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
