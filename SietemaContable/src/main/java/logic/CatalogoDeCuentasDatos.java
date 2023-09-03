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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CatalogoDeCuentasDatos {
    private DatabaseConnection dbConnection = new DatabaseConnection();

    public List<String> listarCuentas() {
        List<String> cuentas = new ArrayList<>();
        
        String sql = "SELECT * FROM CATALOGO";
        
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String cuenta = rs.getString("Codigo") + "\t" +   // Ajusta 'nombreColumna1', 'nombreColumna2', etc.
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

}

