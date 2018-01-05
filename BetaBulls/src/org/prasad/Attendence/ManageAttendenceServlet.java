package org.prasad.Attendence;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ManageAttendenceServlet
 */
public class ManageAttendenceServlet extends HttpServlet {
	static int status=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//String uname=null,year=null;
		
		
		
		String ename=request.getParameter("ename");	
		String fdate=request.getParameter("fdate");
		String tin=request.getParameter("timein");
		String tout=request.getParameter("timeout");
		//String thrs=request.getParameter("thrs");
		String remark=request.getParameter("remark");
		String mnth=request.getParameter("mnth");
				
		String[] hourMin1 = tin.split(":");
	    int hour1 = Integer.parseInt(hourMin1[0]);
	    int mins1 = Integer.parseInt(hourMin1[1]);
	    int hoursInMins1 = 0;
	    hoursInMins1=hour1 * 60;
	    int tmin1=0;
	    tmin1=hoursInMins1+mins1;
	    
	    String[] hourMin2 = tout.split(":");
	    int hour2 = Integer.parseInt(hourMin2[0]);
	    int mins2 = Integer.parseInt(hourMin2[1]);
	    int hoursInMins2 = 0;
	    hoursInMins2=hour2 * 60;
	    int tmin2=0;
	    tmin2=hoursInMins2+mins2;
	    
	    int ttot=tmin2-tmin1;
		int mm=ttot%60;
		int hh=ttot/60;
		String thrs=hh+":"+mm;
		
	
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
				PreparedStatement ps=con.prepareStatement("update empattendence set timein=?,timeout=?,totalhrs=?,remarks=?,monyear=? where ename=? and cdate=?");            
	          
	            ps.setString(1, tin);
	            ps.setString(2, tout);
	            ps.setString(3, thrs);
	            ps.setString(4, remark);
	            ps.setString(5, mnth);
	            ps.setString(6, ename);
	            ps.setString(7, fdate);
	           
	            
				status=ps.executeUpdate();
				con.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	   
		if(status>0){
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("ATTENDENCE UPDATED SUCCESSFULLY</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
				
			RequestDispatcher rd=request.getRequestDispatcher("ManageAttendence.jsp");
			rd.include(request, response);
		}
		else{
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("Sorry,Attendence can't be Added!, Retry</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
			
			RequestDispatcher rd=request.getRequestDispatcher("ManageAttendence.jsp");
			rd.include(request, response);
		}
		
	out.close();	
	}

}
