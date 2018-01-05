package org.prasad.Leaves.AddLeave;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prasad.AddEmployee.EmployeePojo;

/**
 * Servlet implementation class ManageLeaveServlet
 */
public class ManageLeaveServlet extends HttpServlet {
	private static String INSERT_OR_EDIT = "/ManageLeaves.jsp";
    private static String LIST_USER = "/ManageLeaveTotal.jsp";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward=" ";
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        String action = request.getParameter("action");
        String usname =request.getParameter("ename");
        String yr=request.getParameter("year");
        
        if (action.equalsIgnoreCase("delete")){
            
     
            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
    			
                PreparedStatement preparedStatement = connection.prepareStatement("delete empleaves where ename=? and year=?");
                // Parameters start with 1
                preparedStatement.setString(1,usname);
                preparedStatement.setString(2, yr);
                preparedStatement.executeUpdate();
                out.print("Data Removed Successfully");
                RequestDispatcher disp=request.getRequestDispatcher("ListLeavePositionServlet");
                disp.forward(request, response);
                
           } catch (SQLException e) {
                e.printStackTrace();
            }
           catch(ClassNotFoundException e)
           {
        	   e.printStackTrace();
           }
            forward = LIST_USER;
           // request.setAttribute("users", dao.getAllUsers());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            List<EmployeePojo> list=new ArrayList<EmployeePojo>();
                      
            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
    			
                PreparedStatement preparedStatement = con.prepareStatement("select year,ename,previllegedleave,sickleave,casualleave,total from empleaves where ename=? and year=?");
                preparedStatement.setString(1, usname);
                preparedStatement.setString(2, yr);
                ResultSet rs = preparedStatement.executeQuery();
                
                
                while(rs.next()) {
                	EmployeePojo emp=new EmployeePojo();
                	
                	emp.setYear(rs.getString("year"));
                	emp.setEemail(rs.getString("ename"));
                	emp.setPrevleave(rs.getString("previllegedleave"));
                	emp.setSickleave(rs.getString("sickleave"));
                	emp.setCasualleave(rs.getString("casualleave"));
                	emp.setTot(rs.getString("total"));
  				  	list.add(emp);
                }
                System.out.println(list.toString());
                request.setAttribute("empList", list);
                RequestDispatcher dispatcher = request.getRequestDispatcher("ManageLeaves.jsp");
                dispatcher.forward(request, response);
            
            } catch (SQLException e) {
                e.printStackTrace();
            }
            catch(ClassNotFoundException e)
            {
         	   e.printStackTrace();
            }
            
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            //request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }
		
	}

}
