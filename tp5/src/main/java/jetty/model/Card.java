package jetty.model;

public class Card {
    protected int id, estimated, user_id, kanban_id;
    protected String end, name, note, place, type, url;

    public Card(int id, String end, int estimated, String name, String note, String place, String type, String url, int user_id, int kanban_id) {
        this.id = id;
        this.estimated = estimated;
        this.user_id = user_id;
        this.kanban_id = kanban_id;
        this.end = end;
        this.name = name;
        this.note = note;
        this.place = place;
        this.type = type;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstimated() {
        return estimated;
    }

    public void setEstimated(int estimated) {
        this.estimated = estimated;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getKanban_id() {
        return kanban_id;
    }

    public void setKanban_id(int kanban_id) {
        this.kanban_id = kanban_id;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
