package entity;

import javax.persistence.*;

@Entity(name = "kanban")
public class Kanban {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private String kanban;

    public Kanban() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getKanban() {
        return kanban;
    }

    public void setKanban(String kanban) {
        this.kanban = kanban;
    }
}
