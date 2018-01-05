package org.prasad.ViewEmployee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prasad.AddEmployee.EmployeePojo;

/**
 * Servlet implementation class ViewEmployeeServlet
 */
public class ViewEmployeeServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		
	    List elist1=new ArrayList();
		//List elist2=new ArrayList();
		//List elist3=new ArrayList();
		//List elist4=new ArrayList();
		//List elist5=new ArrayList(); 
				
		EmployeePojo emp=new EmployeePojo();
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("select eid,ename,eaddress,ephone,edesg,edoj from regemp");
			
			
			//out.print("<table width=25% border=1>");
         // out.print("<center><h1>Result:</h1></center>");
          
          ResultSet rs=ps.executeQuery();
          //ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next())
			{
				
				
				//out.print("<tr>");
              //out.print("<td>"+rsmd.getColumnName(1)+"</td>");
				
				emp.setEid(rs.getString("eid"));
			      emp.setEname(rs.getString("ename"));
			      emp.setEaddress(rs.getString("eaddress"));
			      emp.setEphone(rs.getString("ephone"));
			      emp.setEdesg(rs.getString("edesg"));
			   //   emp.setEdoj(rs.getDate("edoj"));
				   elist1.add(emp);
              }
			System.out.println("result is::");
			
			System.out.println(elist1);;
			//System.out.println(elist2);
			//System.out.println(elist3);
			//System.out.println(elist4);
			//System.out.println(elist5);
			
			request.setAttribute("empList1", elist1);
			//request.setAttribute("empList2", elist2);
			//request.setAttribute("empList3", elist3);
			//request.setAttribute("empList4", elist4);
			//request.setAttribute("empList5", elist5);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ManageEmployees.jsp");  
			dispatcher.forward(request, response);

         }catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
         
           
         }

		    }
