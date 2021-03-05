import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/*********************************************************************
 * 
 *        la classe penant la configuration du fichier xml hibernate.cfg.xml
 *        et l'implemente dans le code 
 *        
 ************************************************************************/

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
