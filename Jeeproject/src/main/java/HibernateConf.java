import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConf {
	
	private static Session session;
	
	static {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Product.class);
		SessionFactory sf = con.buildSessionFactory();
		session = sf.openSession();
	}

	public static Session getSession() {
		return session;
	}
   
	
}
