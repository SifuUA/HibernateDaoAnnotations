package service;

import businessLogig.SessionUtil;
import dao.AddressDao;
import entity.Address;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 05.07.2017.
 */
public class AddressService extends SessionUtil implements AddressDao {
    public void add(Address address) throws SQLException {
        openTransactionSession();
    }

    public List<Address> getAll() throws SQLException {
        return null;
    }

    public Address getById(Long id) throws SQLException {
        return null;
    }

    public void update(Address address) throws SQLException {

    }

    public void remove(Address address) throws SQLException {

    }
}
