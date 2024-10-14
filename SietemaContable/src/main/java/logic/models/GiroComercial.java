package logic.models;

public class GiroComercial {
    int id;
    String giro_comercial;

    public GiroComercial(int id, String giro_comercial) {
        this.id = id;
        this.giro_comercial = giro_comercial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiro_comercial() {
        return giro_comercial;
    }

    public void setGiro_comercial(String giro_comercial) {
        this.giro_comercial = giro_comercial;
    }
}
