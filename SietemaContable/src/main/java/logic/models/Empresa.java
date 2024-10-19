package logic.models;

public class Empresa {
    int id;
    String nombreComercial;
    String nit;
    int giroComercial;
    String direccion;
    int departamentoId;
    int municipioId;
    int distritoId;
    GiroComercial giroComercialObj;
    Department departmento;
    Municipio municipio;
    Districts distrito;
    int usuarioId;
    String propietario;

    public Empresa(int id, String nombreComercial, String nit, int giroComercial, String direccion, int distritoId, int usuarioId, String propietario) {
        this.id = id;
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.giroComercial = giroComercial;
        this.direccion = direccion;
        this.distritoId = distritoId;
        this.usuarioId = usuarioId;
        this.propietario = propietario;
    }

    public Empresa(int id, String nombreComercial, String nit, GiroComercial giroComercial, String direccion, int idDistrito, 
                   int idUsuario, Department departmento, Municipio municipio, Districts distrito, String propietario) {
        this.id = id;
        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.giroComercialObj = giroComercial;
        this.direccion = direccion;
        this.distritoId = idDistrito;
        this.usuarioId = idUsuario;
        this.departmento = departmento;
        this.municipio = municipio;
        this.distrito = distrito;
        this.propietario = propietario;
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

    public int getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(int departamentoId) {
        this.departamentoId = departamentoId;
    }

    public int getMunicipioId() {
        return municipioId;
    }

    public void setMunicipioId(int municipioId) {
        this.municipioId = municipioId;
    }

    public Department getDepartmento() {
        return departmento;
    }

    public void setDepartmento(Department departmento) {
        this.departmento = departmento;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Districts getDistrito() {
        return distrito;
    }

    public void setDistrito(Districts distrito) {
        this.distrito = distrito;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public GiroComercial getGiroComercialObj() {
        return giroComercialObj;
    }

    public void setGiroComercialObj(GiroComercial giroComercialObj) {
        this.giroComercialObj = giroComercialObj;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}
