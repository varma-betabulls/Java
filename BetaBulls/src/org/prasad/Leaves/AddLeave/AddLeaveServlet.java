package org.prasad.Leaves.AddLeave;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.prasad.AddEmployee.RegisterUser;

/**
 * Servlet implementation class AddLeaveServlet
 */
public class AddLeaveServlet extends HttpServlet {
	static int status=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=null,year=null;
		
		String y=request.getParameter("yrs");
		String ename=request.getParameter("ename");
		String prv=request.getParameter("pleave");		
		String sick=request.getParameter("sleave");	
		String casual=request.getParameter("cleave");	
		String tot=request.getParameter("total");
		
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("name");
		String empname=(String)session.getAttribute("empname");
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			PreparedStatement ps1=con.prepareStatement("select ename,year from empleaves where ename=? and year=?");
			ps1.setString(1, ename);
			ps1.setString(2, y);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				uname=rs1.getString("ename");
				year=rs1.getString("year");
			}
			
			if(ename.equals(uname) && y.equals(year))
			{
				out.print("LEAVES ALREADY ADDED TO THIS ACCOUNT");
				RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
				rd.include(request, response);
			
			}
			else 
			{
				PreparedStatement ps=con.prepareStatement("insert into empleaves(ename,year,previllegedleave,sickleave,casualleave,total)  values(?,?,?,?,?,?)");            
	            ps.setString(1, ename);
	            ps.setString(2, y);
	            ps.setString(3, prv);
	            ps.setString(4, sick);
	            ps.setString(5, casual);
	            ps.setString(6, tot);
	            
	            
				status=ps.executeUpdate();
				con.close();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	   
		if(status>0){
				out.print("LEAVES HAVE BEEN ADDED SUCCESSFULLY");
			RequestDispatcher rd=request.getRequestDispatcher("HomeServlet");
			rd.include(request, response);
		}
		else{
			out.print("Sorry,Leaves can't be Added!, Retry");
			RequestDispatcher rd=request.getRequestDispatcher("AddLeaves.jsp");
			rd.include(request, response);
		}
		
	out.close();	
	}

}
