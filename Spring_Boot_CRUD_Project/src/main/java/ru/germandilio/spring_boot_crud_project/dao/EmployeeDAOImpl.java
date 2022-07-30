package ru.germandilio.spring_boot_crud_project.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.germandilio.spring_boot_crud_project.entity.Employee;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> getEmployees() {
        var session = entityManager.unwrap(Session.class);

        return session
                .createQuery("from Employee", Employee.class)
                .getResultList();
    }

    @Override
    public Employee getEmployee(int id) {
        var session = entityManager.unwrap(Session.class);

        return session.get(Employee.class, id);
    }

    @Override
    public void saveEmployee(Employee employee) {
        var session = entityManager.unwrap(Session.class);

        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        var session = entityManager.unwrap(Session.class);

        session.createQuery("delete from Employee where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
