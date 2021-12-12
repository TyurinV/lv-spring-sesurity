package User.CRUD.dao;

import User.CRUD.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager em;

    @Override
    @Transactional
    public List<User> allUsers() {
        return em.createQuery("from User").getResultList();
    }

    @Override
    @Transactional
    public void add(User user) {
        em.persist(user);
    }

    @Override
    @Transactional
    public void remove(User user) {
        em.remove(em.contains(user) ? user : em.merge(user));
    }

    @Override
    @Transactional
    public void edit(User user) {
        em.merge(user);
    }

    @Override
    @Transactional
    public User getById(int id) {
        return em.find(User.class, id);
    }
}