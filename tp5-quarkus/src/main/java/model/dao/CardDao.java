package model.dao;

import model.dao.generic.AbstractJpaDao;
import model.Card;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CardDao extends AbstractJpaDao<Long, Card> {

    public CardDao() {
        super(Card.class);
    }
}
