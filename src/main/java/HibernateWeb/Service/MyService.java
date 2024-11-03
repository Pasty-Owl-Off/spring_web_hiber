package HibernateWeb.Service;

import HibernateWeb.Models.User;

import java.util.List;

public interface MyService {
    void add(User user);
    List<User> list();
    void remove(long id);
    User find(long id);
    void update(User userNew);
}
