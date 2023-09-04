/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Isaac
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CatalogoDeCuentasDatos {
    private DatabaseConnection dbConnection = new DatabaseConnection();

    public List<String> listarCuentas() {
        List<String> cuentas = new ArrayList<>();
        
        String sql = "SELECT * FROM CATALOGO_DE_CUENTAS";
        
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String cuenta = rs.getString("Codigo") + "\t" +  
                               rs.getString("Cuenta");
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return cuentas;
    }
    
    
    public String buscarNombreCuentaPorCodigo(String codigoIngresado) {
    String nombreCuenta = "";

    // SQL para buscar la cuenta por código en la base de datos
    String sql = "SELECT Cuenta FROM CATALOGO_DE_CUENTAS WHERE Codigo = '" + codigoIngresado + "'";

    try (Connection conn = dbConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        if (rs.next()) {
            nombreCuenta = rs.getString("Cuenta");
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

    return nombreCuenta;
}

    public void guardarEnBaseDeDatos(String fecha,String Codigo,String  Descripcion, String Debe, String Haber) {
        String sql = "INSERT INTO LIBRO_DIARIO (Fecha,Codigo,Descripcion,  Debe, Haber) VALUES (?, ?, ?, ?,?)";
        
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fecha);
            pstmt.setString(2, Codigo);
            pstmt.setString(3, Descripcion);
            pstmt.setString(4, Debe);
            pstmt.setString(5, Haber);
            
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                System.out.println("Datos guardados en la base de datos.");
            } else {
                System.out.println("No se pudieron guardar los datos en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar en la base de datos: " + e.getMessage());
        }
    }

    
}

