package model.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserDao implements PanacheRepository<User> {

    @Transactional
    public void save(User user) {
        this.persist(user);
    }

    @Transactional
    public boolean deleteById(String id) {
        return this.delete("id=?1", id) > 0;
    }
}
