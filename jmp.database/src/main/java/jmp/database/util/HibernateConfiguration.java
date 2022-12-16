package jmp.database.util;

import jmp.database.entity.BankCard;
import jmp.database.entity.Subscription;
import jmp.database.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateConfiguration {
    private static SessionFactory sessionFactory;

    private HibernateConfiguration() {
    }

    private static SessionFactory getSessionFactoryConfiguration() {
        Configuration configuration = new Configuration();
        configuration.setProperty("hibernate.current_session_context_class", "thread");
        configuration.setProperty("hibernate.ejb.metamodel.population", "disabled");
        // DB Connection
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class", "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem:");
        configuration.setProperty("hibernate.connection.username", "");
        configuration.setProperty("hibernate.connection.password", "");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        // Register entitiy classes
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Subscription.class);
        configuration.addAnnotatedClass(BankCard.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();

        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;

    }
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = getSessionFactoryConfiguration();
        }
        return sessionFactory;
    }
}
