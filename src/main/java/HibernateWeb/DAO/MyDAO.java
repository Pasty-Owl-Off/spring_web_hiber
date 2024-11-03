package HibernateWeb.DAO;

import HibernateWeb.Models.User;

import java.util.List;

public interface MyDAO {
    void add(User user);
    List<User> list();
    void remove(long id);
    User find(long id);
    void update(User userNew);
}
