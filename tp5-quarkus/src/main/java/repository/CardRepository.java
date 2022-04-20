package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import entity.Card;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@ApplicationScoped
public class CardRepository implements PanacheRepository<Card> {

    @Transactional
    public Long update(Card body, Long id) {
        Card card = this.findById(id);

        if (card == null) throw new NotFoundException();

        card = body;
        getEntityManager().persist(card);
        return card.getId();
    }

    @Transactional
    public Long save(Card card) {
        this.persist(card);
        return card.getId();
    }
}
