package model.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import model.Card;
import model.Kanban;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class CardDao implements PanacheRepository<Card> {

    @Transactional
    public Long update(Card body, Long id) {
        Card card = this.findById(id);

        if (card == null) throw new NotFoundException();
        Kanban k = card.getKanban();
        User u = card.getUser();

        card = body;
        card.setUser(u);
        card.setKanban(k);

        getEntityManager().persist(card);
        return card.getId();
    }

    @Transactional
    public Long save(Card card) {
        this.persist(card);
        return card.getId();
    }
}
