package model.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import model.Card;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ApplicationScoped
public class CardDao implements PanacheRepository<Card> {

    public List<Card> findAllCards() {
        return this.listAll(Sort.descending("id"));
    }

    public Optional<Card> findOne(long id) {
        Card card = null;
        try {
            card = this.find("id=:id", Parameters.with("id", id)).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(card);
    }

    @Transactional
    public Long update(Card body, Long id) {
        Card card = this.findById(id);
        if(card == null) throw new NotFoundException();

        card = body;
        return card.getId();
    }

    @Transactional
    public Long save(Card card) {
        this.persist(card);
        return card.getId();
    }

    @Transactional
    public boolean deleteById(String id) {
        return this.delete("id=?1", id) > 0;
    }
}
