package ToDo;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Status;
import model.Todolist;
import model.Todouser;

/**
 * Servlet implementation class ShowAllList
 */
@WebServlet("/ShowAllList")
public class ShowAllList extends HttpServlet {

	private static final long serialVersionUID = 1L;
	EntityManager em = ToDo.DBUtil.getEmFactory().createEntityManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllList() {
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
		ListInterfece WI = new ListInterfece();
		ArrayList<Todolist> TDList= new ArrayList<Todolist>();
		
		HttpSession session =  request.getSession();
		String username=(String) session.getAttribute("UserName");
				
				TDList= WI.pullProduct(username);
		String tableinfo = "";
		Todolist tdl = new Todolist();
		 
		
		for(int i=0;i<TDList.size();i++)
		{
			tdl=TDList.get(i);
			System.out.println(tdl.getTodouser());
			String id1="";
			tableinfo += "<tr><td>" + tdl.getTid()+"</td><td>" + tdl.getDescription()+"</td><td>" + tdl.getDuedate()+"</td><td>" + tdl.getCompletedate()+"</td><td>" + tdl.getStatus()+"</td><td>" + tdl.getPriority()+"</td></tr>";
			
		}
		request.setAttribute("tableinfo", tableinfo);

		getServletContext()
		.getRequestDispatcher("/ShowAllList.jsp")
		.forward(request, response);	
	}

}
