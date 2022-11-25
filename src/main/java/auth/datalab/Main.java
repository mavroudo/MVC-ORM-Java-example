package auth.datalab;

import auth.datalab.dbConnection.dao.CustomerDao;
import auth.datalab.dbConnection.model.Customer;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

//        CustomerDao customerDao = new CustomerDao();
//
//        Customer customer = new Customer("Mavroudopoulos","1234567","Panepistimia","18");
//        customerDao.saveCustomer(customer);



    }
}