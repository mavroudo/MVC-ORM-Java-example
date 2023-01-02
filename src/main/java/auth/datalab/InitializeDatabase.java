package auth.datalab;

import auth.datalab.dbConnection.dao.*;
import auth.datalab.dbConnection.model.Contributor;
import auth.datalab.dbConnection.model.Customer;
import auth.datalab.dbConnection.model.DVD;
import auth.datalab.dbConnection.model.Movie;
import auth.datalab.dbConnection.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class InitializeDatabase {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));

        MovieDao movieDao = new MovieDao();
        Movie m1 = new Movie("Rear Window",1954,new ArrayList<>());
        movieDao.saveMovie(m1);
        Movie m2 = new Movie("Psycho",1960,new ArrayList<>());
        movieDao.saveMovie(m2);
        Movie m3 = new Movie("Ben-Hur",1959,new ArrayList<>());
        movieDao.saveMovie(m3);

        DVDDao dvdDao = new DVDDao();
        DVD dvd1 = new DVD(m1,"3D",3,2,new ArrayList<>());
        dvdDao.saveDVD(dvd1);
        DVD dvd2 = new DVD(m1,"SD",1,3,new ArrayList<>());
        dvdDao.saveDVD(dvd2);
        DVD dvd3 = new DVD(m2,"3D",2,2,new ArrayList<>());
        dvdDao.saveDVD(dvd3);


        CustomerDao customerDao = new CustomerDao();
        Customer customer1 = new Customer("Perskins","246801","Σολωμού","6Α");
        Customer customer2 = new Customer("Παπαδόπουλος","246801","Φιλίππου","16");
        Customer customer3 = new Customer("Παλαιολόγος","987654","Σωκράτους","20");
        customerDao.saveCustomer(customer1);
        customerDao.saveCustomer(customer2);
        customerDao.saveCustomer(customer3);

        ContributorDao contributorDao = new ContributorDao();
        Contributor contributor1 = new Contributor("Alfred Hitchcock");
        Contributor contributor2 = new Contributor("Grace Kelly");
        Contributor contributor3 = new Contributor("Antony Perkins");
        contributorDao.saveContributor(contributor1);
        contributorDao.saveContributor(contributor2);
        contributorDao.saveContributor(contributor3);

        RentDao rentDao = new RentDao();
        rentDao.saveRent(1,1,sdf.parse("2013-07-10 00:00:00"),sdf.parse("2013-09-10 00:00:00"));
        rentDao.saveRent(1,2,sdf.parse("2013-09-20 00:00:00"),sdf.parse("2013-11-20 00:00:00"));
        rentDao.saveRent(2,1,sdf.parse("2013-09-10 00:00:00"),null);

        TSDao tsDao = new TSDao();
        tsDao.saveTS(1,1,"Σκηνοθέτης");
        tsDao.saveTS(1,2,"Ηθοποιός");
        tsDao.saveTS(2,1,"Σκηνοθέτης");
        tsDao.saveTS(2,3,"Ηθοποιός");

        List<Customer> cs = customerDao.getAll();
        List<Customer> cs2 = customerDao.basedOnName("Πα%");

        Query queryLike = HibernateUtil.getSessionFactory().openSession()
                .createSQLQuery("select title from Movie left outer join DVD on DVD.IDMovie = Movie.ID left outer join Rent on Rent.IDdvd = DVD.ID where Rent.IDdvd is null");
        List<String> titles = (List<String>) queryLike.list();
        System.out.println("hey");



    }
}