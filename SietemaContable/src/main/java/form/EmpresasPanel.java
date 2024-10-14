/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import logic.models.Department;
import logic.queries.LoadStaticData;

/**
 * @author alexu
 */
public class EmpresasPanel extends javax.swing.JPanel {

    /**
     * Creates new form EmpresasPanel
     */
    public EmpresasPanel() {
        initComponents();
        loadDepartments();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cb_depa = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        nombreComercial = new javax.swing.JTextField();
        jComboBoxDepartamentos = new javax.swing.JComboBox<>();
        nit = new javax.swing.JTextField();
        jComboBoxDistrito = new javax.swing.JComboBox<>();
        jComboBoxMunicipio = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(18, 56, 84));
        setPreferredSize(new java.awt.Dimension(951, 547));

        jLabel3.setBackground(new java.awt.Color(18, 56, 84));
        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NIT");

        jLabel4.setBackground(new java.awt.Color(18, 56, 84));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Giro Comercial");

        jLabel5.setBackground(new java.awt.Color(18, 56, 84));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Departamento");

        jLabel6.setBackground(new java.awt.Color(18, 56, 84));
        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Municipio");

        cb_depa.setBackground(new java.awt.Color(153, 102, 0));
        cb_depa.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        cb_depa.setForeground(new java.awt.Color(255, 255, 255));
        cb_depa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jButton1.setBackground(new java.awt.Color(0, 102, 0));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Agregar");

        jLabel1.setBackground(new java.awt.Color(18, 56, 84));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AGREGAR NUEVA EMPRESA");

        jButton2.setBackground(new java.awt.Color(153, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        nombreComercial.setBackground(new java.awt.Color(153, 102, 0));
        nombreComercial.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nombreComercial.setForeground(new java.awt.Color(255, 255, 255));
        nombreComercial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreComercialActionPerformed(evt);
            }
        });

        jComboBoxDepartamentos.setBackground(new java.awt.Color(153, 102, 0));
        jComboBoxDepartamentos.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jComboBoxDepartamentos.setForeground(new java.awt.Color(255, 255, 255));

        jComboBoxDepartamentos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seleccionar departamento"}));
        jComboBoxDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentosActionPerformed(evt);
            }
        });

        nit.setBackground(new java.awt.Color(153, 102, 0));
        nit.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        nit.setForeground(new java.awt.Color(255, 255, 255));

        jComboBoxDistrito.setBackground(new java.awt.Color(153, 102, 0));
        jComboBoxDistrito.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jComboBoxDistrito.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));

        jComboBoxMunicipio.setBackground(new java.awt.Color(153, 102, 0));
        jComboBoxMunicipio.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jComboBoxMunicipio.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxMunicipio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seleccionar municipio"}));
        /*jComboBoxMunicipio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMunicipiosActionPerformed(evt);
            }
        });*/

        jLabel7.setBackground(new java.awt.Color(18, 56, 84));
        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Distrito");

        jLabel2.setBackground(new java.awt.Color(18, 56, 84));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre Comercial");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(90, 90, 90)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel2))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                        .addGap(47, 47, 47)
                                                                        .addComponent(nombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(44, 44, 44)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(cb_depa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBoxMunicipio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jComboBoxDistrito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel1)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(nombreComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(35, 35, 35)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel3))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(cb_depa, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(50, 50, 50)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel5))
                                                .addGap(47, 47, 47)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jComboBoxMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(43, 43, 43)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jComboBoxDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(46, 46, 46)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void nombreComercialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreComercialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreComercialActionPerformed

    private void jComboBoxDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBoxDepartamentos.getSelectedIndex() <= 0) {
            return;
        }
        Department selectedDepartment = (Department) jComboBoxDepartamentos.getSelectedItem();
        assert selectedDepartment != null;
        String department = selectedDepartment.toString();
        if (department == null || department.equals("Seleccionar departamento")) {
            System.out.println("No hay departamento seleccionado. Esperando interacción del usuario...");
            return;
        }
        jComboBoxMunicipio.removeAllItems();
        jComboBoxDistrito.removeAllItems();
        jComboBoxMunicipio.addItem("Seleccionar municipio");
        jComboBoxDistrito.addItem("Seleccionar distrito");

        System.out.println("Departamento seleccionado: " + department);
        System.out.println("ID departamento seleccionado: " + selectedDepartment.getId());

        LoadStaticData.getMunicipalities(String.valueOf(selectedDepartment.getId())).forEach(municipio -> {
            jComboBoxMunicipio.addItem(String.valueOf(municipio));
        });
    }

    private void loadDepartments() {
        jComboBoxDepartamentos.removeAllItems();
        jComboBoxDepartamentos.addItem("Seleccionar departamento");
        LoadStaticData.getDepartamentos().forEach(department -> jComboBoxDepartamentos.addItem(department));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Object> cb_depa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<Object> jComboBoxDepartamentos;
    private javax.swing.JComboBox<Object> jComboBoxDistrito;
    private javax.swing.JComboBox<Object> jComboBoxMunicipio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nit;
    private javax.swing.JTextField nombreComercial;
    // End of variables declaration//GEN-END:variables
}
