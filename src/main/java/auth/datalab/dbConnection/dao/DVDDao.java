package auth.datalab.dbConnection.dao;

import auth.datalab.dbConnection.model.DVD;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DVDDao {

    public void saveDVD(DVD dvd){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(dvd);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }else{
                e.printStackTrace();
            }
        }
    }

    public DVD searchById(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return  session.get(DVD.class,id);
        }
    }
}
