package org.prasad.ViewEmployee;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prasad.AddEmployee.RegisterUser;

/**
 * Servlet implementation class UpdateEmpServlet
 */
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		String fathername=request.getParameter("fathername");
		String eaddress=request.getParameter("eaddress");
		String pin=request.getParameter("epin");
		double epin=Double.parseDouble(pin);
		String edesg=request.getParameter("edesg");
		String ph=request.getParameter("ephone");
		double ephone=Double.parseDouble(ph);
		
		/* SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
        Date edob=null;
        Date edoj=null;
        try
        {
        	edoj=formatter.parse(request.getParameter("edoj"));
        	edob=formatter.parse(request.getParameter("edob"));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        */
		String edob=request.getParameter("edob");
		String edoj=request.getParameter("edoj");
		String eblood=request.getParameter("eblood");
		String eemail=request.getParameter("eemail");
		
		
		
	    int status=Updateemp.modify(eid,ename,fathername,eaddress,epin,ephone,edob,eblood,eemail,edesg,edoj);
	   
	    
		if(status>0){
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("UPDATED SUCCESSFULLY</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
				
			RequestDispatcher rd=request.getRequestDispatcher("ViewEmployees.jsp");
			rd.include(request, response);
		}
		else{
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("Sorry,Update failed. please try later</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
			
			RequestDispatcher rd=request.getRequestDispatcher("ManageEmployees.jsp");
			rd.include(request, response);
		}
		
	out.close();	
	}

}
