package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Kanban {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "kanban")
    private final List<Card> cards = new ArrayList<>();

    private String kanban;

    public Kanban() {

    }

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getKanban() {
        return kanban;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}
