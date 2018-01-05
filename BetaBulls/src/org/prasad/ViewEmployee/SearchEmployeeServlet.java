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
import javax.servlet.http.HttpSession;

import org.prasad.AddEmployee.EmployeePojo;

/**
 * Servlet implementation class ViewEmployeeServlet
 */
public class SearchEmployeeServlet extends HttpServlet {
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		  PrintWriter out = response.getWriter();
		List<EmployeePojo> list1=new ArrayList<EmployeePojo>();
		
		String search=request.getParameter("search");
				String s1=search.toUpperCase();
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("select eid,ename,eaddress,ephone,eemail from regemp where upper(ename) like '%"+s1+"%' order by eid");
			
			
			//out.print("<table width=25% border=1>");
           // out.print("<center><h1>Result:</h1></center>");
            
            ResultSet rs=ps.executeQuery();
            RequestDispatcher dispatcher=null;
            //ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next())
			{		
				EmployeePojo ePojo= new EmployeePojo();
				ePojo.setEaddress(rs.getString("eaddress"));
				ePojo.setEid(rs.getString("eid"));
				ePojo.setEname(rs.getString("ename"));
				ePojo.setEemail(rs.getString("eemail"));
				ePojo.setEphone(rs.getString("ephone"));
				
				
				list1.add(ePojo);
						
                }
			System.out.println("result is::");
			
			System.out.println(list1.toString());
			
			request.setAttribute("emplist", list1);
			request.setAttribute("search", search);
			dispatcher = request.getRequestDispatcher("SearchEmployee.jsp"); 
			dispatcher.forward(request, response);
			
			
          //out.print("</table>");

         }catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
         
           
         }

		    }
