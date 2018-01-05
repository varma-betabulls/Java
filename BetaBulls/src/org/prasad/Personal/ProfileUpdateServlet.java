package org.prasad.Personal;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prasad.ViewEmployee.Updateemp;

/**
 * Servlet implementation class ProfileUpdateServlet
 */
public class ProfileUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String mailid=request.getParameter("mailid");
		String ph=request.getParameter("mobile");
		double mobile=Double.parseDouble(ph);
		String address=request.getParameter("address");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String pin=request.getParameter("zip");
		double zip=Double.parseDouble(pin);
		String edob=request.getParameter("dob");
		
		/*SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
        Date edob=null;
        try
        {
        	edob=formatter.parse(request.getParameter("dob"));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        } */
        		
		
	    int status=ProfileUpdate.modify(fname,lname,mailid,mobile,address,edob,city,state,zip);
	   
	    
		if(status>0){
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("UPDATED SUCCESSFULLY</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
			RequestDispatcher rd=request.getRequestDispatcher("Profile.jsp");
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
			RequestDispatcher rd=request.getRequestDispatcher("ProfileEdit.jsp");
			rd.include(request, response);
		}
		
	out.close();	
	}

	}


