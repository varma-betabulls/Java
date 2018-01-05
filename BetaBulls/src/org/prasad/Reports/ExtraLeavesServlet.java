package org.prasad.Reports;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prasad.AddEmployee.EmployeePojo;

/**
 * Servlet implementation class ExtraLeavesServlet
 */
public class ExtraLeavesServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null;
		List<EmployeePojo> extral=new ArrayList<EmployeePojo>();
		
		
		fdate=request.getParameter("fdate");
		if(fdate==null || fdate.equals(" "))
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			fdate=format.format(cal.getTime());
		}
		
				
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps1=con.prepareStatement("select empid,empname,leavesfrom,leavesto from uninformleave where year=? order by empid");
			ps1.setString(1, fdate);
			
			
			ResultSet rs2=ps1.executeQuery();
			while(rs2.next())
			{
				EmployeePojo exleave=new EmployeePojo();
				exleave.setEid(rs2.getString("empid"));
				exleave.setEname(rs2.getString("empname"));
				exleave.setTot(rs2.getString("leavesfrom"));
				exleave.setAveg(rs2.getString("leavesto"));
							
		    extral.add(exleave);
		    
			}	
			request.setAttribute("edata", extral);
			request.setAttribute("fdate", fdate);
			System.out.println(extral.toString());
						
			RequestDispatcher dispatcher = request.getRequestDispatcher("ExtraLeaves.jsp");  
			dispatcher.forward(request, response);
			
		}catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
