package dao;

import entity.Address;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 05.07.2017.
 */
public interface AddressDao {

    //creat
    void add (Address address) throws SQLException;

    //read
    List<Address> getAll() throws SQLException;

    Address getById(Long id) throws SQLException;

    //update
    void update (Address address) throws SQLException;

    //delete
    void remove (Address address) throws SQLException;

}
