/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;



import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.HashMap;
import com.toedter.calendar.JDateChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import logic.CatalogoDeCuentasDatos;
import logic.valoresBusqueda;
/**
 *
 * @author diegorro
 */
public class libroDiario extends javax.swing.JPanel {
private CatalogoDeCuentasDatos catalogoDeCuentasDatos;
public valoresBusqueda valor;
   
public libroDiario() {
        initComponents();
        crearModelo();
        java.util.Date fechaActual = new Date();
        fecha.setDate(fechaActual);
        fecha.setDateFormatString("dd/MM/yyyy");
        deb.setEnabled(false);
        hber.setEnabled(false);
        jList1.setVisible(false);
        jScrollPane3.setVisible(false);
        btnGuardarEnLibroMayor.enable(false);
        catalogoDeCuentasDatos = new CatalogoDeCuentasDatos();
        
        
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = jComboBox1.getSelectedItem().toString();
                    if ("Debe".equals(selectedOption)) {
                        deb.setEnabled(true);  // Habilitar "Debe"
                        hber.setEnabled(false); // Deshabilitar "Haber"
                    } else if ("Haber".equals(selectedOption)) {
                        deb.setEnabled(false); // Deshabilitar "Debe"
                        hber.setEnabled(true);  // Habilitar "Haber"
                    } else if ("-".equals(selectedOption)){
                        deb.setEnabled(false);  // Habilitar ambos
                        hber.setEnabled(false);
                    }
                }
            }
        });
         jList1.addListSelectionListener(e -> {
            if (!jList1.isSelectionEmpty()) {
                String valorSeleccionado = jList1.getSelectedValue();
                HashMap<String, String> cuentas = valor.getCuentas();
                codigo.setText(cuentas.get(valorSeleccionado));
                des.setText(valorSeleccionado);
                txtbuscarCuenta.setText(valorSeleccionado);
                jList1.setVisible(false);
                jScrollPane3.setVisible(false);
            }
        });
    txtbuscarCuenta.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent e) {
        buscarNombreCuenta();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        buscarNombreCuenta();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        buscarNombreCuenta();
    }

    private void buscarNombreCuenta() {
        buscarEnBase(txtbuscarCuenta.getText());
    }
    private void buscarEnBase(String Dato){
        
        if("".equals(Dato)){
            jList1.setVisible(false);
            jScrollPane3.setVisible(false);
        }else{
            String codigoIngresado = Dato.trim();
        
           valor = catalogoDeCuentasDatos.buscarNombreCuentaPorCodigo(codigoIngresado);
            DefaultListModel<String> modeloLista = new DefaultListModel<>();
            for(String elemento : valor.getNombreCuentas()){
                modeloLista.addElement(elemento);
            }

            if (valor.getNombreCuentas() != null) {

                jList1.setModel(modeloLista);
                jList1.setVisible(true);
                jScrollPane3.setVisible(true);
            } else {
                des.setText(""); 
                jList1.setVisible(false);
                jScrollPane3.setVisible(false);
            }
        }
    }
});
    
}
    public void crearModelo(){
        String[] columnNames = {"Fecha", "Cuenta", "Ref", "Debe", "Haber"};

        // Crear un modelo de datos no editable
        DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Desactiva la edición de todas las celdas
                return false;
            }
        };
            tabla1.setModel(model);
    }
    public void limpiarTextBox(){
        txtbuscarCuenta.setText("");
        codigo.setText("");
        des.setText("");
        deb.setText("");
        hber.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        des = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        deb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        hber = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        lblDebe = new javax.swing.JLabel();
        lblHaber = new javax.swing.JLabel();
        btnGuardarEnLibroMayor = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtbuscarCuenta = new javax.swing.JTextField();
        fecha = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(245, 245, 220));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Cuenta", "Ref", "Debe", "Haber"
            }
        ));
        jScrollPane1.setViewportView(tabla1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 480, -1));

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setVisibleRowCount(5);
        jScrollPane3.setViewportView(jList1);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 184, 90));

        jLabel1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Libro Diario");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 168, -1));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Cuenta");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        des.setEditable(false);
        add(des, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 184, -1));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ref");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        codigo.setEditable(false);
        add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 181, -1));

        jLabel4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel4.setText("Debe");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, -1, -1));
        add(deb, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 184, -1));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel5.setText("Haber");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));
        add(hber, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, 184, -1));

        guardar.setBackground(new java.awt.Color(0, 153, 51));
        guardar.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        guardar.setText("Registrar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });
        add(guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 400, 144, 43));

        jButton2.setBackground(new java.awt.Color(0, 153, 102));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jButton2.setText("Crear Cuenta");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 80, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Debe", "Haber" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Fecha");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, 30));

        lblDebe.setText("$0.00");
        lblDebe.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lblDebePropertyChange(evt);
            }
        });
        add(lblDebe, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 560, -1, -1));

        lblHaber.setText("$0.00");
        add(lblHaber, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 560, -1, -1));

        btnGuardarEnLibroMayor.setBackground(new java.awt.Color(0, 153, 102));
        btnGuardarEnLibroMayor.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        btnGuardarEnLibroMayor.setText("Guardar Transacción");
        btnGuardarEnLibroMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarEnLibroMayorActionPerformed(evt);
            }
        });
        add(btnGuardarEnLibroMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Buscar Cuenta");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));
        add(txtbuscarCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 184, -1));

        fecha.setMaxSelectableDate(new java.util.Date(253370790065000L));
        add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 184, 30));

        getAccessibleContext().setAccessibleParent(this);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        // TODO add your handling code here:
        catalogoDeCuentasDatos = new CatalogoDeCuentasDatos();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fe= formato.format(fecha.getDate());
            String codigoCuenta = codigo.getText();
            String descripcion = des.getText();
            String debe = deb.getText();
            String haber = hber.getText();
            
            if(!"".equals(fe) && !"".equals(codigoCuenta) && !"".equals(descripcion) && !"".equals(debe) || !"".equals(haber)){
                //catalogoDeCuentasDatos.guardarEnBaseDeDatos(fe,codigoCuenta, descripcion, debe, haber);
                
                des.setText("");
                codigo.setText("");
                deb.setText("");
                hber.setText("");
                txtbuscarCuenta.setText("");
                DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();
                Object[] fila = {fe,descripcion, codigoCuenta, debe, haber};
                modelo.addRow(fila);
                float a = 0;
                float b = 0;
                for(int i = 0; i<modelo.getRowCount(); i++){
                    if(!"".equals(modelo.getValueAt(i,3).toString())){
                        String numeroDebe = modelo.getValueAt(i,3).toString();
                        a = a + Float.parseFloat(numeroDebe);
                    }
                    if(!"".equals(modelo.getValueAt(i,4).toString())){
                        String numeroHaber = modelo.getValueAt(i, 4).toString();
                        b = b + Float.parseFloat(numeroHaber);
                    }
                }
                lblDebe.setText("$ "+a);
                lblHaber.setText("$ "+b);
            }else{
                JOptionPane.showMessageDialog(null, "Debe de rellenar todos los campos :) no zsea gei","ERROR",JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_guardarActionPerformed

    private void btnGuardarEnLibroMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarEnLibroMayorActionPerformed
        // TODO add your handling code here:
        if(lblDebe.getText().equals(lblHaber.getText()) && !"$0.00".equals(lblHaber.getText()) && !"$0.00".equals(lblDebe.getText())){
            List<String> ids = new ArrayList();
            int filas = tabla1.getRowCount();
            int columnas = tabla1.getColumnCount();
            //List<Integer> nCuentas = new ArrayList<>();
            for (int i = 0; i < filas; i++) {
                String fechaString = "";
                String codigoTablaString = "";
                String Descripcion = "";
                String debe = "";
                String haber = "";
                for (int j = 0; j < columnas; j++) {
                    Object valorTabla = tabla1.getValueAt(i, j);
                    // Asigna el valor a la variable correspondiente según la columna
                    switch (j) {
                        case 0 -> fechaString = valorTabla.toString();
                        case 1 -> Descripcion = valorTabla.toString();
                        case 2 -> codigoTablaString = valorTabla.toString();
                        case 3 -> debe = valorTabla.toString();
                        case 4 -> haber = valorTabla.toString();
                    }
                }
                catalogoDeCuentasDatos.guardarEnBaseDeDatos(fechaString,codigoTablaString, Descripcion, debe, haber);
                ids.add(catalogoDeCuentasDatos.retornarIDMayor());
                //nCuentas.add(Integer.parseInt(codigoTablaString));
            }
            String idTransacciones = "";
            for (String id: ids) {
                idTransacciones += id+",";
            }
            idTransacciones.substring(0, idTransacciones.length()-1);
            
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fe= formato.format(fecha.getDate());
            boolean flag = true;
            while (flag) {                
                String descripcion= JOptionPane.showInputDialog(null, " Ingrese la descripcion de la transacción");
                if("".equals(descripcion)){
                    JOptionPane.showMessageDialog(null, "Debe de ingresar una descripcion valida");
                }else if(descripcion == null){
                    flag =  false;
                    
                }else{
                    System.out.println("siuuuuuuuuuuuuuuuuuuuuuuuuuu");
                    JOptionPane.showMessageDialog(null, "Partida guardada con exito!!");
                    crearModelo();
                    limpiarTextBox();
                    lblDebe.setText("$0.00");
                    lblHaber.setText("$0.00");
                    flag = false;
                }
            }
        }else if("$0.00".equals(lblHaber.getText()) && "$0.00".equals(lblDebe.getText())){
            JOptionPane.showMessageDialog(null,"No puede registrar una transaccion sin movimiento de dinero","Error", JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null,"No esta balanceada la transacción por ende no se puede guardar","Error", JOptionPane.ERROR_MESSAGE);
        }
     
    }//GEN-LAST:event_btnGuardarEnLibroMayorActionPerformed

    private void lblDebePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lblDebePropertyChange
        // TODO add your handling code here:
        if(lblDebe.getText().equals(lblHaber.getText())){
            btnGuardarEnLibroMayor.enable(true);
        }
    }//GEN-LAST:event_lblDebePropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(libroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(libroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(libroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(libroDiario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new libroDiario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarEnLibroMayor;
    private javax.swing.JTextField codigo;
    private javax.swing.JTextField deb;
    private javax.swing.JTextField des;
    private com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JTextField hber;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDebe;
    private javax.swing.JLabel lblHaber;
    protected javax.swing.JTable tabla1;
    private javax.swing.JTextField txtbuscarCuenta;
    // End of variables declaration//GEN-END:variables
}
