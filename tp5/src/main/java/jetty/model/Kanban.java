package jetty.model;

public class Kanban {
    protected int id, owner_id;
    protected String kanban;

    public Kanban(int id, String kanban, int owner_id) {
        this.id = id;
        this.owner_id = owner_id;
        this.kanban = kanban;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getKanban() {
        return kanban;
    }

    public void setKanban(String kanban) {
        this.kanban = kanban;
    }
}
