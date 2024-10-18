/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import logic.CatalogoDeCuentasDatos;
import logic.DatabaseConnection;
import logic.queries.LoadStaticData;
import logic.queries.SelectData;
import logic.EmpresaSelected;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author angel
 */
public class PRINCIPAL extends javax.swing.JFrame implements EmpresaSelected{
    private JPanel panelPrincipal;
    private int empresa_id = 0;
    private String nombreEmpresa;
    private int idUser = 0;


    public PRINCIPAL(int userId) {
        this.idUser = userId;
        initComponents();
        habilitarBotones(false);

    }
    
    public PRINCIPAL() {
        initComponents();
        habilitarBotones(false);
    }
    
    public void setUsuarioLabel(String nombreUsuario) {
        user.setText(nombreUsuario);
    }
    
    @Override
    public void empresaSeleccionada(int idEmpresa, String nombreEmpresa){
        empresa_id = idEmpresa;
        this.nombreEmpresa = nombreEmpresa;
        jLabel2.setText(this.nombreEmpresa);
        habilitarBotones(true);
    }
    
    /*public int getUserID(){
        System.out.println("ID: " + LoadStaticData.getUserID(user.getText()));
        return LoadStaticData.getUserID(user.getText());
    }*/

    public Balance bc = new Balance();
    private void habilitarBotones(boolean opcion){
        jButton1.setEnabled(opcion);
        jButton2.setEnabled(opcion);
        jButton3.setEnabled(opcion);
        jButton4.setEnabled(opcion);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        info = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1367, 739));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(9, 29, 54));

        jButton1.setBackground(new java.awt.Color(58, 78, 122));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\angel\\Downloads\\transaccion.png")); // NOI18N
        jButton1.setText("Registrar transacción");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(58, 78, 122));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Users\\angel\\Downloads\\catalogo.png")); // NOI18N
        jButton2.setText("Catalogo de cuentas");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(58, 78, 122));
        jButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Libro mayor");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(58, 78, 122));
        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Libro diario");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido");

        user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        user.setForeground(new java.awt.Color(255, 255, 255));

        jButton8.setBackground(new java.awt.Color(58, 78, 122));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setIcon(new javax.swing.ImageIcon("C:\\Users\\angel\\Downloads\\trabajo-en-equipo (1).png")); // NOI18N
        jButton8.setText("Mis Empresas");
        jButton8.setFocusPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(user, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton8)
                .addGap(123, 123, 123)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 151, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 310, 700);

        jPanel4.setBackground(new java.awt.Color(58, 78, 122));
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SISTEMA CONTABLE");
        jLabel2.setToolTipText("");

        jButton5.setBackground(new java.awt.Color(0, 102, 102));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("AGREGAR CUENTA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 102));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("CERRAR SESION");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addGap(105, 105, 105))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(310, 0, 1124, 103);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        info.setBackground(new java.awt.Color(241, 241, 240));

        javax.swing.GroupLayout infoLayout = new javax.swing.GroupLayout(info);
        info.setLayout(infoLayout);
        infoLayout.setHorizontalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1095, Short.MAX_VALUE)
        );
        infoLayout.setVerticalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(info);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(310, 100, 1040, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            // TODO add your handling code here:
            info.removeAll();
            libroDiario diario = new libroDiario();
            //diario.setSize(1028, 820);
            info.add(diario);
            info.revalidate();
            info.repaint();
        }//GEN-LAST:event_jButton1ActionPerformed
    
        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            info.removeAll();
            CatalogoCuentas catalogoCuentas = new CatalogoCuentas();
            catalogoCuentas.setSize(1028, 820);
            info.add(catalogoCuentas);
            info.revalidate();
            info.repaint();
        }//GEN-LAST:event_jButton2ActionPerformed
    */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        libroDiario diario = new libroDiario(empresa_id);
        diario.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(diario, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        CatalogoCuentas catalogoCuentas = new CatalogoCuentas(empresa_id);
        catalogoCuentas.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(catalogoCuentas, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();
    }

    private DatabaseConnection dbConnection = new DatabaseConnection();

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);

        // Configurar el layout del JPanel info
        info.setLayout(new GridLayout(0, 1)); // Usamos GridLayout para añadir el panel del libro mayor

        // Código para obtener las cuentas que tienen valores en la empresa
        CatalogoDeCuentasDatos catalogo = new CatalogoDeCuentasDatos();
        List<List<Object>> cuentas = catalogo.libroDiario(empresa_id);

        Map<String, List<List<Object>>> diccionario = new HashMap<>();

        // Recorremos las cuentas y las organizamos en el diccionario
        for (List<Object> row : cuentas) {
            System.err.println("Cuentas" + row);
            var nombreCuenta = String.valueOf(row.get(2)) + " - " + (String) row.get(3); // Se asume que la cuenta está en la posición 3
            diccionario.computeIfAbsent(nombreCuenta, k -> new ArrayList<>()).add(row);
        }

        // Recorrer las entradas del diccionario y mostrar los datos en el formulario
        for (Map.Entry<String, List<List<Object>>> entrada : diccionario.entrySet()) {
            String cuenta =  entrada.getKey();
            List<List<Object>> valores = entrada.getValue();

            if (!valores.isEmpty()) {
                 // Creamos una instancia del formulario LibroMayor
                LibroMayor libroMayorForm = new LibroMayor();
                // Llenar la tabla con los valores (fecha, descripcion, debe, haber)
                DefaultTableModel model = new DefaultTableModel(new String[]{"Fecha", "Concepto", "Debe", "Haber","Saldo"}, 0);

                double saldoTotal = 0.0;
                for (List<Object> row : valores) {
               
                    String fecha = (String) row.get(1); // Se asume que la fecha está en la posición 1
                    String descripcion = (String) row.get(4); // Se asume que la descripción está en la posición 4
                    String debeStr = (String) row.get(5); // Obtenemos el valor como String
                    String haberStr = (String) row.get(6);

                    double debe = 0.0;
                    double haber = 0.0;

                    try {
                        // Convertimos las cadenas a números
                        if (debeStr != null && !debeStr.isEmpty()) {
                            debe = Double.parseDouble(debeStr);
                        }
                        if (haberStr != null && !haberStr.isEmpty()) {
                            haber = Double.parseDouble(haberStr);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error al convertir debe/haber a número: " + e.getMessage());
                    }
                    saldoTotal += debe - haber;
                    
                    // Añadir la fila al modelo de la tabla
                    model.addRow(new Object[]{
                        fecha, 
                        descripcion, 
                        debe != 0.0 ? "$" + debe : "", // Si 'debe' es diferente de 0.0, lo muestra, de lo contrario, deja el campo vacío
                        haber != 0.0 ? "$" + haber : "", // Si 'haber' es diferente de 0.0, lo muestra, de lo contrario, deja el campo vacío
                        "$" + saldoTotal// El saldo siempre se muestra
                    });
                }

                // Asignar el modelo a la tabla del formulario
                libroMayorForm.getModel(model);

                // Configurar los JLabel del formulario
                libroMayorForm.nombreCuenta.setText(cuenta);
                libroMayorForm.total.setText(String.valueOf(saldoTotal));
                // Añadir el formulario del libro mayor al JPanel 'info'
                info.add(libroMayorForm);
            }
        }
        // Actualizar el panel para que muestre los cambios
        info.revalidate();
        info.repaint();
    }
//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        SegLibroDiario diario = new SegLibroDiario(empresa_id,nombreEmpresa);
        diario.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(diario, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed


        info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        Registro_cuenta rc = new Registro_cuenta(empresa_id);
        rc.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(rc, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();


    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        login lg = new login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        EmpresasR er = new EmpresasR(user.getText(), this, idUser);
        er.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(er, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();
    }//GEN-LAST:event_jButton8ActionPerformed

    public void pressButton(){
        jButton2.doClick();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
