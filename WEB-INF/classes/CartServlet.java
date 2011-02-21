import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CartServlet extends HttpServlet {
   
	String[] s= {"adidas","reebok","nike","kanchipuram","ahimsa","samudrika","denim","levis","pepe"};
	int[] p={ 500,700,900,1600,2200,4000,1000,900,1500};

	 public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
        {
		
		response.setContentType("text/html");

		String selected=request.getParameter("item");
		
		request.setAttribute("item",selected);
	
		String qty=request.getParameter("quantity");
		
		request.setAttribute("quantity",qty);
		
		Cookie cookie = new Cookie(selected,qty);
	
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("Item : " + selected);
		
		out.println("Quantity : " + qty);

		out.println("</html>");

		//out.println("<script type='text/javascript'> window.alert('Added to cart');</script>");
	
		response.addCookie(cookie);
				
		response.sendRedirect("index.html");
	}
}
