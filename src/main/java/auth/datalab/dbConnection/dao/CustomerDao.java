package auth.datalab.dbConnection.dao;

import auth.datalab.dbConnection.model.Contributor;
import auth.datalab.dbConnection.model.Customer;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


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
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return  session.get(Customer.class,id);
        }
    }
}
