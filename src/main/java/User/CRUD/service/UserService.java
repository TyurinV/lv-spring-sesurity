package User.CRUD.service;

import User.CRUD.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> allUsers();
    void add(User user);
    void remove(User user);
    void edit(User user);
    User getById(int id);
}
