package HibernateWeb.DAO;

import HibernateWeb.Models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }

    public List<User> userList() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    public void remove(long id) {
        User user = find(id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    public User find(long id) {
        return entityManager.find(User.class, id);
    }

    public void update(User userNew) {
        User userOld = find(userNew.getId());
        if (userOld != null) {
            userOld.setAge(userNew.getAge());
            userOld.setName(userNew.getName());
            userOld.setSurname(userNew.getSurname());
        } else {
            System.out.println("Пользователь не найден");
        }
    }
}
