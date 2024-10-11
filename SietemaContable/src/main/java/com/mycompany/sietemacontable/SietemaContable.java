/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sietemacontable;
import form.*;
import java.util.List;
import logic.CatalogoDeCuentasDatos;

/**
 *
 * @author diegorro
 */

public class SietemaContable {

    public static void main(String[] args) {
//        CatalogoDeCuentasDatos datos = new CatalogoDeCuentasDatos();
//        List<String> cuentas = datos.listarCuentas();
//
//        for (String cuenta : cuentas) {
//            System.out.println(cuenta);
//        }
        new login().setVisible(true);
        
    }
}
