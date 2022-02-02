package rs.dao;

import rs.dao.generic.AbstractJpaDao;
import rs.domain.Kanban;

public class KanbanDao extends AbstractJpaDao<Long, Kanban> {

    public KanbanDao() {
        super(Kanban.class);
    }
}
