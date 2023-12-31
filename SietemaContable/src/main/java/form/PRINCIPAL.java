/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import logic.CatalogoDeCuentasDatos;
import logic.DatabaseConnection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author angel
 */
public class PRINCIPAL extends javax.swing.JFrame {
 private JPanel panelPrincipal;




    public PRINCIPAL() {
        initComponents();
    }

    public void setUsuarioLabel(String nombreUsuario) {
    user.setText( nombreUsuario);
}
    
     public Balance bc = new   Balance();
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

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));

        jButton1.setBackground(new java.awt.Color(51, 0, 51));
        jButton1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGISTRAR TRANSACCIÓN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 0, 51));
        jButton2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("CATALOGO DE CUENTAS");
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

        jButton3.setBackground(new java.awt.Color(51, 0, 51));
        jButton3.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("LIBRO MAYOR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 0, 51));
        jButton4.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("LIBRO DIARIO");
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("BIENVENIDO");

        user.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(user)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(28, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(user)
                .addGap(177, 177, 177)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(250, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(174, 174, 174)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(478, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 310, 700);

        jPanel4.setBackground(new java.awt.Color(0, 51, 51));
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SISTEMA CONTABLE");
        jLabel2.setToolTipText("");

        jButton5.setBackground(new java.awt.Color(0, 102, 0));
        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("AGREGAR CUENTA");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(0, 102, 0));
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
                .addGap(16, 16, 16)
                .addComponent(jButton5)
                .addGap(221, 221, 221)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addComponent(jButton6)
                .addGap(99, 99, 99))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jButton5))
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
        jPanel2.setBounds(310, 0, 1129, 103);

        jScrollPane1.setBackground(new java.awt.Color(0, 0, 0));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        info.setBackground(new java.awt.Color(245, 245, 220));

        javax.swing.GroupLayout infoLayout = new javax.swing.GroupLayout(info);
        info.setLayout(infoLayout);
        infoLayout.setHorizontalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
        );
        infoLayout.setVerticalGroup(
            infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 658, Short.MAX_VALUE)
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
        libroDiario diario = new libroDiario();
        diario.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(diario, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);  
        CatalogoCuentas catalogoCuentas = new CatalogoCuentas();
        catalogoCuentas.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(catalogoCuentas, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();
    }

    private DatabaseConnection dbConnection = new DatabaseConnection();

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        List<String> lista_nombre_cuenta = new ArrayList<>();
        List<Float> lista_valor_cuenta_debe = new ArrayList<>();
        List<Float> lista_valor_cuenta_haber = new ArrayList<>();

        info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(20);
        // Configurar el layout del JPanel info
        info.setLayout(new GridLayout(0, 1)); // Usamos FlowLayout con alineación izquierda

        // Revalidar y repintar el panel info para mostrar los cambios
