package model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Card {
    @Id
    @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private CardType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ElementCollection
    @CollectionTable(name = "tags")
    private final List<String> tags = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kanban_id")
    private Kanban kanban;

    private String name;
    private String place;
    private String url;
    private String note;
    private Date end;
    private int estimated;

    public Card() {

    }

    public Long getId() {
        return id;
    }

    public CardType getType() {
        return type;
    }

    public User getUser() {
        return user;
    }

    public List<String> getTags() {
        return tags;
    }

    public Kanban getKanban() {
        return kanban;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public String getUrl() {
        return url;
    }

    public String getNote() {
        return note;
    }

    public Date getEnd() {
        return end;
    }

    public int getEstimated() {
        return estimated;
    }
}
