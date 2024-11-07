/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private Connection conn = null;

    public Connection connect() {
        try {
            // Cargar el archivo de la base de datos desde el JAR (ubicado en resources)
            InputStream dbStream = getClass().getResourceAsStream("/catalogo.db");

            if (dbStream == null) {
                JOptionPane.showMessageDialog(null, "Base de datos no encontrada en recursos.", 
                                              "Error de Conexión", JOptionPane.ERROR_MESSAGE);
                throw new IOException("Base de datos no encontrada en recursos.");
            }

            // Crear un archivo temporal para la base de datos
            File tempDbFile = File.createTempFile("catalogo", ".db");
            tempDbFile.deleteOnExit(); // Eliminar el archivo temporal al salir

            // Copiar el archivo de la base de datos desde los recursos al archivo temporal
            Files.copy(dbStream, tempDbFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Conectar a la base de datos usando el archivo temporal
            String jdbcUrl = "jdbc:sqlite:" + tempDbFile.getAbsolutePath();
            conn = DriverManager.getConnection(jdbcUrl);
            System.out.println("Conexión a SQLite establecida.");

        } catch (SQLException | IOException e) {
            System.out.println("Error en la conexión a la base de datos: " + e.getMessage());
        }
        return conn;
    }
}
