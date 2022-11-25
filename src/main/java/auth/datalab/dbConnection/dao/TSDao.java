package auth.datalab.dbConnection.dao;

import auth.datalab.dbConnection.model.Contributor;
import auth.datalab.dbConnection.model.Movie;
import auth.datalab.dbConnection.model.TS;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TSDao {

    private MovieDao movieDao;
    private ContributorDao contributorDao;

    public TSDao() {
        this.movieDao= new MovieDao();
        this.contributorDao = new ContributorDao();
    }

    public void saveTS(int idMovie, int idContributor, String role){
        Movie m = this.movieDao.searchById(idMovie);
        Contributor c = this.contributorDao.searchById(idContributor);
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.saveOrUpdate(new TS(m,c,role));
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
