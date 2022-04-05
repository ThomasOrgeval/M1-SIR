package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    List<Card> cards = new ArrayList<>();

    String name;

    public User() {

    }

    public Long getId() {
        return id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getName() {
        return name;
    }
}
