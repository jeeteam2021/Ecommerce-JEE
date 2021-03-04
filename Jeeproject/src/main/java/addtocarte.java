import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/product")
public class addtocarte extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public addtocarte() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Product produit6 = new Product();
		String name = request.getParameter("poduit");
		String quantity = request.getParameter("quantity");
		produit6 = getproduct(name);
		addproducttocart(77,122,7);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
	
	protected Product getproduct(String Name){
		Connection con;
		Product ger = new Product();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/EcomProject";
			String user = "JEE";
			String pwd ="0000";
			con = DriverManager.getConnection(url,user,pwd);
			Statement S = con.createStatement();
			String query = "select * from produit where product_name ="+Name+"%';";
			ResultSet rs = S.executeQuery(query);
			ger.setProduct_Id(rs.getString(1));
			ger.setProduct_Name(rs.getString(2));
			ger.setProduct_Image(rs.getString(3));
			ger.setProduct_Description(rs.getString(4));
			ger.setProduct_Price(Integer.parseInt(rs.getString(5)));
			
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException f){
			f.printStackTrace();
		}
		finally {}
		
		return ger;
	}
	
	public void addproducttocart(int t0,int t1,int t2){
		Connection con;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost/EcomProject";
			String user = "JEE";
			String pwd ="0000";
			con = DriverManager.getConnection(url,user,pwd);
			Statement S = con.createStatement();
			String query = "INSERT INTO cart1 " + 
			        "(cart_id,product_id,product_quantity) " + 
			        "VALUES ('"+t0 + "','" +t1 + "','" + t2 +"')";
			S.execute(query);
			return;
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(SQLException f){
			f.printStackTrace();
		}
		finally {}
	}

}