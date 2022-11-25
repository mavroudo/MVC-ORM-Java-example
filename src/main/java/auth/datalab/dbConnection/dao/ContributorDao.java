package auth.datalab.dbConnection.dao;

import auth.datalab.dbConnection.model.Contributor;
import auth.datalab.dbConnection.model.Movie;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ContributorDao {

    public void saveContributor(Contributor contributor){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(contributor);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }else{
                e.printStackTrace();
            }
        }
    }

    public Contributor searchById(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return  session.get(Contributor.class,id);
        }
    }
}
