/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 * @author Isaac
 */

import form.LibroMayor;
import logic.passwordmanagement.PasswordVerify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CatalogoDeCuentasDatos {
    private DatabaseConnection dbConnection = new DatabaseConnection();

    public List<String> listarCuentas(int empresa_id) {
        List<String> cuentas = new ArrayList<>();

        String sql = "SELECT * FROM tbl_catalogo_de_cuentas WHERE empresa_id = "+empresa_id;

        try (Connection conn = dbConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String cuenta = rs.getString("Codigo") + "\t" + rs.getString("Cuenta");
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cuentas;
    }

    public List<RegistrosContables> CargarLibroDiario(int empresa_id) {
        List<RegistrosContables> data = new ArrayList<>();
       String sql = """
                select \
                    tbl_catalogo_de_cuentas.codigo as codigo, \
                    tbl_transacciones_libro_diario.fecha                   as fecha, \
                    tbl_libro_diario.Debe                                  as debe, \
                    tbl_libro_diario.Haber                                 as haber, \
                    tbl_catalogo_de_cuentas.cuenta as cuenta, \
                    tbl_transacciones_libro_diario.descripcion_transaccion as descripcion \
                from tbl_transacciones_libro_diario
                inner join tbl_libro_diario on tbl_transacciones_libro_diario.id_movimiento = tbl_libro_diario.id_movimiento
                inner join tbl_catalogo_de_cuentas on tbl_libro_diario.id_cuenta = tbl_catalogo_de_cuentas.id
                where tbl_transacciones_libro_diario.empresa_id = ?;
                """;
        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empresa_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String fecha = rs.getString("fecha");
                String codigo = rs.getString("codigo");
                String cuenta = rs.getString("cuenta");
                String debe = rs.getString("debe");
                String haber = rs.getString("haber");
                String descripcionTransaccion = rs.getString("descripcion");
                System.out.println(cuenta);
                if (debe.isEmpty()) {
                    debe = "0";
                }

                if (haber.isEmpty()) {
                    haber = "0";
                }

                RegistrosContables registro = new RegistrosContables(fecha, codigo, cuenta, debe, haber, descripcionTransaccion);
                System.out.println(registro);
                data.add(registro);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    public String obtenerMovimiento(int id, int empresa_id) {
        String movimiento = "";
        String sql = "SELECT * FROM tbl_libro_diario WHERE id = ? AND empresa_id = ?";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, empresa_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                movimiento = rs.getString("Codigo") + "\t" + rs.getString("Descripcion");
                if (!"".equals(rs.getString("Debe"))) {
                    movimiento += "\t" + rs.getString("Debe");
                } else {
                    movimiento += "\t" + "0";
                }
                if (!"".equals(rs.getString("Haber"))) {
                    movimiento += "\t" + rs.getString("Haber");
                } else {
                    movimiento += "\t" + "0";
                }
            }

            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return movimiento;
    }


    public List<String> filtros(String ft, int empresa_id) {
        List<String> cuentas = new ArrayList<>();

        String sql = "SELECT * FROM tbl_catalogo_de_cuentas WHERE Codigo LIKE '" + ft + "%' AND empresa_id = "+empresa_id;

        try (Connection conn = dbConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String cuenta = rs.getString("codigo") + "\t" + rs.getString("cuenta");
                cuentas.add(cuenta);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cuentas;
    }


    public valoresBusqueda buscarNombreCuentaPorCodigo(String codigoIngresado, boolean codigoCuenta, int empresa_id) {
        valoresBusqueda valorBusqueda;
        HashMap<String, String> cuentas = new HashMap<>();
        List<String> nombreCuentas = new ArrayList<>();
        String sql;
        if(codigoCuenta){
            sql = "SELECT Codigo, Cuenta FROM tbl_catalogo_de_cuentas WHERE Codigo LIKE '" + codigoIngresado + "%' AND empresa_id = "+empresa_id;
        }else{
            sql = "SELECT Codigo, Cuenta FROM tbl_catalogo_de_cuentas WHERE cuenta LIKE '" + codigoIngresado + "%' AND empresa_id = "+empresa_id;
        }
        try (Connection conn = dbConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                cuentas.put(rs.getString("cuenta"), rs.getString("codigo"));
                nombreCuentas.add(rs.getString("cuenta"));
                while (rs.next()) {
                    cuentas.put(rs.getString("cuenta"), rs.getString("codigo"));
                    nombreCuentas.add(rs.getString("cuenta"));
                }
                conn.close();
                if (conn.isClosed()) {
                    System.out.println("Se cerro conexion");
                }
            } else {
                cuentas.put("Error", "No se encontro ninguna cuenta");
                nombreCuentas.add("No se encontro ninguna cuenta");
                valorBusqueda = new valoresBusqueda(cuentas, nombreCuentas);
                conn.close();
                return valorBusqueda;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        valorBusqueda = new valoresBusqueda(cuentas, nombreCuentas);
        return valorBusqueda;
    }

    public void guardarEnBaseDeDatos(String fecha, String Codigo, String Descripcion, String Debe, String Haber, int empresa_id) {
        int id_movimiento = getLastIdMovimiento() + 1;
        int id_cuenta = getAccountId(Codigo, empresa_id);
        saveLibroDiario(Debe, Haber, id_cuenta, id_movimiento, empresa_id);
        
        /*String sql = "INSERT INTO LIBRO_DIARIO (Fecha,Codigo,Descripcion,  Debe, Haber) VALUES (?, ?, ?, ?,?)";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
        }*/
    }

    private void saveTransaction(String fecha, String Descripcion, int lastId, int empresa_id) {
        String sql = "INSERT INTO tbl_transacciones_libro_diario (fecha,descripcion_transaccion, id_movimiento, empresa_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fecha);
            pstmt.setString(2, Descripcion);
            pstmt.setInt(3, lastId);
            pstmt.setInt(4, empresa_id);

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

    private void saveLibroDiario(String debe, String haber, int id_cuenta, int id_movimiento, int empresa_id) {
        String sql = "INSERT INTO tbl_libro_diario (debe, haber, id_cuenta, id_movimiento, empresa_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, debe);
            pstmt.setString(2, haber);
            pstmt.setInt(3, id_cuenta);
            pstmt.setInt(4, id_movimiento);
            pstmt.setInt(5, empresa_id);

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

    private int getLastIdMovimiento() {
        String sql = "SELECT MAX(id_movimiento) FROM tbl_transacciones_libro_diario";
        int lastId = 0;

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                lastId = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el último id_movimiento: " + e.getMessage());
        }

        return lastId;
    }

    private int getAccountId(String accountCode, int empresa_id) {
        String sql = "SELECT id FROM tbl_catalogo_de_cuentas WHERE codigo = '" + accountCode + "'AND empresa_id = "+ empresa_id;
        int code = 0;

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            if (rs.next()) {
                code = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el último id_movimiento: " + e.getMessage());
        }

        return code;
    }

    public List<List<Object>> libroDiario(int empresa_id) {
        String sql = """
                select \
                    tbl_libro_diario.id as id, \
                    tbl_catalogo_de_cuentas.codigo as codigo, \
                    tbl_transacciones_libro_diario.fecha                   as fecha, \
                    tbl_libro_diario.Debe                                  as debe, \
                    tbl_libro_diario.Haber                                 as haber, \
                    tbl_catalogo_de_cuentas.cuenta as cuenta, \
                    tbl_transacciones_libro_diario.descripcion_transaccion as descripcion \
                from tbl_transacciones_libro_diario
                inner join tbl_libro_diario on tbl_transacciones_libro_diario.id_movimiento = tbl_libro_diario.id_movimiento
                inner join tbl_catalogo_de_cuentas on tbl_libro_diario.id_cuenta = tbl_catalogo_de_cuentas.id
                where tbl_libro_diario.empresa_id = ?;
                """;
        List<List<Object>> resultList = new ArrayList<>();

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, empresa_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                List<Object> row = new ArrayList<>();
                row.add(rs.getInt("id"));
                row.add(rs.getString("Fecha"));
                row.add(rs.getInt("codigo"));
                row.add(rs.getString("cuenta"));
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

   /* public String obtenerDescripcionPorId(int id) {
        String descripcion = null;
        String sql = "SELECT descripcion FROM LIBRO_DIARIO WHERE ID = ?";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
    */

   /* public String obtenerFechaPorId(int id) {
        String fecha = null;
        String sql = "SELECT fecha FROM LIBRO_DIARIO WHERE ID = ?";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
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
        */
   /* public void transacciones(int empresa_id) {
        String sql = "SELECT * FROM tbl_transacciones_libro_diario WHERE empresa_id = "+empresa_id;

        try (Connection conn = dbConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println(sql);

            while (rs.next()) {
                // Aquí puedes acceder a cada columna de la fila actual
                int id = rs.getInt("ID"); // Reemplaza "ID" con el nombre real de la columna
                String fecha = rs.getString("Fecha"); // Reemplaza "Fecha" con el nombre real de la columna
                // Y así sucesivamente para cada columna que desees mostrar
                String idMovimientosLD = rs.getString("id_movimiento"); // Nueva columna
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
    }*/


    public String retornarIDMayor() {
        String cuenta = "";
        String sql = "SELECT MAX(id) FROM tbl_libro_diario;";

        try (Connection conn = dbConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                cuenta = rs.getString("MAX(id)");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return cuenta;
    }

    public void guardarEnBaseTransaccion(String fecha, String ids, String descripcion, int empresa_id) {
        int id_movimiento = getLastIdMovimiento() + 1;
        saveTransaction(fecha, descripcion, id_movimiento, empresa_id);
        
        /*String sql = "INSERT INTO tbl_transacciones_libro_diario (fecha,idMovimientosLD,descripcionTransaccion) VALUES (?, ?, ?)";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fecha);
            pstmt.setString(2, ids);
            pstmt.setString(3, descripcion);

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
        }*/
    }

    public boolean registrarUsuario(String username, String pass, int rol, String Nombre) {

        boolean usuarioEncontrado = false;
        String sql = "SELECT username FROM tbl_usuarios WHERE username = '" + username + "'";
        try (Connection conn = dbConnection.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {

            if (rs.next()) {
                usuarioEncontrado = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        if (usuarioEncontrado) {
            JOptionPane.showMessageDialog(
                    null,
                    "El nombre de usuario ya existe",
                    "ERROR",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        } else {
            String sql1 = "INSERT INTO tbl_usuarios (username, password, nombrecompleto, rol_id) VALUES (?,?,?,?)";
            try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql1)) {
                pstmt.setString(1, username);
                pstmt.setString(2, pass);
                pstmt.setString(3, Nombre);
                pstmt.setInt(4, rol);
                int filasAfectadas = pstmt.executeUpdate();

                if (filasAfectadas > 0) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Usuario registrado correctamente",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                    return true;
                } else {
                    System.out.println("No se pudieron guardar los datos en la base de datos.");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Error al guardar en la base de datos: " + e.getMessage());
            }
        }
        
        return false;
    }

   /* public void guardarTransacciones(List<Integer> codigo, String descripcion) {
        String sql = "INSERT INTO tbl_transacciones_libro_diario (nCuenta, DescripcionTransaccion) VALUES (?, ?)";
        try (Connection conn = dbConnection.connect()) {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            for (int nCuenta : codigo) {
                pstmt.setInt(1, nCuenta);
                pstmt.setString(2, descripcion);
                pstmt.executeUpdate(); // Ejecutar la inserción
            }
            System.out.println("Valores insertados correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/


    public boolean verificacionAdmin(String username, String password) {
        if (!getUserPassword(username)) {
            JOptionPane.showMessageDialog(null,
                    "El usuario no existe",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        String sql = "SELECT password, rol_id FROM tbl_usuarios WHERE username = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String encryptedPassword = rs.getString("password");
                boolean passwordMatches = PasswordVerify.verify(password, encryptedPassword);
                if (!passwordMatches) {
                    JOptionPane.showMessageDialog(null,
                            "Contraseña incorrecta",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return false; // Contraseña incorrecta
                }

                String rol = rs.getString("rol_id");
                if (rol.equals("1")) {
                    return true; // El usuario es administrador
                } else {
                    JOptionPane.showMessageDialog(null,
                            "El usuario no es administrador",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return false; // El usuario no es administrador
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false; // Fallback en caso de error
    }


    public boolean login(String username, String password) {
        if (!getUserPassword(username)) {
            JOptionPane.showMessageDialog(null,
                    "El usuario no existe",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        String sql = "SELECT password FROM tbl_usuarios WHERE username = ?";

        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String encryptedPassword = rs.getString("password");
                boolean passwordMatches = PasswordVerify.verify(password, encryptedPassword);
                if (!passwordMatches) {
                    JOptionPane.showMessageDialog(null,
                            "Contraseña incorrecta",
                            "Error",
                            JOptionPane.ERROR_MESSAGE
                    );
                    return false;
                }
                return true; // Login successful
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false; // Fallback
    }

    private boolean getUserPassword(String username) {
        String sql = "SELECT username FROM tbl_usuarios WHERE username = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next(); // Returns true if user exists
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public List<String> getUserFullName(String username) {
        List<String> infoUser = new ArrayList<String>();
        String sql = "SELECT nombrecompleto, id FROM tbl_usuarios WHERE username = ?";
        try (Connection conn = dbConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                infoUser.add(rs.getString("nombrecompleto"));
                infoUser.add(String.valueOf(rs.getInt("id")));
                return infoUser;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void guardarTransaccionCatalogoCuentas(String Codigo, String Cuenta, double Saldo, int empresa_id) {
        String sql = "INSERT INTO tbl_catalogo_de_cuentas (codigo, cuenta, Saldo, empresa_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = dbConnection.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Codigo);
            pstmt.setString(2, Cuenta);
            pstmt.setDouble(3, Saldo);
            pstmt.setInt(4, empresa_id);

            int filasAfectadas = pstmt.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Datos de transacción guardados en la tabla CATALOGO_CUENTAS.");
            } else {
                System.out.println("No se pudieron guardar los datos en la tabla CATALOGO_CUENTAS.");
            }
        } catch (SQLException e) {
            System.out.println("Error al guardar la transacción en la tabla CATALOGO_CUENTAS: " + e.getMessage());
        }
    }
}
