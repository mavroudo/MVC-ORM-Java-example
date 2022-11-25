package auth.datalab.dbConnection.util;

import auth.datalab.dbConnection.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            try{
                Configuration configuration = new Configuration();
                //Hiberante settings instead of using an xml properties file
                Properties settings= new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL,"jdbc:mysql://localhost:3306/dvdclub?serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true");
                settings.put(Environment.USER, "root");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "create");
                System.out.println(Environment.HBM2DDL_AUTO);

                configuration.setProperties(settings);

                //Here we add all the annotated classes
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(Movie.class);
                configuration.addAnnotatedClass(DVD.class);
                configuration.addAnnotatedClass(RentId.class);
                configuration.addAnnotatedClass(Rent.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