//        info.revalidate();
//        info.repaint();

        CatalogoDeCuentasDatos catalogo = new CatalogoDeCuentasDatos();
        List<List<Object>> cuentas = catalogo.libroDiario();
        
        Set<Integer> uniqueCodes = new HashSet<>();
        
        for (List<Object> row : cuentas) {
            // Suponemos que el código se encuentra en la columna "codigo" (índice 2 en base 0)
            Integer code = (Integer) row.get(2); // Obtén el código

            if (code != null) {
                uniqueCodes.add(code); // Agrega el código al conjunto
            }
        }
        
        System.out.println(uniqueCodes);
        
        List<List<Object>> datosPorCodigos = new ArrayList<>();

        // Crear un mapa para agrupar cuentas por código
        Map<Integer, List<List<Object>>> cuentasAgrupadas = new HashMap<>();
        for (Integer code : uniqueCodes) {
            List<List<Object>> cuentasPorCodigo = new ArrayList<>();
            for (List<Object> row : cuentas) {
                Integer rowCode = (Integer) row.get(2); // Suponiendo que el código se encuentra en la columna 2
                if (rowCode != null && rowCode.equals(code)) {
                    cuentasPorCodigo.add(row);
                }
            }
            cuentasAgrupadas.put(code, cuentasPorCodigo);
        }
        System.out.println(cuentasAgrupadas);

        // Agregar componentes a info (asegúrate de que sean lo suficientemente anchos)
        for (Map.Entry<Integer, List<List<Object>>> entry : cuentasAgrupadas.entrySet()) {
            String[] columnNames = {"Fecha", "Descripcion", "Debe", "Haber"};

            // Crear un modelo de datos no editable
            DefaultTableModel model = new DefaultTableModel(null, columnNames) {
            @Override
                public boolean isCellEditable(int row, int column) {
                    // Desactiva la edición de todas las celdas
                    return false;
                }
            };
            Integer codigo = entry.getKey(); // Obtener el código
            int bandera = 0;
            List<List<Object>> datosPorCodigo = entry.getValue(); // Obtener los datos por código
            LibroMayor libroM = new LibroMayor();

            float debeTotal = 0;
            float haberTotal = 0;
            String cuenta = "";

            for (List<Object> datos : datosPorCodigo) {
                

                // Obtener la descripción
                String descripcion = (String) datos.get(3); // Suponiendo que la descripción está en la posición 1

                // Obtener la fecha
                String fecha = datos.get(1).toString(); // Suponiendo que la fecha está en la posición 0
                
                // Obtener debe
//                String debe = (String) datos.get(4);
                
                // Obtener haber
//                String haber = (String) datos.get(5);

                // Obtener el código de la cuenta
                String codigoCuenta = datos.get(2).toString();

                // Evaluar el primer dígito del código para determinar si es activo o pasivo
                char primerDigito = codigoCuenta.charAt(0);

                String debeStr = (String) datos.get(4);
                String haberStr = (String) datos.get(5);

                if (primerDigito == '1') {
                    // Es una cuenta de activo
                    if (!debeStr.isEmpty()) {
                        debeTotal += Float.parseFloat(debeStr); // Convierte la cadena en un número y suma
                    }
                    if (!haberStr.isEmpty()) {
                        haberTotal += Float.parseFloat(haberStr); // Convierte la cadena en un número y suma
                    }
                } else if (primerDigito == '2') {
                    // Es una cuenta de pasivo
                    if (!haberStr.isEmpty()) {
                        haberTotal += Float.parseFloat(haberStr); // Convierte la cadena en un número y suma
                    }
                    if (!debeStr.isEmpty()) {
                        debeTotal += Float.parseFloat(debeStr); // Convierte la cadena en un número y suma
                    }
                }
                // Asignar la descripción a nombreCuenta
                libroM.nombreCuenta.setText(descripcion);

//
//                System.out.println(fecha+descripcion+debe+haber);
                Object[] fila = {fecha,descripcion, debeStr, haberStr};
                model.addRow(fila);
                //tabla_balance.addRow(fila);
                libroM.getModel(model);
                cuenta = descripcion;
            }
            
            System.out.println(model.getColumnCount());
            System.out.println(model);
            System.out.println(model.getValueAt(0,2).toString());
            float saldoFinal = debeTotal - haberTotal;
            
            lista_nombre_cuenta.add(cuenta);
             
            if (saldoFinal > 0) {
                libroM.totalDebe.setText("$" + saldoFinal);
                libroM.totalDebe.setVisible(true);
                libroM.totalHaber.setVisible(false);
                lista_valor_cuenta_debe.add(saldoFinal);
                lista_valor_cuenta_haber.add(0.00f);
            } else {
                libroM.totalHaber.setText("$" + saldoFinal);
                libroM.totalHaber.setVisible(true);
                libroM.totalDebe.setVisible(false);
                lista_valor_cuenta_debe.add(0.00f);
                lista_valor_cuenta_haber.add(saldoFinal * -1);
            }

//            float debe = 0;
//            float haber = 0;
//                for(int i = 0; i<model.getRowCount(); i++){
//                    if(!"".equals(model.getValueAt(i,2).toString())){
//                        System.out.println(model.getValueAt(i,2).toString());
//                        String numeroDebe = model.getValueAt(i,2).toString();
//                        debe = debe + Float.parseFloat(numeroDebe);
//                    }
//                    if(!"".equals(model.getValueAt(i,3).toString())){
//                        String numeroHaber = model.getValueAt(i, 3).toString();
//                        haber = haber + Float.parseFloat(numeroHaber);
//                    }
//                }
//            if (debe>haber) {
//                float total = debe-haber;
//                libroM.totalDebe.setText("$"+total);
//                libroM.totalDebe.setVisible(true);
//                libroM.totalHaber.setVisible(false);
//
//            }else{
//                float total = haber-debe;
//                libroM.totalHaber.setText("$"+total);
//                libroM.totalHaber.setVisible(true);
//                libroM.totalDebe.setVisible(false);
//            }
            libroM.setPreferredSize(new Dimension(773, 311)); // Establecer un tamaño fijo
            info.add(libroM);

        }



        info.revalidate();
        info.repaint();
        
        
        
        
        
        
        JButton myButton = new JButton("Generar Balance");
        myButton.setBackground(Color.GREEN);
        
