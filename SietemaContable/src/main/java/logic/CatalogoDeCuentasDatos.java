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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
    
    
public List<String> buscarNombreCuentaPorCodigo(String codigoIngresado) {
    List<String> nombresCuentas = new ArrayList<>();

    // SQL para buscar la cuenta por código en la base de datos
    String sql = "SELECT Codigo, Cuenta FROM CATALOGO_DE_CUENTAS WHERE Codigo LIKE '" + codigoIngresado + "%'";

    try (Connection conn = dbConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            String nombreCuenta = rs.getString("Cuenta");
            nombresCuentas.add(nombreCuenta);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    for(String elemento : nombresCuentas){
        System.out.println(elemento);
    }
    return nombresCuentas;
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
    public void registrarUsuario(String username, String pass, String rol, String Nombre){
        
        boolean usuarioEncontrado = false;
        String sql1 = "SELECT username FROM USUARIOS WHERE username = '"+username+"'";
        try (Connection conn = dbConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql1)) {

        if (rs.next()) {
            usuarioEncontrado = true;
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        if(usuarioEncontrado){
            JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe","ERROR",1);
        }
        else{
            String sql = "INSERT INTO USUARIOS (username, password, rol,nombrecompleto) VALUES (?,?,?,?)";
            try(Connection conn = dbConnection.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, username);
                pstmt.setString(2, pass);
                pstmt.setString(3, rol);
                pstmt.setString(4,Nombre);
                int filasAfectadas = pstmt.executeUpdate();
            
                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado correctamente","Success",1);
                } else {
                    System.out.println("No se pudieron guardar los datos en la base de datos.");
                }
            } catch (Exception e) {
                    System.out.println("Error al guardar en la base de datos: " + e.getMessage());
                }
        }
    }
    public boolean verificacionAdmin(String username, String pass){
        String usuarioEncontrado = "";
        String sql1 = "SELECT username, password,rol FROM USUARIOS WHERE username = '"+username+"' AND password = '"+pass+"'";
        try (Connection conn = dbConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql1)) {

        if (rs.next()) {
            usuarioEncontrado = rs.getString("rol");
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        if("ADMINISTRADOR".equals(usuarioEncontrado)){
            return  true;
        }else{
            JOptionPane.showMessageDialog(null, "El administrador ingresado no existe");
            return false;
        }
    }
    public boolean login(String username, String password){
        boolean usuarioEncontrado = false;
        String sql1 = "SELECT username, password FROM USUARIOS WHERE username = '"+username+"' AND password = '"+password+"'";
        try (Connection conn = dbConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql1)) {

        if (rs.next()) {
            usuarioEncontrado = true;
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return usuarioEncontrado;
    }
}

