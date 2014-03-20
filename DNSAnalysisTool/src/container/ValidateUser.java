package container;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.Statement;


public class ValidateUser extends HttpServlet {
	Connection conn;
	PrintWriter out;
	
	private static final long serialVersionUID = 1L;
    public ValidateUser() {
        super();  
    }
    public void init(ServletConfig config){
    	String url = "jdbc:mysql://localhost:3306/";
        String dbName = "dnsanalytics";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "root";
   
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,userName,password);
            
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
       }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		out = response.getWriter();
		out.println("namaste");
		String user_id= request.getParameter("user_id");
		String pwd= request.getParameter("pwd");
		out.println(user_id + "   "+ pwd);
		if(isUserCorrect(user_id,pwd,request))
		{
			out.println("good");
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("UserHome.jsp");
		}
		else
			out.println("bad");
		}
		boolean isUserCorrect(String user_id, String pwd,HttpServletRequest request){
			String user_name;
			HttpSession s;
			try
			{
				PreparedStatement prestmt = (PreparedStatement) conn.prepareStatement("SELECT * FROM  User where user_id='" + user_id+"'");
				//String temp="SELECT * FROM  employee where uname=" + uname;

				ResultSet res = prestmt.executeQuery();
				if(res==null){
					user_name=null;
					out.println("result set is empty");
					return false;
				}
				while (res.next()) {
						
			         String pswd = res.getString("pswd");
			         
			         out.println("the uname is  "+user_id+" the pswd is "+pswd);
			         if(pwd.equals(pswd))
			         {
			        	 user_name=res.getString("user_name");
			        	 s= request.getSession();
			 			 s.setAttribute("name", user_name);
			 			 s.setAttribute("user_id",user_id );
		        		 return true;
			         }
		           }
	        
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
			return false;

}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
public void destroy()
{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}