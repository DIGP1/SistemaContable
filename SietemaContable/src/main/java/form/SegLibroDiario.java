package form;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import logic.CatalogoDeCuentasDatos;
import logic.RegistrosContables;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */

/**
 * @author EstudianteFMO
 */
public class SegLibroDiario extends javax.swing.JPanel {
    private int empresa_id =1;
    /**
     * Creates new form SegLibroDiario
     */
    public SegLibroDiario() {
        initComponents();
        CatalogoDeCuentasDatos cc = new CatalogoDeCuentasDatos();
        Map<Integer, List<RegistrosContables>> inforLibro = new HashMap<>();
        inforLibro = cc.CargarLibroDiario(empresa_id);
        ingresarDatosTabla(inforLibro);


        TableRowSorter<TableModel> filaFiltrada = new TableRowSorter<>(jTable1.getModel());
        jTable1.setRowSorter(filaFiltrada);

        txtBuscar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                applyFilter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                applyFilter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                applyFilter();
            }

            private void applyFilter() {
                String text = txtBuscar.getText();
                int columnIndex = cbfiltrado.getSelectedIndex();
                if (text.trim().length() == 0) {
                    filaFiltrada.setRowFilter(null);
                } else {
                    // Filtrar por la columna seleccionada sin distinguir mayúsculas y minúsculas
                    filaFiltrada.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(text), columnIndex));
                }
            }
        });

    }

    public void ingresarDatosTabla(Map<Integer, List<RegistrosContables>> info) {
        CatalogoDeCuentasDatos cc = new CatalogoDeCuentasDatos();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        for (Map.Entry<Integer, List<RegistrosContables>> entry : info.entrySet()) {
            List<RegistrosContables> value = entry.getValue();
            for (RegistrosContables registrosContables : value) {
                model.addRow(new Object[]{registrosContables.getFecha(), registrosContables.getDescripcion(), registrosContables.getCodigo(), registrosContables.getDebe(), registrosContables.getHaber()});
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cbfiltrado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        jScrollPane2.setViewportView(jTable2);

        setBackground(new java.awt.Color(245, 245, 220));
        setMaximumSize(new java.awt.Dimension(911, 310));
        setPreferredSize(new java.awt.Dimension(911, 310));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{

        }, new String[]{"Fecha", "Descripcion", "Codigo", "Debe", "Haber"}) {
            boolean[] canEdit = new boolean[]{false, false, false, false, false};

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(6);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(200);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(7);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(5);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("LIBRO DIARIO");

        cbfiltrado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Fecha", "Descripcion", "Codigo"}));
        cbfiltrado.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                cbfiltradoComponentShown(evt);
            }
        });

        jLabel2.setText("Filtrar por:");

        jLabel3.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(409, 409, 409).addComponent(jLabel1)).addGroup(layout.createSequentialGroup().addGap(143, 143, 143).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(cbfiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel3).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))).addContainerGap(81, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(cbfiltrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(jLabel2).addComponent(jLabel3).addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap()));
    }// </editor-fold>//GEN-END:initComponents

    private void cbfiltradoComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_cbfiltradoComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_cbfiltradoComponentShown


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbfiltrado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
