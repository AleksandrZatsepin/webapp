package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManage;

    @Override
    public void add(User user) {
        entityManage.persist(user);
    }

    @Override
    public void remove(User user) {
        entityManage.remove(entityManage.contains(user) ? user : entityManage.merge(user));
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query=entityManage.createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public void updateUser(User user) {
        entityManage.merge(user);
    }

    @Override
    public User getUser(long id) {
        return entityManage.find(User.class, id);
    }
}
