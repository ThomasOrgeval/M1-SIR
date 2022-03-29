package model.dao;

import model.dao.generic.AbstractJpaDao;
import model.Kanban;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KanbanDao extends AbstractJpaDao<Long, Kanban> {

    public KanbanDao() {
        super(Kanban.class);
    }
}
