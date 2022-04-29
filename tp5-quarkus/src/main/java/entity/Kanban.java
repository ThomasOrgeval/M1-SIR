package entity;

import javax.persistence.*;

@Entity(name = "kanban")
public class Kanban {
    @Id
    @SequenceGenerator(name = "kanbanSeq", sequenceName = "kanban_id_seq", allocationSize = 1, initialValue = 3)
    @GeneratedValue(generator = "kanbanSeq")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
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
