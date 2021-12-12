package User.CRUD.service;

import User.CRUD.dao.UserDAO;
import User.CRUD.dao.UserDAOImpl;
import User.CRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    @Transactional
    public List<User> allUsers() {
        return userDAO.allUsers();
    }


    @Override
    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }


    @Override
    @Transactional
    public void remove(User user) {
        userDAO.remove(user);
    }


    @Override
    @Transactional
    public void edit(User user) {
        userDAO.edit(user);
    }


    @Override
    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }
}
