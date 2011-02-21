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
	if(session.isNew())
	{
	//	visits++;
	}
      String name=request.getParameter("Name");

	request.setAttribute("Name",name);
     
    PrintWriter out = response.getWriter();

    out.println("<title>Details</title>" +
       "<body bgcolor=FFFFFF>");

    out.println("<h2>Personal Details:</h2>");
    out.println("<h1> Name : " + name + "</h1>");

    out.println("<P>Return to <A HREF=\"index.html\">Form</A>");
    out.close();
  }
}