// Define an ActionListener for the button
      myButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Add the actions you want to perform when the button is clicked
        // For example, displaying a message:
         info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);  
        //Balance bc = new   Balance();
        bc.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(bc, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();

        for (Map.Entry<Integer, List<List<Object>>> entry : cuentasAgrupadas.entrySet()) {
            String[] columnNames = {"Descripcion", "Debe", "Haber"};

            // Crear un modelo de datos no editable
            DefaultTableModel model = new DefaultTableModel(null, columnNames) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    // Desactiva la edición de todas las celdas
                    return false;
                }
            };

            Integer codigo = entry.getKey(); // Obtener el código
            int bandera = 0;
            List<List<Object>> datosPorCodigo = entry.getValue(); // Obtener los datos por código

            //Balance balanceJ = new Balance();

            float debeTotal = 0;
            float haberTotal = 0;

            for (List<Object> datos : datosPorCodigo) {

                // Obtener la descripción
                String descripcion = (String) datos.get(3); // Suponiendo que la descripción está en la posición 1

                // Obtener el código de la cuenta
                String codigoCuenta = datos.get(2).toString();

                // Evaluar el primer dígito del código para determinar si es activo o pasivo
                char primerDigito = codigoCuenta.charAt(0);

                String debeStr = (String) datos.get(4);
                String haberStr = (String) datos.get(5);

                if (primerDigito == '1') {
                    // Es una cuenta de activo
                    if (!debeStr.isEmpty()) {
                        debeTotal += Float.parseFloat(debeStr); // Convierte la cadena en un número y suma
                    }
                    if (!haberStr.isEmpty()) {
                        haberTotal += Float.parseFloat(haberStr); // Convierte la cadena en un número y suma
                    }
                } else if (primerDigito == '2') {
                    // Es una cuenta de pasivo
                    if (!haberStr.isEmpty()) {
                        haberTotal += Float.parseFloat(haberStr); // Convierte la cadena en un número y suma
                    }
                    if (!debeStr.isEmpty()) {
                        debeTotal += Float.parseFloat(debeStr); // Convierte la cadena en un número y suma
                    }
                }
                float saldoFinal = debeTotal - haberTotal;

                Object[] fila;
                if (saldoFinal > 0) {
                    fila = new Object[]{descripcion, "", saldoFinal};
                } else {
                    fila = new Object[]{descripcion, saldoFinal, ""};
                }
                model.addRow(fila);

                //bc.getModel(tabla_model);
                //bc.getModel(model);
            }

            bc.setPreferredSize(new Dimension(773, 311)); // Establecer un tamaño fijo
            info.add(bc);
        }
    }
});

                myButton.setPreferredSize(new Dimension(100, 30)); // Adjust the size as needed

                // Create a BoxLayout for the info panel to align components vertically
                BoxLayout boxLayout = new BoxLayout(info, BoxLayout.Y_AXIS);
                info.setLayout(boxLayout);

                // Add vertical glue to push existing components to the top
                info.add(Box.createVerticalGlue());

                // Add the button to the info panel
                info.add(myButton);
                info.add(Box.createVerticalGlue()); // Pushes the button to the top
                        info.revalidate();
                        info.repaint();

        
        //LISTAR LOS DATOS QUE OCUPO
        
        //CREAR UN BOTON PARA MANDARLO A PANEL

        double totalDebe = 0.0;
        double totalHaber = 0.0;

        DefaultTableModel modelo = new DefaultTableModel(null, new String[]{"Cuenta", "Debe", "Haber"});
                for (int i = 0; i < lista_nombre_cuenta.size(); i++) {
                modelo.addRow(new Object[]{lista_nombre_cuenta.get(i), lista_valor_cuenta_debe.get(i), lista_valor_cuenta_haber.get(i)});

                    totalDebe += (double) lista_valor_cuenta_debe.get(i);
                    totalHaber += (double) lista_valor_cuenta_haber.get(i);
                }
        bc.totaldebe.setText(String.valueOf(totalDebe));
        bc.totalhaber.setText(String.valueOf(totalHaber));

        bc.getModel(modelo);
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
        SegLibroDiario diario = new SegLibroDiario();
        diario.setSize(info.getSize()); // Establecer el tamaño igual al tamaño del contenedor
        info.setLayout(new BorderLayout()); // Usar un BorderLayout
        info.add(diario, BorderLayout.CENTER); // Agregar el componente en el centro
        info.revalidate();
        info.repaint();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
    
        
         info.removeAll();
        jScrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);  
        Registro_cuenta rc = new  Registro_cuenta();
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
            java.util.logging.Logger.getLogger(PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PRINCIPAL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PRINCIPAL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel info;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel user;
    // End of variables declaration//GEN-END:variables
}
