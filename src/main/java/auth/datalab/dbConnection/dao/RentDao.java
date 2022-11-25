package auth.datalab.dbConnection.dao;

import auth.datalab.dbConnection.model.Customer;
import auth.datalab.dbConnection.model.DVD;
import auth.datalab.dbConnection.model.Rent;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class RentDao {

    private DVDDao dvdDao;
    private CustomerDao customerDao;

    public RentDao() {
        this.dvdDao=new DVDDao();
        this.customerDao=new CustomerDao();
    }

    public void saveRent(int idCustomer, int idDvd, Date start, Date end){
        Customer c = this.customerDao.searchById(idCustomer);
        DVD d = this.dvdDao.searchById(idDvd);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(new Rent(c,d,start,end));
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }else{
                e.printStackTrace();
            }
        }

    }
}
