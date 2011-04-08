import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalcServlet extends HttpServlet {
   
	String[] s= {"adidas","reebok","nike","kanchipuram","ahimsa","samudrika","denim","levis","pepe"};
	int[] p={ 500,700,900,1600,2200,4000,1000,900,1500};

	 public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
        {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html> <head> <title> Your Bill </title><link rel='stylesheet' type='text/css' href='CSS/style.css'></head>"+"<body><br/><br/><br/><center> <table> <tr> <th> Item </th> <th> Quantity </th> <th> Price </th> </tr>");
			
		int total=0,price=0,q=0;
		Cookie cookie[] = request.getCookies();
		if(cookie!=null)
		{
			
			for(int i=0; (i<cookie.length);i++)
			{
				
				String sel=cookie[i].getName();
//				int q=Integer.parseInt(cookie[k].getValue());
				for(int j=0;j<s.length;j++)
				{
					if(s[j].equals(sel))
					{
						String s=cookie[i].getValue();						
						if(s.equals("")!=true)
						{
						q=Integer.parseInt(cookie[i].getValue());
						
						price=p[j];			
						out.print("<tr><td>"+sel+"</td><td>"+q+"</td><td>"+price+"</td><td>");			
						break;}
					}
				} 	
				total+=price*q;
				
			}	
		}
	//	PrintWriter out = response.getWriter();
		out.print("</center><br/><br/><br/>"+"<p id='nametext' style='display : block;' >Total= Rs."+total +"</p></body></html>");
if(cookie!=null)
		{
 for(int i=0; (i<cookie.length);i++)
                        {
				cookie[i].setValue("");
				response.addCookie(cookie[i]);}}
//		RequestDispatcher req=request.getRequestDispatcher("invoice.jsp");

//	req.forward(request,response);
		/*for(i=0;i<cookie.length;i++)
		{
		out.println("<html>");
		
		out.println("Item : " + selected);
		
		out.println("Quantity : " + qty);
		
		
		}*/
//		out.println("<html> <head> <title> Your Bill </title><link rel='stylesheet' type='text/css' href='CSS/style.css'></head>"+"<body>Total : "+total+"</body>");

//		out.println("</html>");
		HttpSession session=request.getSession();
		session.invalidate();
	
	}
}
