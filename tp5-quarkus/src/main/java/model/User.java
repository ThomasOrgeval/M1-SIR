package model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement(name = "User")
public class User implements Serializable {
    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    private Long id;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    @XmlElementWrapper(name = "cards")
    @XmlElement(name = "cards")
    @JsonBackReference
    List<Card> cards = new ArrayList<>();

    @XmlElement(name = "name")
    String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
