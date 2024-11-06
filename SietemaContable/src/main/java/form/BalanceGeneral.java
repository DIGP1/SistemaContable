/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

import logic.models.BalanceGeneralClass;
import logic.CatalogoDeCuentasDatos;

/**
 * @author josue
 */
public class BalanceGeneral extends javax.swing.JPanel {

    /**
     * Creates new form BalanceGeneral
     */
    double activoCorriente = 0.0;
    double activoNoCorriente = 0.0;
    double totalActivo = 0.0;
    double pasivoCorriente = 0.0;
    double pasivoNoCorriente = 0.0;
    double totalPasivo = 0.0;
    double patrimonio = 0.0;

    private int empresa_id = 0;
    private String nombreEmpresa;

    public BalanceGeneral() {
        initComponents();
    }

    public BalanceGeneral(int id_empresa, String nombreEmpresa) {
        initComponents();
        this.empresa_id = id_empresa;
        this.nombreEmpresa = nombreEmpresa;
        double totalactivo = 0;
        double totalpasivo = 0;
        double patrimonio = 0;
        CatalogoDeCuentasDatos catalogo = new CatalogoDeCuentasDatos();
        List<List<Object>> cuentas = catalogo.libroDiario(empresa_id);

        Map<String, List<List<Object>>> diccionario = new HashMap<>();

        BalanceGeneralClass balance = new BalanceGeneralClass();

        LocalDate fechaActual = LocalDate.now();
        System.out.println("Fecha actual: " + fechaActual);

        DefaultTableModel activoModel = new DefaultTableModel(new String[]{"Balance general", "", nombreEmpresa, "", String.valueOf(fechaActual)}, 0);

        for (List<Object> row : cuentas) {
            //System.err.println("Cuentas" + row);
            var nombreCuenta = String.valueOf(row.get(2)) + " - " + (String) row.get(3); // Se asume que la cuenta está en la posición 3
            diccionario.computeIfAbsent(nombreCuenta, k -> new ArrayList<>()).add(row);
            balance.agregarValor(clasificarCuenta(String.valueOf(row.get(2))), row);
        }

        System.out.println(balance.obtenerBalance());
        for (Object cuentaObj : balance.obtenerBalance()) {
            List<Object> cuentaInfo = (List<Object>) cuentaObj;

            String tipoCuenta = (String) cuentaInfo.get(0); // El tipo de cuenta es el primer elemento
            System.out.println("Tipo de cuenta: " + tipoCuenta);

            Object registros = cuentaInfo.get(1); // El segundo elemento son los registros o un mensaje

            if (registros instanceof String) {
                System.out.println(registros); // Si es un mensaje, lo imprimimos
            } else if (registros instanceof List) {
                List<Map<String, Object>> registrosList = (List<Map<String, Object>>) registros;

                if (tipoCuenta.contentEquals("Activo Circulante")) {
                    //-----------------------------------------------------------------------------
                    this.activoCorriente = balance.obtenerTotales().get("Activo Circulante");
                    this.activoNoCorriente = balance.obtenerTotales().get("Activo No Circulante");
                    //-----------------------------------------------------------------------------
                    totalactivo += balance.obtenerTotales().get("Activo Circulante");
                    totalactivo += balance.obtenerTotales().get("Activo No Circulante");
                    activoModel.addRow(new Object[]{"<html><b>Activo</b></html>", "", "", "", "<html><b>" + Math.abs(totalactivo) + "</b></html>"});
                    activoModel.addRow(new Object[]{"<html><b>&nbsp;&nbsp;" + tipoCuenta + "</b></html>", "", "", Math.abs(balance.obtenerTotales().get("Activo Circulante")), ""});
                    this.totalActivo = totalactivo;
                } else if (tipoCuenta.contentEquals("Pasivo Circulante")) {
                    //-----------------------------------------------------------------------------
                    this.pasivoCorriente = balance.obtenerTotales().get("Pasivo Circulante");
                    this.pasivoNoCorriente = balance.obtenerTotales().get("Pasivo No Circulante");
                    //-----------------------------------------------------------------------------
                    totalpasivo += balance.obtenerTotales().get("Pasivo Circulante");
                    totalpasivo += balance.obtenerTotales().get("Pasivo No Circulante");
                    activoModel.addRow(new Object[]{"<html><b>Pasivo</b></html>", "", "", "", "<html><b>" + Math.abs(totalpasivo) + "</b></html>"});
                    activoModel.addRow(new Object[]{"<html><b>&nbsp;&nbsp;" + tipoCuenta + "</b></html>", "", "", Math.abs(balance.obtenerTotales().get("Pasivo Circulante")), ""});
                    this.totalPasivo = totalpasivo;
                } else if (tipoCuenta.contentEquals("Patrimonio")) {
                    //-----------------------------------------------------------------------------
                    this.patrimonio = balance.obtenerTotales().get("Patrimonio");
                    //-----------------------------------------------------------------------------
                    patrimonio += balance.obtenerTotales().get("Patrimonio");
                    activoModel.addRow(new Object[]{"<html><b>" + tipoCuenta + "</b></html>", "", "", "", "<html><b>" + Math.abs(balance.obtenerTotales().get("Patrimonio")) + "</b></html>"});
                } else if (tipoCuenta.contentEquals("Activo No Circulante")) {
                    activoModel.addRow(new Object[]{"<html><b>&nbsp;&nbsp;" + tipoCuenta + "</b></html>", "", "", Math.abs(balance.obtenerTotales().get("Activo No Circulante")), ""});
                } else if (tipoCuenta.contentEquals("Pasivo No Circulante")) {
                    activoModel.addRow(new Object[]{"<html><b>&nbsp;&nbsp;" + tipoCuenta + "</b></html>", "", "", Math.abs(balance.obtenerTotales().get("Pasivo No Circulante")), ""});
                }

                for (Map<String, Object> registro : registrosList) {
                    // Accedemos a cada registro
                    System.out.println("Cuenta: " + registro.get("Cuenta"));
                    System.out.println("Código: " + registro.get("Codigo"));
                    System.out.println("Debe: " + registro.get("Debe"));
                    System.out.println("Haber: " + registro.get("Haber"));
                    System.out.println("----------");
                    activoModel.addRow(new Object[]{"<html>&nbsp;&nbsp;&nbsp;&nbsp;" + registro.get("Cuenta") + "</b></html>", convertirPositivo(registro.get("Debe")), convertirPositivo(registro.get("Haber")), "", ""});
                }
                if (tipoCuenta.contentEquals("Patrimonio")) {
                    activoModel.addRow(new Object[]{"<html><b>Total pasivo + patrimonio</b></html>", "", "", "", "<html><b>" + Math.abs(totalpasivo + patrimonio) + "</b></html>"});
                }

            }
        }
        jTableActivos.setModel(activoModel);
        //System.err.println(balance.obtenerTotales());
    }

