/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author angel
 */

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class excel {
    
    
        
    public List<Object[]> importarExcel(JTable tabla) throws IOException {
    List<Object[]> datosExcel = new ArrayList<>();  // Lista para almacenar los datos del Excel

    JFileChooser fileChooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel (.xlsx)", "xlsx");
    fileChooser.setFileFilter(filter);
    fileChooser.setDialogTitle("SELECCIONA UN ARCHIVO EXCEL");

    int seleccion = fileChooser.showOpenDialog(null);

    if (seleccion == JFileChooser.APPROVE_OPTION) {
        File archivo = fileChooser.getSelectedFile();

        if (!archivo.getAbsolutePath().endsWith(".xlsx")) {
            throw new IOException("selecciona un archivo con extensión .xlsx");
        }

        FileInputStream fileInputStream = new FileInputStream(archivo);
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            if (row != null) {
                Object[] fila = new Object[row.getLastCellNum()];
                boolean filaVacia = true;

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);

                    if (cell != null) {
                        switch (cell.getCellType()) {
                            case STRING:
                                fila[j] = cell.getStringCellValue();
                                filaVacia = false;
                                break;
                            case NUMERIC:
                                fila[j] = cell.getNumericCellValue();
                                filaVacia = false;
                                break;
                            case BOOLEAN:
                                fila[j] = cell.getBooleanCellValue();
                                filaVacia = false;
                                break;
                            default:
                                fila[j] = "";
                        }
                    } else {
                        fila[j] = "";
                    }
                }

                if (!filaVacia) {
                    model.addRow(fila);  // Agregar a la JTable
                    datosExcel.add(fila);  // Agregar a la lista de datos
                }
            }
        }

        fileInputStream.close();
    }

    return datosExcel;  // Devuelve la lista de filas
}
}