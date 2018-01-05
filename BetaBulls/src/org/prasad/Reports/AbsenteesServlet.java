package org.prasad.Reports;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
 * Servlet implementation class AbsenteesServlet
 */
public class AbsenteesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
		   // fdate=new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());
		}
		
				
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps1=con.prepareStatement("select empid,empname,absentfrom,absentto from empabsent where year=? order by empid");
			ps1.setString(1, fdate);
			
			
			ResultSet rs2=ps1.executeQuery();
			while(rs2.next())
			{
				EmployeePojo exleave=new EmployeePojo();
				exleave.setEid(rs2.getString("empid"));
				exleave.setEname(rs2.getString("empname"));
				exleave.setTot(rs2.getString("absentfrom"));
				exleave.setAveg(rs2.getString("absentto"));
							
		    extral.add(exleave);
		    
			}	
			request.setAttribute("yrs", fdate);
			request.setAttribute("edata", extral);
			System.out.println(extral.toString());
						
			RequestDispatcher dispatcher = request.getRequestDispatcher("Absent.jsp");  
			dispatcher.forward(request, response);
			
		}catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
