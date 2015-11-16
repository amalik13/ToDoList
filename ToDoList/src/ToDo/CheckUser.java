package ToDo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ToDo.ListInterfece;;

/**
 * Servlet implementation class CheckUser
 */
@WebServlet("/CheckUser")
public class CheckUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,  response);
			
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess( request,  response);
		
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UN= request.getParameter("UserName");
		 String PWD= request.getParameter("Password") ;
		 PrintWriter out = response.getWriter();
		 ListInterfece T = new ListInterfece();
		 HttpSession session = request.getSession();
		 session.setAttribute("UserName", UN);
		 System.out.println("Username======"+session.getAttribute("UserName"));
		 
		 
		 boolean ExistingUser= T.isUserMatching(UN,PWD);
		 //ExistingUser=T.isUserExist(UN);
		 /*if(UN.equalsIgnoreCase("admin"))
		 {
			 out.println("<script type=\"text/javascript\">");
			  
			   out.println("location='Admin';");
			   out.println("</script>");
			 
		 }*/
		 
		 if(ExistingUser)
		 {
			 
			 
			   out.println("<script type=\"text/javascript\">");
			   out.println("alert('Logging in');");
			   out.println("location='Index.jsp';");
			   out.println("</script>");
		 
		 }
		
		 else
		 {
			 out.println("<script type=\"text/javascript\">");
			   out.println("alert('Enter values again');");
			   out.println("location='Login.html';");
			   out.println("</script>");
			 
		 }
	}

}
