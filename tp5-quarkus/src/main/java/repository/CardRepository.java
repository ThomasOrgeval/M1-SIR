package repository;

import entity.Card;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;

@ApplicationScoped
public class CardRepository implements PanacheRepository<Card> {

    @Transactional
    public Long update(Card body, Long id) {
        Card card = this.findById(id);

        if (card == null) throw new NotFoundException();

        card.setType(body.getType());
        card.setTags(body.getTags());
        card.setName(body.getName());
        card.setPlace(body.getPlace());
        card.setUrl(body.getUrl());
        card.setNote(body.getNote());
        card.setEnd(body.getEnd());
        card.setEstimated(body.getEstimated());

        this.persist(card);
        Log.info("[Card] carte mise a jour " + card.getId());
        return card.getId();
    }

    @Transactional
    public Long save(Card card) {
        this.persist(card);
        Log.info("[Card] nouvelle carte sauvegardee " + card.getId());
        return card.getId();
    }

    public List<Card> findByKanban(long kanban_id) {
        Log.info("[Card] reprises des cards provenant du kanban " + kanban_id);
        return find("kanban_id", kanban_id).list();
    }
}
