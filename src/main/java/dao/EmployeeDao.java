package dao;

import entity.Employee;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 05.07.2017.
 */
public interface EmployeeDao {

    //creat
    void add (Employee employee) throws SQLException;

    //read
    List<Employee> getAll() throws SQLException;

    Employee getById(Long id) throws SQLException;

    //update
    void update (Employee employee) throws SQLException;

    //delete
    void remove (Employee employee) throws SQLException;
}
