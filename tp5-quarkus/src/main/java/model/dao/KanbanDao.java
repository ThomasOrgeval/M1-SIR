package model.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import model.Kanban;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class KanbanDao implements PanacheRepository<Kanban> {

    @Transactional
    public void save(Kanban kanban) {
        this.persist(kanban);
    }

    @Transactional
    public boolean deleteById(String id) {
        return this.delete("id=?1", id) > 0;
    }
}
