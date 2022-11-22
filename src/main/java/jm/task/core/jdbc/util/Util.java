package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    private static final String URL = "jdbc:postgresql://localhost:5432/my_db";
    private static Connection connection;
    private static SessionFactory sessionFactory;

    private Util() {}

    public static Connection getConnection() {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties properties = new Properties();
                properties.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
                properties.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/my_db");
                properties.setProperty("dialect", "org.hibernate.dialect.PostgresSQL");
                properties.setProperty("show_sql", "true");
                sessionFactory = new Configuration().addProperties(properties).addAnnotatedClass(User.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                System.out.println("Исключение!" + e);
            }
        }
        return sessionFactory;
    }
}