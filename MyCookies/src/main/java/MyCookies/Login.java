package MyCookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("Link.html").include(request, response);  
          
        String Name=request.getParameter("name");  
        String Email=request.getParameter("email");  
        String Pass=request.getParameter("pass");  
          
        if(Email.equals("admin@gmail.com")&& Pass.equals("admin")){  
            out.print("<h2>You are successfully logged in!</h2>");  
            out.print("<br><h2>Welcome, "+Name+"</h2>");  
              
            Cookie ck=new Cookie("id",Name);  
            response.addCookie(ck);  
        }else{  
            out.print("<h2>sorry, username or password error!</h2>");  
            request.getRequestDispatcher("Login.html").include(request, response);  
        }  
        out.close();
		
		doGet(request, response);
	}

}
