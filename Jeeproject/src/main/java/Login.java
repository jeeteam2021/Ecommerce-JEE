import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher; 
import java.sql.*;

/*********************************************************************
 * 
 *        la servlet gerant l'activite login de l'utilisateur 
 *        si le mdp est errone il ne va pas avoir acces au site
 ************************************************************************/

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    
    if(TestUser(email, password))
    {
        RequestDispatcher rs = request.getRequestDispatcher("RegisterNew.jsp");
        rs.forward(request, response);
    }
    else
    {
       out.println("Username or Password incorrect");
       RequestDispatcher rs = request.getRequestDispatcher("page1.jsp");
       rs.include(request, response);
    }  
        }
        
	
public static boolean TestUser(String email,String password) 
{
    boolean st =false;
    try {

    	Connection con;
    	Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost/ecomproject";
		String user = "JEE";
		String pwd ="0000";
		con = DriverManager.getConnection(url,user,pwd);
        PreparedStatement ps = con.prepareStatement("select * from utilisateur where email=? and password=?");
        ps.setString(1,email);
        ps.setString(2,password);
        ResultSet rs =ps.executeQuery();
        st = rs.next();
      
    }
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	catch(SQLException f){
		f.printStackTrace();
	}
    return st;                 
} 
  
	}
	

