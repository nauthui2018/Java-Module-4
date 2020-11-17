package nauthui.service;

import nauthui.model.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.*;

import static java.util.Arrays.asList;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<Customer> findAll() {
        return null;
    }

    @Override
    public Customer findById(Long id) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(Long id) {

    }
}
