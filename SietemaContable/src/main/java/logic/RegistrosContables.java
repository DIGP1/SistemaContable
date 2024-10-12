package logic;

public class RegistrosContables {
    String fecha;
    String codigo;
    String cuenta;
    String debe;
    String haber;
    String descripcion;

    public RegistrosContables(String fecha, String codigo, String cuenta, String debe, String haber, String descripcion) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.cuenta = cuenta;
        this.debe = debe;
        this.haber = haber;
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getDebe() {
        return debe;
    }

    public void setDebe(String debe) {
        this.debe = debe;
    }

    public String getHaber() {
        return haber;
    }

    public void setHaber(String haber) {
        this.haber = haber;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
