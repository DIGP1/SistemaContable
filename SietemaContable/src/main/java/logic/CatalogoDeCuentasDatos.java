/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author Isaac
 */
import form.LibroMayor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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
        public HashMap<String, List> CargarLibroDiario(){
        HashMap<String, List> inforLibro = new HashMap<>();
        List<String> fechas = new ArrayList<>();
        List<String> movimientos = new ArrayList<>();
        List<String> descripcion = new ArrayList<>();
        
        String sql = "SELECT * FROM TRANSACCIONES_LIBRO_DIARIO";
        
        try (Connection conn = dbConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)){
            while (rs.next()) {
                fechas.add(rs.getString("fecha"));
                movimientos.add(rs.getString("idMovimientosLD"));
                descripcion.add(rs.getString("descripcionTransaccion"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }  
        inforLibro.put("fecha", fechas);
        inforLibro.put("idMovimientos", movimientos);
        inforLibro.put("descripcion", descripcion);
        return inforLibro;
    }
        
        public String obtenerMovimiento(int id){
            String movimiento = "";
            String sql = "SELECT * FROM LIBRO_DIARIO WHERE id = ?";
        
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                movimiento = rs.getString("Codigo")+ "\t" + rs.getString("Descripcion");
                if(!"".equals(rs.getString("Debe"))){
                    movimiento += "\t" + rs.getString("Debe");
                }else{
                    movimiento += "\t" + "0";
                }
                if(!"".equals(rs.getString("Haber"))){
                    movimiento += "\t" + rs.getString("Haber");
                }else{
                    movimiento += "\t" + "0";
                }
               
               
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return movimiento;
        }
        
        


     public List<String> filtros(String ft) {
        List<String> cuentas = new ArrayList<>();
        
        String sql = "SELECT * FROM CATALOGO_DE_CUENTAS WHERE Codigo LIKE '"+ft+"%'";
        
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
    
    
    
     
public valoresBusqueda buscarNombreCuentaPorCodigo(String codigoIngresado) {
    valoresBusqueda valorBusqueda;
    HashMap<String, String> cuentas = new HashMap<>();
    List<String> nombreCuentas = new ArrayList<>();
    String sql = "SELECT Codigo, Cuenta FROM CATALOGO_DE_CUENTAS WHERE Cuenta LIKE '" + codigoIngresado + "%'";
   
    

    try (Connection conn = dbConnection.connect();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        if(rs.next()){
            cuentas.put(rs.getString("Cuenta"), rs.getString("Codigo"));
            nombreCuentas.add(rs.getString("Cuenta"));
            while (rs.next()) {
                cuentas.put(rs.getString("Cuenta"), rs.getString("Codigo"));
                nombreCuentas.add(rs.getString("Cuenta"));
            }
            conn.close();
            if(conn.isClosed()){
                System.out.println("Se cerro conexion");
            }
        }else{
            cuentas.put("Error", "No se encontro ninguna cuenta");
            nombreCuentas.add("No se encontro ninguna cuenta");
            valorBusqueda = new valoresBusqueda(cuentas,nombreCuentas);
            conn.close();
            return valorBusqueda;
        }    
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    valorBusqueda = new valoresBusqueda(cuentas,nombreCuentas);
    return valorBusqueda;
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
                conn.close();
                System.out.println("Datos guardados en la base de datos.");
                System.out.println(filasAfectadas);
            } else {
                conn.close();
                System.out.println("No se pudieron guardar los datos en la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar en la base de datos: " + e.getMessage());
        }
    }

    public List<List<Object>> libroDiario() { 
        String sql = "SELECT * FROM LIBRO_DIARIO";
        List<List<Object>> resultList = new ArrayList<>();

        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                List<Object> row = new ArrayList<>();
                row.add(rs.getInt("ID"));
                row.add(rs.getString("Fecha"));
                row.add(rs.getInt("codigo"));
                row.add(rs.getString("descripcion"));
                row.add(rs.getString("debe"));
                row.add(rs.getString("haber"));

                resultList.add(row);
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList; 
    }

    public String obtenerDescripcionPorId(int id) {
        String descripcion = null;
        String sql = "SELECT descripcion FROM LIBRO_DIARIO WHERE ID = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                descripcion = rs.getString("descripcion");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return descripcion;
    }



    public String obtenerFechaPorId(int id) {
        String fecha = null;
        String sql = "SELECT fecha FROM LIBRO_DIARIO WHERE ID = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                fecha = rs.getString("fecha");
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return fecha;
    }

    public void transacciones() {
        String sql = "SELECT * FROM TRANSACCIONES_LIBRO_DIARIO";

        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println(sql);

            while (rs.next()) {
                // Aquí puedes acceder a cada columna de la fila actual
                int id = rs.getInt("ID"); // Reemplaza "ID" con el nombre real de la columna
                String fecha = rs.getString("Fecha"); // Reemplaza "Fecha" con el nombre real de la columna
                // Y así sucesivamente para cada columna que desees mostrar
                String idMovimientosLD = rs.getString("idMovimientosLD"); // Nueva columna
                String descripcionTransaccion = rs.getString("descripcionTransaccion"); // Nueva columna

                // Imprimir los datos en la consola
                System.out.println("ID: " + id);
                System.out.println("Fecha: " + fecha);
                System.out.println("idMovimientosLD: " + idMovimientosLD); // Mostrar idMovimientosLD
                System.out.println("descripcionTransaccion: " + descripcionTransaccion); // Mostrar Descripcion

                // Imprime las demás columnas de la misma manera

                System.out.println(); // Separador entre registros
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public String retornarIDMayor(){
        String cuenta = "";
        String sql = "SELECT MAX(id) FROM LIBRO_DIARIO;";
        
        try (Connection conn = dbConnection.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                cuenta = rs.getString("MAX(id)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return cuenta; 
    }
    public void guardarEnBaseTransaccion(String fecha,String ids, String descripcion) {
        String sql = "INSERT INTO TRANSACCIONES_LIBRO_DIARIO (fecha,idMovimientosLD,descripcionTransaccion) VALUES (?, ?, ?)";
        
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fecha);
            pstmt.setString(2, ids);
            pstmt.setString(3, descripcion);
;
            
            int filasAfectadas = pstmt.executeUpdate();
            
            if (filasAfectadas > 0) {
                conn.close();
                System.out.println("Datos guardados en la base de datos.");
                System.out.println(filasAfectadas);
            } else {
                conn.close();
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
    
    public void guardarTransacciones(List<Integer> codigo, String descripcion){
         String sql = "INSERT INTO TRANSACCIONES_LIBRO_DIARIO (nCuenta, DescripcionTransaccion) VALUES (?, ?)";
            try (Connection conn = dbConnection.connect()) {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                for (int nCuenta : codigo) {
                    pstmt.setInt(1, nCuenta);
                    pstmt.setString(2, descripcion);
                    pstmt.executeUpdate(); // Ejecutar la inserción
                }
                System.out.println("Valores insertados correctamente.");
            }
            catch (SQLException e) {
                e.printStackTrace();
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

