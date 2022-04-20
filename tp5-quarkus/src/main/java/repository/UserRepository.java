package repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import entity.User;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserRepository implements PanacheRepository<User> {

    @Transactional
    public void save(User user) {
        this.persist(user);
    }

    @Transactional
    public boolean deleteById(String id) {
        return this.delete("id=?1", id) > 0;
    }
}
