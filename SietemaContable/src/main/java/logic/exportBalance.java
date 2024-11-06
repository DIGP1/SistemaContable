package logic;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;

public class exportBalance {

    /**
     * Método para eliminar las etiquetas HTML de un texto.
     * @param texto El texto con posibles etiquetas HTML.
     * @return El texto limpio sin etiquetas HTML.
     */
    private String eliminarEtiquetasHTML(String texto) {
        if (texto == null) {
            return "";
        }
        // Elimina las etiquetas HTML
        texto = texto.replaceAll("<.*?>", "");
        
        // Reemplaza entidades HTML conocidas
        texto = texto.replaceAll("&nbsp;", " "); 
        texto = texto.replaceAll("&lt;", "<");  
        texto = texto.replaceAll("&gt;", ">");   
        texto = texto.replaceAll("&amp;", "&");  

        return texto;
    }

    /**
     * Método para exportar una JTable a un archivo PDF.
     * @param table La JTable que se desea exportar.
     * @param nombreEmpresa El nombre de la empresa para agregar al PDF.
     * @param filePath La ruta donde se guardará el archivo PDF.
     */
    public void exportarTablaAPDF(JTable table, String nombreEmpresa, String filePath) {
        Document document = new Document();
        try {
            
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

           
            Font fontTitulo = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph titulo = new Paragraph("Balance General", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);
            
          
            Font fontEmpresa = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);
            Paragraph nombreE = new Paragraph(nombreEmpresa, fontEmpresa);
            nombreE.setAlignment(Element.ALIGN_CENTER);
            document.add(nombreE);

          
            Paragraph fecha = new Paragraph("Fecha: " + LocalDate.now(), FontFactory.getFont(FontFactory.HELVETICA, 12));
            fecha.setAlignment(Element.ALIGN_CENTER);
            document.add(fecha);

           
            document.add(new Paragraph(" "));
            
           
            TableModel model = table.getModel();

           
            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
            pdfTable.setWidthPercentage(100); 

           
            Font fontHeader = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12); 
            Font fontCell = FontFactory.getFont(FontFactory.HELVETICA, 10); 
         
            for (int i = 0; i < model.getColumnCount(); i++) {
                PdfPCell cell = new PdfPCell(new Paragraph(model.getColumnName(i), fontHeader));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(cell);
            }

           
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object cellValue = model.getValueAt(row, col);
                    String cellText = cellValue != null ? cellValue.toString() : "";

                 
                    String cleanedValue = eliminarEtiquetasHTML(cellText);

                    PdfPCell cell = new PdfPCell(new Paragraph(cleanedValue, fontCell));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
            }

          
            document.add(pdfTable);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            // Cierra el documento al final
            document.close();
        }
    }
}
