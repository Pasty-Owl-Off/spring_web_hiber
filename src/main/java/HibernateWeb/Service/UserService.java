package HibernateWeb.Service;

import HibernateWeb.DAO.UserDAO;
import HibernateWeb.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    public void add(User user) {
        userDAO.add(user);
    }

    @Transactional(readOnly = true)
    public List<User> userList() {
        return userDAO.userList();
    }

    @Transactional(readOnly = true)
    public User find(long id) {
        return userDAO.find(id);
    }

    @Transactional
    public void update(User user) {
        userDAO.update(user);
    }

    @Transactional
    public void remove(long id) {
        userDAO.remove(id);
    }
}
