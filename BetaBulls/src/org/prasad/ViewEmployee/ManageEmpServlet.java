package org.prasad.ViewEmployee;

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
 * Servlet implementation class ManageEmpServlet
 */
public class ManageEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static String INSERT_OR_EDIT = "/ManageEmployees.jsp";
    private static String LIST_USER = "/ViewEmployees.jsp";
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="";
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
        String action = request.getParameter("action");
        System.out.println(action);
        
        if (action.equalsIgnoreCase("delete")){
            String eid =request.getParameter("eid");
            System.out.println(eid);
            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
    			
                PreparedStatement preparedStatement = connection.prepareStatement("delete regemp where eid=?");
                // Parameters start with 1
                preparedStatement.setString(1,eid);
                preparedStatement.executeUpdate();
                out.print("Data Removed Successfully");
                RequestDispatcher disp=request.getRequestDispatcher("ViewEmployees.jsp");
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
           
            String eid =request.getParameter("eid");
            
            System.out.print(eid);
            try {
            	Class.forName("oracle.jdbc.driver.OracleDriver");
    			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
    			
                PreparedStatement preparedStatement = con.prepareStatement("select eid,ename,fathername,eaddress,epin,edesg,edoj,edob,ephone,eblood,eemail from regemp where eid=?");
                preparedStatement.setString(1, eid);
                ResultSet rs = preparedStatement.executeQuery();
                
                
                while(rs.next()) {
                	EmployeePojo emp=new EmployeePojo();
                	
                	emp.setEid(rs.getString("eid"));
  				  emp.setEname(rs.getString("ename"));
  				  emp.setFathername(rs.getString("fathername"));
  				  emp.setEaddress(rs.getString("eaddress"));
  				  emp.setEpin(rs.getString("epin"));
  				  emp.setEdesg(rs.getString("edesg"));
  				  emp.setEdoj(rs.getString("edoj"));
  				  emp.setEdob(rs.getString("edob"));
  				  emp.setEphone(rs.getString("ephone"));
  				  emp.setEblood(rs.getString("eblood"));
  				  emp.setEemail(rs.getString("eemail"));
  				  					
  					list.add(emp);
                }
                System.out.println(list.toString());
                request.setAttribute("empList", list);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ManageEmployees.jsp");
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
