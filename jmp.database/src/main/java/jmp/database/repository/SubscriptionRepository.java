package jmp.database.repository;

import jmp.database.entity.Subscription;
import jmp.database.util.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SubscriptionRepository {
    public void save(Subscription subscription) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(subscription);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Subscription> getAll() {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            return session.createNativeQuery(
                    "Select * from subscription", Subscription.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Subscription getSubscriptionByCardNumber(String bankCardNumber) {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            var subscriptionList = session.createNativeQuery(
                            "Select * from subscription where bankCard = :bankCardNumber", Subscription.class)
                    .setParameter("bankCardNumber", bankCardNumber)
                    .getResultList();
            if (subscriptionList.isEmpty()) {
                return null;
            }
            return subscriptionList.get(0);
        } catch (Exception e) {
            return null;
        }
    }
}
