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
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class exportBalance {

    /**
     * Método para eliminar las etiquetas HTML de un texto.
     *
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
     *
     * @param table         La JTable que se desea exportar.
     * @param nombreEmpresa El nombre de la empresa para agregar al PDF.
     * @param filePath      La ruta donde se guardará el archivo PDF.
     */
    public void exportarTablaAPDF(JTable table, String nombreEmpresa, String filePath) {
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Font fontEmpresa = FontFactory.getFont(FontFactory.TIMES_BOLD, 14);
            Paragraph nombreE = new Paragraph(nombreEmpresa, fontEmpresa);
            nombreE.setAlignment(Element.ALIGN_CENTER);
            document.add(nombreE);

            Font fontTitulo = FontFactory.getFont(FontFactory.TIMES_BOLD, 16);
            Paragraph titulo = new Paragraph("Balance General", fontTitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            document.add(titulo);


            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd 'de' MMMM 'del' yyyy", new Locale("es", "ES"));
            String formattedDate = "Del 01 de enero del " + LocalDate.now().getYear() + " a " + LocalDate.now().format(formatter);

            Paragraph fecha = new Paragraph(formattedDate, FontFactory.getFont(FontFactory.HELVETICA, 12));
//            Paragraph fecha = new Paragraph("Del: 01 de Enero de " + LocalDate.now(), FontFactory.getFont(FontFactory.HELVETICA, 12));
            fecha.setAlignment(Element.ALIGN_CENTER);
            document.add(fecha);

            document.add(new Paragraph(" "));

            TableModel model = table.getModel();

            PdfPTable pdfTable = new PdfPTable(model.getColumnCount());
            pdfTable.setWidthPercentage(100);


            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 12);
            Font fontCell = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

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
                    String formattedValue;

                    try {
                        double number = Double.parseDouble(cleanedValue);
                        formattedValue = new DecimalFormat("#.##").format(number);
                    } catch (NumberFormatException e) {
                        // If the value is not a number, use the cleaned value as is
                        formattedValue = cleanedValue;
                    }

                    PdfPCell cell = new PdfPCell(new Paragraph(formattedValue, fontCell));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
            }


            document.add(pdfTable);

            // Crear una tabla con dos celdas para las firmas
            PdfPTable tablaFirmas = new PdfPTable(3);
            tablaFirmas.setWidthPercentage(100);
            tablaFirmas.setSpacingBefore(150f);

            // Celda para la firma del auditor interno
            PdfPCell celdaFirmaAuditor = new PdfPCell(new Paragraph("Auditor Interno", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12)));
            celdaFirmaAuditor.setHorizontalAlignment(Element.ALIGN_LEFT);
            celdaFirmaAuditor.setBorder(PdfPCell.NO_BORDER);
            tablaFirmas.addCell(celdaFirmaAuditor);

            // Celda para la firma del contador
            PdfPCell celdaFirmaContador = new PdfPCell(new Paragraph("Contador", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12)));
            celdaFirmaContador.setHorizontalAlignment(Element.ALIGN_CENTER);
            celdaFirmaContador.setBorder(PdfPCell.NO_BORDER);
            tablaFirmas.addCell(celdaFirmaContador);

            // Celda para la firma del director de recursos financieros
            PdfPCell celdaFirmaDirectorInterno = new PdfPCell(new Paragraph("Director de Recursos Financieros", FontFactory.getFont(FontFactory.TIMES_ROMAN, 12)));
            celdaFirmaDirectorInterno.setHorizontalAlignment(Element.ALIGN_RIGHT);
            celdaFirmaDirectorInterno.setBorder(PdfPCell.NO_BORDER);
            tablaFirmas.addCell(celdaFirmaDirectorInterno);

            // Agregar la tabla de firmas al documento
            document.add(tablaFirmas);

        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        } finally {
            // Cierra el documento al final
            document.close();
        }
    }
}
