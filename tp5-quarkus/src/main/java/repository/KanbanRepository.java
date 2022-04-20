package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import entity.Kanban;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class KanbanRepository implements PanacheRepository<Kanban> {

    @Transactional
    public void save(Kanban kanban) {
        this.persist(kanban);
    }

    @Transactional
    public boolean deleteById(String id) {
        return this.delete("id=?1", id) > 0;
    }
}
