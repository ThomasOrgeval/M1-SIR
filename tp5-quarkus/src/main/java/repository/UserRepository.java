package repository;

import entity.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.logging.Log;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    @Transactional
    public Long save(User user) {
        this.persist(user);
        Log.info("[User] nouveau user sauvegarde " + user.getId());
        return user.getId();
    }

    @Transactional
    public boolean deleteById(String id) {
        return this.delete("id=?1", id) > 0;
    }
}
