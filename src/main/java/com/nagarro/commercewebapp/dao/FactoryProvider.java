package com.nagarro.commercewebapp.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryProvider {
    private static SessionFactory session;

    private FactoryProvider() {

    }

    public static SessionFactory getSession() {
        if (session == null) {
            session = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
        return session;
    }

}
