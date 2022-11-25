package auth.datalab.dbConnection.dao;

import auth.datalab.dbConnection.model.DVD;
import auth.datalab.dbConnection.model.Movie;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDao {
    public void saveMovie(Movie movie){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(movie);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }else{
                e.printStackTrace();
            }
        }
    }

    public Movie searchById(int id){
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            return  session.get(Movie.class,id);
        }
    }
}
