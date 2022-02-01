package jpa.object;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kanban {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany
    @JoinColumn(name = "kanban_id")
    private final List<Card> cards = new ArrayList<>();

    private String kanban;

    public Kanban(User owner, String kanban) {
        this.owner = owner;
        this.kanban = kanban;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKanban() {
        return kanban;
    }

    public void setKanban(String kanban) {
        this.kanban = kanban;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
