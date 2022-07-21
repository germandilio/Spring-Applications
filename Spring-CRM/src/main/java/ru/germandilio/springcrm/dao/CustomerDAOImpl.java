package ru.germandilio.springcrm.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import ru.germandilio.springcrm.entity.Customer;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public CustomerDAOImpl(@Qualifier("hibernateSessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Customer getCustomer(int id) {
        var session = sessionFactory.getCurrentSession();
        return session.get(Customer.class, id);
    }

    @Override
    public void saveCustomer(Customer customer) {
        var session = sessionFactory.getCurrentSession();

        session.save(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        var session = sessionFactory.getCurrentSession();

        session.update(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        var session = sessionFactory.getCurrentSession();

        session.createQuery("delete from Customer where id=:id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Customer> getCustomers() {
        var currentSession = sessionFactory.getCurrentSession();
        return currentSession
                .createQuery("from Customer order by firstName", Customer.class)
                .getResultList();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        if (searchName == null || searchName.isBlank()) return null;

        var currentSession = sessionFactory.getCurrentSession();

        return currentSession.createQuery("from Customer where lower(firstName) like :searchName or lower(lastName) like :searchName", Customer.class)
                .setParameter("searchName", "%" + searchName + "%")
                .getResultList();
    }
}
