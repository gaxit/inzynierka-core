package pl.rea.hibernate;
 
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
 
public class HibernateUtil {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    private static SessionFactory buildSessionFactory() {
        try {
        	System.out.println("Trol");
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure().buildSessionFactory();
 
        }
        catch (Throwable ex) {
        	System.out.println("Trol");
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
    	System.out.println("Trol");
        return sessionFactory;
    }
 
    public static void shutdown() {
    	System.out.println("Trol");
    	// Close caches and connection pools
    	getSessionFactory().close();
    }
 
}