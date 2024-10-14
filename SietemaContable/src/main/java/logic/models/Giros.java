package logic.models;

public class Giros {
    private int id;
    private String giro;

    public Giros(int id, String giro) {
        this.id = id;
        this.giro = giro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGiro() {
        return giro;
    }

    public void setGiro(String giro) {
        this.giro = giro;
    }

    @Override
    public String toString() {
        return id + " - " + giro;
    }
}
