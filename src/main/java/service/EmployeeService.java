package service;

import businessLogig.SessionUtil;
import dao.EmployeeDao;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 05.07.2017.
 */
public class EmployeeService extends SessionUtil implements EmployeeDao {
    public void add(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        closeTransactionSession();
    }

    public List<Employee> getAll() throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM EMPLOYEE";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employees = query.list();

        closeTransactionSession();

        return employees;
    }

    public Employee getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "SELECT * FROM EMPLOYEE WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();

        closeTransactionSession();

        return employee;
    }

    public void update(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        closeTransactionSession();
    }

    public void remove(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.delete(employee);

        closeTransactionSession();
    }
}
