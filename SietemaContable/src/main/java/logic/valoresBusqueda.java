/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author diego
 */
public class valoresBusqueda {
    private HashMap<String, String> cuentas = new HashMap<>();
    private List<String> nombreCuentas = new ArrayList<>();
    
    public valoresBusqueda(HashMap<String, String> cuentas, List<String> nombreCuentas){
        this.cuentas = cuentas;
        this.nombreCuentas = nombreCuentas;
    }
    
    public HashMap<String, String> getCuentas(){
        return cuentas;
    }
    public void setCuentas(HashMap<String, String> cuentas){
        this.cuentas = cuentas;
    }
    public List<String> getNombreCuentas(){
        return nombreCuentas;
    }
    public void setNombreCuentas(List<String> nombreCuentas){
        this.nombreCuentas = nombreCuentas;
    }
    
    
}
