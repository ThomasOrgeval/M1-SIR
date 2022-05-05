package entity;

import javax.persistence.*;

@Entity(name = "kanban")
public class Kanban {
    @Id
    @SequenceGenerator(name = "kanbanSeq", sequenceName = "kanban_id_seq", allocationSize = 1, initialValue = 3)
    @GeneratedValue(generator = "kanbanSeq")
    private Long id;
    private Long owner_id;

    private String kanban;

    public Kanban() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public String getKanban() {
        return kanban;
    }

    public void setKanban(String kanban) {
        this.kanban = kanban;
    }
}
