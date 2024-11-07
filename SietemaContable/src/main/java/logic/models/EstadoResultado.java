/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.models;

/**
 *
 * @author diego_grb33
 */
public class EstadoResultado {
    private int id;
    private double utilidad_bruta;
    private double utilidad_operativa;
    private double utilidad_antes_impuestos;
    private double utilidad_neta;
    private int empresa_id;
    
    public EstadoResultado(){
        
    }

    public EstadoResultado(double utilidad_bruta, double utilidad_operativa, double utilidad_antes_impuestos, double utilidad_neta, int empresa_id) {
        this.utilidad_bruta = utilidad_bruta;
        this.utilidad_operativa = utilidad_operativa;
        this.utilidad_antes_impuestos = utilidad_antes_impuestos;
        this.utilidad_neta = utilidad_neta;
        this.empresa_id = empresa_id;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getUtilidad_bruta() {
        return utilidad_bruta;
    }

    public void setUtilidad_bruta(double utilidad_bruta) {
        this.utilidad_bruta = utilidad_bruta;
    }

    public double getUtilidad_operativa() {
        return utilidad_operativa;
    }

    public void setUtilidad_operativa(double utilidad_operativa) {
        this.utilidad_operativa = utilidad_operativa;
    }

    public double getUtilidad_antes_impuestos() {
        return utilidad_antes_impuestos;
    }

    public void setUtilidad_antes_impuestos(double utilidad_antes_impuestos) {
        this.utilidad_antes_impuestos = utilidad_antes_impuestos;
    }

    public double getUtilidad_neta() {
        return utilidad_neta;
    }

    public void setUtilidad_neta(double utilidad_neta) {
        this.utilidad_neta = utilidad_neta;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }
    
    
}
