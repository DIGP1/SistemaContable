/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

/**
 *
 * @author angel
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JTable;
public class exportarPDF {
    
    
    public void exportarJTableAPDF(JTable tabla, String ruta) throws FileNotFoundException {
        Document documento = new Document();
        
        try {
           
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();
            
           
            PdfPTable tablaPDF = new PdfPTable(tabla.getColumnCount());
            
        //columnas
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                tablaPDF.addCell(new PdfPCell(new Phrase(tabla.getColumnName(i))));
            }
            
         //filas
            for (int filas = 0; filas < tabla.getRowCount(); filas++) {
                for (int columnas = 0; columnas < tabla.getColumnCount(); columnas++) {
                    tablaPDF.addCell(new PdfPCell(new Phrase(tabla.getValueAt(filas, columnas).toString())));
                }
            }
            
          
            documento.add(tablaPDF);
            documento.close();
            
            System.out.println("PDF guardado correctamente en " + ruta);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

