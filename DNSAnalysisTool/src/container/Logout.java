package container;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn;
	PrintWriter out;
       
    public Logout() {
        super();
         }
	public void init(ServletConfig config) throws ServletException {
		String url = "jdbc:mysql://localhost:3306/";
        String dbName = "dnsanalytics";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
   
        try {
            Class.forName(driver).newInstance();
            conn = (Connection) DriverManager.getConnection(url+dbName,userName,password);
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }	
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out= response.getWriter();
		HttpSession s =request.getSession();
		java.util.Date d =new java.util.Date();
		out.write(d.toString()+s.toString());
		String user_id =(String) s.getAttribute("user_id");
		String str = "Update User set last_login=? where user_id =?"; 
		String str1 = "Update User set Login=? where user_id =?"; 
		try{
			PreparedStatement prestmt = (PreparedStatement) conn.prepareStatement(str);
			PreparedStatement prestmt1 = (PreparedStatement) conn.prepareStatement(str1);
			prestmt.setString(1,d.toString());
			prestmt.setInt(2,Integer.parseInt(user_id));
			prestmt1.setInt(1, 0);
			prestmt1.setInt(2, Integer.parseInt(user_id));
			prestmt.executeUpdate();
			prestmt1.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		s.invalidate();
		out.write("logout");
		response.sendRedirect("Login.jsp");
	}
public void destroy() {
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
