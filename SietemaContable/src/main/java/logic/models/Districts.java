package logic.models;

public class Districts {
    private int id;
    private String name;

    public Districts(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public Districts() {
        // Empty shit
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
}
