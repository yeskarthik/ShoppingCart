import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class FirstServlet extends HttpServlet 
{
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
        response.setContentType("text/html");
	HttpSession session=request.getSession();
	int visits=0;
	if(session.isNew())
	{
		visits++;
	}
      String name=request.getParameter("Name");
		request.setAttribute("Name",name);
	   Cookie cookie[] = request.getCookies();
		
	session.setAttribute("Name",name);
		
		
	 RequestDispatcher req=request.getRequestDispatcher("index1.jsp");
	    req.forward(request,response);
  }
	
		
}
