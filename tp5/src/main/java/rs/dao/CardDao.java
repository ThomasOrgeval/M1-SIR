package rs.dao;

import rs.dao.generic.AbstractJpaDao;
import rs.domain.Card;

public class CardDao extends AbstractJpaDao<Long, Card> {

    public CardDao() {
        super(Card.class);
    }
}
