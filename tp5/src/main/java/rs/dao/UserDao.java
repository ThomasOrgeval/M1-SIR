package rs.dao;

import rs.dao.generic.AbstractJpaDao;
import rs.domain.User;

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
