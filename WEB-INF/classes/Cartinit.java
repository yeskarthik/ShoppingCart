import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Cartinit extends HttpServlet 
{
   	String[] name={"Madhavi","madhu","vasuki","janani","kannan"};
	String[] pwd={"mad","madh","vas","jan","kan"};
	String s1,s2,s3;
	int flag;	
	int comparePwd()
	{
		flag=1;
		for(int i=0;i<5;i++)
		{
			if(s1.compareToIgnoreCase(name[i])==0 && s3.compareToIgnoreCase(pwd[i])==0)
			{
				flag=0;
				break;
			}
		}
		return flag;
	}		
    	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
        	{
	         s1=request.getParameter("firstname");
	         s3=request.getParameter("pwd1");
	        PrintWriter out =response.getWriter();
	         String s5=request.getParameter("setting");
  	        HttpSession session=request.getSession();
	          //  response.sendRedirect("Valid.html");
	        session.setAttribute("usr",s1);
	        Cookie cookie=new Cookie("name",s1);
	        response.addCookie(cookie);
	       if(!session.isNew())
	       {
	       	Cookie[] cookies=request.getCookies();
	      	int c=0;
	      	for(int i=0;i<cookies.length;i++)
	      		if(cookies[i].getValue().equals(s1))
			{
				c=1;
				break;
			}
			
		 if(c==1)
		          session.setAttribute("old","yes");
	     	 else
		        session.setAttribute("old","no");
	       }
           	      //request.setAttribute("usr",s1);
	      flag=comparePwd();
	      if(flag==0 && s5.compareTo("valid")==0)
	     {
		RequestDispatcher req=request.getRequestDispatcher("index1.jsp");
		req.forward(request,response);
		//response.sendRedirect("index1.jsp");
	      }
	      else 
		response.sendRedirect("fail.html");


        }
}    
    
    
   