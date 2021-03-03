
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class HibernateUtils {

	static Session session = HibernateConf.getSession();
	private Product product1;
	
   
   public static List<Product> ProductsSearch(String productName){
	   
	    List<Product> list = new ArrayList<Product>();
		
		String hql = "FROM produit R WHERE R.product_name =:id";
		@SuppressWarnings("unchecked")
		Query<Product> createQuery = session.createQuery(hql);
		createQuery.setParameter("id", productName);
		list = createQuery.list();
		return list;
	   
   }
   


}
