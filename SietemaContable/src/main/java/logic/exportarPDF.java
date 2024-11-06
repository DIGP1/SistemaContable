package logic;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;

public class exportarPDF {

    public void exportarPDF(String ruta, String nombreEmpresa, JTable tabla) throws FileNotFoundException {
        Document documento = new Document();
        try {
        
            PdfWriter.getInstance(documento, new FileOutputStream(ruta));
            documento.open();

      
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fechaActual = dateFormat.format(new Date());

          
            Paragraph nombreL = new Paragraph("LIBRO DIARIO", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            nombreL.setAlignment(Element.ALIGN_CENTER);
            documento.add(nombreL);

       
            Paragraph nombreE = new Paragraph( nombreEmpresa, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14));
            nombreE.setAlignment(Element.ALIGN_CENTER);
            documento.add(nombreE);

           
            documento.add(new Paragraph(" "));

         
            Paragraph fecha = new Paragraph("Fecha: " + fechaActual, FontFactory.getFont(FontFactory.HELVETICA, 12));
            fecha.setAlignment(Element.ALIGN_RIGHT);
            documento.add(fecha);

            
            documento.add(new Paragraph(" "));

           
            PdfPTable pdfTable = new PdfPTable(tabla.getColumnCount());
            pdfTable.setWidthPercentage(100);  

           
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                PdfPCell headerCell = new PdfPCell(new Phrase(tabla.getColumnName(i), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
                headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                headerCell.setBackgroundColor(new com.itextpdf.text.BaseColor(220, 220, 220));
                pdfTable.addCell(headerCell);
            }

         
            for (int rows = 0; rows < tabla.getRowCount(); rows++) {
                for (int cols = 0; cols < tabla.getColumnCount(); cols++) {
                    PdfPCell dataCell = new PdfPCell(new Phrase(tabla.getValueAt(rows, cols).toString(), FontFactory.getFont(FontFactory.HELVETICA, 10)));
                    dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(dataCell);
                }
            }

       
            documento.add(pdfTable);

           
            documento.add(new Paragraph(" "));

          
            Paragraph firmaParrafo = new Paragraph("Firma: _______________________________", FontFactory.getFont(FontFactory.HELVETICA, 12));
            firmaParrafo.setAlignment(Element.ALIGN_CENTER);
            documento.add(firmaParrafo);

          
            Paragraph empresaParrafo = new Paragraph(nombreEmpresa, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12));
            empresaParrafo.setAlignment(Element.ALIGN_CENTER);
            documento.add(empresaParrafo);

        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
           
            documento.close();
        }
    }
}
