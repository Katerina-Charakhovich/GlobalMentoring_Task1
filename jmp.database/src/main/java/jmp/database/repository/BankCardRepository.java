package jmp.database.repository;

import jmp.database.entity.BankCard;
import jmp.database.util.HibernateConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BankCardRepository {
    public void save(BankCard bankCard) {
        Transaction transaction = null;
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(bankCard);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<BankCard> getAll() {
        try (Session session = HibernateConfiguration.getSessionFactory().openSession()){
            return session.createNativeQuery("Select * from bankcard", BankCard.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
}
