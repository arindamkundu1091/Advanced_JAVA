package jdbc.crud;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Profile() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		ServletContext context = request.getServletContext();
		String upass = (String)context.getAttribute("pass");
		Connection con;
		PreparedStatement pstm;
		ResultSet rs;
		String name = "";
		String email = "";
		String pass = "";
		int id = 0;
		Cookie ck[]=request.getCookies();  
        if(ck!=null){  
            String data=ck[0].getValue();  
            if(!data.equals("")|| data!=null){
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");//Registering the Driver
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userrecord","root","Arindam#1091");
					pstm = con.prepareStatement("select *from user where password=?");
					pstm.setString(1, upass);
					rs = pstm.executeQuery();
					while(rs.next()) {
						id = rs.getInt(1);
						name = rs.getString(2);
						email = rs.getString(3);
						pass = rs.getString(4);
					}
					pw.println(" || Id: "+id);
		            pw.println(" || Name: "+name);
		            pw.println(" || Email: "+email);
		            pw.println(" || Password: "+pass);
				}catch(Exception e) {
					pw.println(e);
				}
            }
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
