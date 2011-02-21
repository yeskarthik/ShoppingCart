import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Cart extends HttpServlet {
   
	String[] s={"Washing Machine","Refrigerator","television","iron box","kettle","juice maker","ac","microwave oven","mixer grinder"};
	int[] f={7000,6000,12000,2000,1500,1000,5000,6000,2000};
    
        public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
        {
         //String s1=request.getParameter("firstname");
       String[] s3=request.getParameterValues("app");
	int visits=0;
    PrintWriter out =response.getWriter();
         String s4="0";
	String[] it=new String[10];
	String s5=request.getParameter("setting");
  	//HttpSession session=request.getSession();
          //  response.sendRedirect("Valid.html");
	//session.setAttribute("usr",s1);
           //request.setAttribute("usr",s1);
	//if(session.isNew())
	//	visits++;
	//Cookie cookie=new Cookie("visit",new Integer(visits).toString());
	request.setAttribute("item",s3);
	int fare=0;
	if(s5.compareTo("valid")==0)
	{
		fare=0;
		for(int i=0;i<s3.length;i++)
			for(int j=0;j<s.length;j++)
				if(s3[i].compareToIgnoreCase(s[j])==0)
				{
					it[i]=s3[i]+" "+"Rs."+f[j];
					fare+=f[j];
					break;
				}
	request.setAttribute("itemw",it);
	request.setAttribute("fare",fare);
	RequestDispatcher req=request.getRequestDispatcher("Valid.jsp");
           req.forward(request,response);
	}
	else 
	response.sendRedirect("fail.html");

       }

        }
    
    
    
   