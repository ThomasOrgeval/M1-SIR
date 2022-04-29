package repository;

import entity.Kanban;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class KanbanRepository implements PanacheRepository<Kanban> {

    @Transactional
    public Long save(Kanban kanban) {
        persist(kanban);
        Log.info("[Kanban] nouveau kanban sauvegarde " + kanban.getId());
        return kanban.getId();
    }

    @Transactional
    public boolean deleteById(String id) {
        return this.delete("id=?1", id) > 0;
    }
}
