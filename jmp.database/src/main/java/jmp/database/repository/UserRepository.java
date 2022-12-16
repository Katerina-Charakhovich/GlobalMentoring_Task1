package jmp.database.repository;

import jmp.database.util.HibernateConfiguration;
import jmp.database.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserRepository {
    public void save(User user) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<User> getAll() {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){
            return session.createNativeQuery("Select * from user", User.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
