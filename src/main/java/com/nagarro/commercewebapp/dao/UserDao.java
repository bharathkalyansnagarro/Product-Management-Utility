package com.nagarro.commercewebapp.dao;

import com.nagarro.commercewebapp.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class UserDao {
    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User getUserByEmailAndPassword(String username, String password) {
        User user = null;
        try {
            String query = "from User where username=:username and password=:password";
            Session session = sessionFactory.openSession();

            Query<User> q = session.createQuery(query);
            q.setParameter("username", username);
            q.setParameter("password", password);
            user = q.uniqueResult();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

}
