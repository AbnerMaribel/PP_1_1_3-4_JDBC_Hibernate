package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {

    }

    @Override
    public void dropUsersTable() {

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        Session session = Util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        session.save(user);
        t.commit();
        session.close();
    }

    @Override
    public void removeUserById(long id) {

        Session session = Util.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
//        session.remove();
//        session.delete();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
