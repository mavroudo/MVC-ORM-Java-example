package auth.datalab.dbConnection.dao;

import auth.datalab.dbConnection.model.Contributor;
import auth.datalab.dbConnection.model.Customer;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.util.List;


public class CustomerDao {


    public void saveCustomer(Customer customer){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }else{
                e.printStackTrace();
            }
        }
    }

    public Customer searchById(int id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return  session.get(Customer.class,id);
        }
    }

    public List<Customer> getAll(){
        return HibernateUtil.getSessionFactory().openSession()
                .createQuery("select c from Customer c", Customer.class).list();
    }

    @SuppressWarnings({})
    public List<Customer> basedOnName(String pattern){
        Query queryLike = HibernateUtil.getSessionFactory().openSession()
                .createSQLQuery("select * from Customer where surname like :pattern");
        queryLike.setParameter("pattern",pattern);
        return (List<Customer>) queryLike.list();
    }
}
