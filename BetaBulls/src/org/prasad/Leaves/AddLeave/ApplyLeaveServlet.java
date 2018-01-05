/*package org.prasad.Leaves.AddLeave;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prasad.Leaves.ApplyLeave;

*//**
 * Servlet implementation class ApplyLeaveServlet
 *//*
public class ApplyLeaveServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		
		  
		String hr=request.getParameter("hr");
		String eid=request.getParameter("eid");
		String ename=request.getParameter("ename");
		
		 SimpleDateFormat formatter = new SimpleDateFormat("mm-dd-yyyy");
        Date fromdate=null;
        Date todate=null;
        try
        {
        	fromdate=formatter.parse(request.getParameter("fromdate"));
        	todate=formatter.parse(request.getParameter("todate"));
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
		String fromdate=request.getParameter("fromdate");
		String todate=request.getParameter("todate");
		String previlleged=request.getParameter("previlleged");
		String sickleave=request.getParameter("sickleave");
		String casual=request.getParameter("casual");
		String total=request.getParameter("total");		
		
		//EmployeePojo emp=new EmployeePojo();
		
int status=ApplyLeave.applyLeave(hr,eid,ename,fromdate,todate,previlleged,sickleave,casual,total);
String  toid=null;	   
if(hr=="hr" || hr=="HR" )
	   {
		   toid="kvprasadjb@gmail.com";
	   }
	   if(hr=="manager" || hr=="Manager" || hr=="MANAGER" )
	   {
		   toid="kveeraprasadk@gmail.com";
	   }
	   if(hr=="TL" || hr=="tl" )
	   {
		   toid="kvprasad41@gmail.com";
	   }
int result=ApplyLeave.send(toid,eid,ename,fromdate,todate,previlleged,sickleave,casual,total);
		if(status>0){
				out.print("WELCOME! YOU HAVE BEEN REGISTERD");
			RequestDispatcher rd=request.getRequestDispatcher("Index.jsp");
			rd.include(request, response);
		}
		else{
			out.print("Sorry,Registration failed. please try later");
			RequestDispatcher rd=request.getRequestDispatcher("AddEmployee.jsp");
			rd.include(request, response);
		}
		
	out.close();	
	}
         
	}

*/