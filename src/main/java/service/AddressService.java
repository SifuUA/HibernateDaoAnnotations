package service;

import businessLogig.SessionUtil;
import dao.AddressDao;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 05.07.2017.
 */
public class AddressService extends SessionUtil implements AddressDao {
    public void add(Address address) throws SQLException {

        //open Session
        openTransactionSession();

        Session session = getSession();
        session.save(address);

        //close Session
        closeTransactionSession();
    }

    public List<Address> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM ADDRESS";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addresses = query.list();

        closeTransactionSession();

        return addresses;
    }

    public Address getById(Long id) throws SQLException {

        openTransactionSession();

        String sql = "SELECT FROM ADDRESS WHERE ID = :id";
        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);

        Address address = (Address)query.getSingleResult();

        closeTransactionSession();

        return address;
    }

    public void update(Address address) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        closeTransactionSession();
    }

    public void remove(Address address) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        closeTransactionSession();
    }
}
