package logic.models;

public class Empresa {
    int id;
    String nombreComercial;
    String nit;
    int giroComercial;
    String direccion;
    int distritoId;
    int usuarioId;

    public Empresa(int id, String nombreComercial, String nit, int giroComercial, String direccion, int distritoId, int usuarioId) {
        this.id = id;
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.giroComercial = giroComercial;
        this.direccion = direccion;
        this.distritoId = distritoId;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public int getGiroComercial() {
        return giroComercial;
    }

    public void setGiroComercial(int giroComercial) {
        this.giroComercial = giroComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getDistritoId() {
        return distritoId;
    }

    public void setDistritoId(int distritoId) {
        this.distritoId = distritoId;
    }
    
    public int getIdUsuario() {
        return usuarioId;
    }
    
    public void setIdUsuario(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}
