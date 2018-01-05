package org.prasad.Leaves.AddLeave;

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
import javax.servlet.http.HttpSession;

import org.prasad.AddEmployee.EmployeePojo;

/**
 * Servlet implementation class MangLvServlet
 */
public class MangLvServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null,ename=null;
		
		fdate=request.getParameter("fdate");
		ename=request.getParameter("ename");
		if(fdate==null || fdate.equals(""))
		{
		    fdate=new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());
		}
		
				
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			Statement stmt=con.createStatement();
			ResultSet rs2;
			if(ename==null || ename.equals(""))
			{
				rs2=stmt.executeQuery("select eid,ename from regemp order by eid");
			}
			else
			{
			rs2=stmt.executeQuery("select eid,ename from regemp where ename='"+ename+"' order by eid ");
			}
			List<String> empid = new ArrayList<String>();
			List<String> empname = new ArrayList<String>();
			List<EmployeePojo> edata=new ArrayList<EmployeePojo>();
			List el=new ArrayList();
			while(rs2.next())
			{
				empid.add(rs2.getString("eid"));
				empname.add(rs2.getString("ename"));
			//below9hr.setEid(rs2.getString("eid"));
			//below9hr.setEname(rs2.getString("ename"));
			el.add(rs2.getString("ename"));
			//edata.add(below9hr);
						
			}
		
			for(int i=0;i<el.size();i++)
			{
				EmployeePojo listleave=new EmployeePojo();
			String email=(String)el.get(i);
			PreparedStatement ps1=con.prepareStatement("select year,previllegedleave,sickleave,casualleave,total,ename from empleaves where year=? and ename=?");
			ps1.setString(1, fdate);
			ps1.setString(2, email);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
		
			listleave.setEid(empid.get(i));
			listleave.setEname(empname.get(i));
			String yearof=rs1.getString("year");
			listleave.setPrevleave(rs1.getString("previllegedleave"));
			listleave.setSickleave(rs1.getString("sickleave"));
			listleave.setCasualleave(rs1.getString("casualleave"));
			listleave.setTot(rs1.getString("total"));
			listleave.setEemail(rs1.getString("ename"));
		    edata.add(listleave);
		    
			} 
			}	
			request.setAttribute("yrs", fdate);
			request.setAttribute("edata", edata);
			System.out.println(edata.toString());
						
 			RequestDispatcher dispatcher = request.getRequestDispatcher("ManageLeaveTotal.jsp");  
			dispatcher.forward(request, response);
			
		}catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
