package businessLogig;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Alex on 05.07.2017.
 */
public class SessionUtil {
    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public Session openSession(){
        return HibernateUtil.getSessionFactory().openSession();
    }

    public Session openTransactionSession(){
        session = getSession();
        transaction = session.getTransaction();
        return session;
    }

    public void closeSession(){
        session.close();
    }

    public void closeTransactionSession(){
        transaction.commit();
        closeSession();

    }

}
