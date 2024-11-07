/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package logic;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DatabaseConnection {
    private Connection conn = null;

    public Connection connect() {
        try {
            // Obtener la ruta del directorio de Documentos del usuario
            String userHome = System.getProperty("user.home");
            File documentsDirectory = new File(userHome, "Documents");

            // Crear la subcarpeta "Data" dentro de Documentos si no existe
            File directory = new File(documentsDirectory, "Sistema Contable");
            if (!directory.exists()) {
                directory.mkdirs(); // Crear la subcarpeta
                System.out.println("Subcarpeta 'Data' creada en Documentos.");
            }

            // Ruta para la base de datos en la subcarpeta "Data"
            File dbFile = new File(directory, "catalogo.db");

            // Si el archivo no existe, copiarlo desde el JAR
            if (!dbFile.exists()) {
                try (InputStream is = getClass().getResourceAsStream("/catalogo.db");
                     FileOutputStream fos = new FileOutputStream(dbFile)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, length);
                    }
                } catch (IOException e) {
                    System.out.println("Error al copiar la base de datos: " + e.getMessage());
                }
            }

            // Conectar a la base de datos en la nueva ubicación
            String jdbcUrl = "jdbc:sqlite:" + dbFile.getAbsolutePath();
            conn = DriverManager.getConnection(jdbcUrl);
            System.out.println("Conexión a SQLite establecida.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}


