package model.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;
import model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserDao implements PanacheRepositoryBase<User, String> {

    public List<User> findAllUsers() {
        return this.listAll(Sort.descending("id"));
    }

    public Optional<User> findOne(long id) {
        User user = null;
        try {
            user = this.find("id=:id", Parameters.with("id", id)).singleResult();
        } catch (NoResultException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Transactional
    public void save(User user) {
        this.persist(user);
    }

    @Transactional
    public boolean deleteById(String id) {
        return this.delete("id=?1", id) > 0;
    }
}
