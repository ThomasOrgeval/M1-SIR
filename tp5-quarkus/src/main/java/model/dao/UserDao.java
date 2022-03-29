package model.dao;

import model.dao.generic.AbstractJpaDao;
import model.User;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserDao extends AbstractJpaDao<Long, User> {

    public UserDao() {
        super(User.class);
    }

    public User getUserWithName(String name) {
        return (User) entityManager.createQuery("select a from user a where name like " + name)
                .setParameter("name", name)
                .getSingleResult();
    }
}
