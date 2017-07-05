package service;

import businessLogig.SessionUtil;
import dao.ProjectDao;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Alex on 05.07.2017.
 */
public class ProjectService extends SessionUtil implements ProjectDao {
    public void add(Project project) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.save(project);

        closeTransactionSession();
    }

    public List<Project> getAll() throws SQLException {

        openTransactionSession();

        String sql = "SELECT * FROM PROJECT";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projects = query.list();

        closeTransactionSession();
        return projects;
    }

    public Project getById(Long id) throws SQLException {

        openTransactionSession();

        String sql = "SELECT * FROM PROJECT WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Project project = (Project) query.getSingleResult();
        closeTransactionSession();

        return project;
    }

    public void update(Project project) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(project);

        closeTransactionSession();
    }

    public void remove(Project project) throws SQLException {

        openTransactionSession();

        Session session = getSession();
        session.remove(project);

        closeTransactionSession();
    }
}