    private Object convertirPositivo(Object valor) {
        if (valor == null || valor.equals("")) {
            return ""; // Retornar vacío si no hay valor
        }
        // Si es numérico, convertir a Double y aplicar Math.abs()
        return Math.abs(Double.parseDouble(valor.toString()));
    }


    private static String clasificarCuenta(String valor) {
        // Aseguramos que el número de cuenta tenga 8 dígitos
        valor = String.format("%-8s", valor).replace(' ', '0');

        int numero = Integer.parseInt(valor);

        if (numero >= 11000000 && numero <= 11999999) {
            return "Activo Circulante";
        } else if (numero >= 12000000 && numero <= 12999999) {
            return "Activo No Circulante";
        } else if (numero >= 21000000 && numero <= 21999999) {
            return "Pasivo Circulante";
        } else if (numero >= 22000000 && numero <= 22999999) {
            return "Pasivo No Circulante";
        } else if (numero >= 31000000 && numero <= 31999999) {
            return "Patrimonio";
        } else {
            return valor;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableActivos = new javax.swing.JTable();

        setAutoscrolls(true);

        jTableActivos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null},
                        {null, null, null, null, null}
                },
                new String[]{
                        "Activos", "", "", "", ""
                }
        ) {
            boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableActivos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 955, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<Double> getTotalesList(){
        ArrayList<Double> totales = new ArrayList<>();
        totales.add(Math.abs(this.activoCorriente)); //0 -> Activo circulante
        totales.add(Math.abs(this.activoNoCorriente)); //1 -> Activo no circulante
        totales.add(Math.abs(this.pasivoCorriente)); //2 -> Pasivo circulante
        totales.add(Math.abs(this.pasivoNoCorriente)); //3 -> Pasivo no circulante
        totales.add(Math.abs(this.patrimonio)); //4 -> Patrimonio
        totales.add(Math.abs(this.totalActivo)); //5 -> Activo totals
        totales.add(Math.abs(this.totalPasivo)); //6 -> Pasivo total
        // Todas usando su valor absoluto para evitar retornar negativos y no tener problemas
        
        return totales;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableActivos;
    // End of variables declaration//GEN-END:variables
}
