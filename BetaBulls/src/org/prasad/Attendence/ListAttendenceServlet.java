package org.prasad.Attendence;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
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
 * Servlet implementation class ListAttendenceServlet
 */
public class ListAttendenceServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null;
		
		fdate=request.getParameter("fdate");
		String ename=request.getParameter("ename");
		if(fdate==null || fdate.equals("") || fdate=="")
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			fdate=format.format(cal.getTime());
		}
		List<EmployeePojo> edata=new ArrayList<EmployeePojo>();		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			Statement stmt=con.createStatement();
			ResultSet rs2;
			if(ename==null || ename.equals("") || ename=="")
			{
			
			rs2=stmt.executeQuery("select eid,ename from regemp order by eid");
			}
			
			else
			{
				rs2=stmt.executeQuery("select eid,ename from regemp where ename='"+ename+"' order by eid");
			}
				List<String> empid = new ArrayList<String>();
				List<String> empname = new ArrayList<String>();
				
				
				List el=new ArrayList();
				while(rs2.next())
				{
					empid.add(rs2.getString("eid"));
					empname.add(rs2.getString("ename"));
				
				el.add(rs2.getString("ename"));
					
				}
			
				for(int i=0;i<el.size();i++)
				{
					EmployeePojo listattnd=new EmployeePojo();
				String email=(String)el.get(i);
				PreparedStatement ps1=con.prepareStatement("select totalhrs from empattendence where monyear=? and ename=?");
				ps1.setString(1, fdate);
				ps1.setString(2, email);
				int count=0;
				ResultSet rs1=ps1.executeQuery();
				
				int thrs=0;
				List<Integer> etot=new ArrayList<Integer>();
				while(rs1.next())
				{
					count++;
					
					String tothrs=rs1.getString("totalhrs");
					String[] hourMin = tothrs.split(":");
				    int hour = Integer.parseInt(hourMin[0]);
				    int mins = Integer.parseInt(hourMin[1]);
				    int hoursInMins = 0;
				    hoursInMins=hour * 60;
				    int tmin=0;
				    tmin=hoursInMins+mins;
				    etot.add(tmin);
				}
				int th=0;
				for(double ttt:etot)
				{
					th+=ttt;
				}
				double th1=0;
				th1=th/60;
				double avg=0;
				avg=th1/count;
				listattnd.setEid(empid.get(i));
				listattnd.setEname(empname.get(i));
				listattnd.setWork(count);
				listattnd.setTotal(th1);
				listattnd.setAveg(new DecimalFormat("##.##").format(avg));
				
			    edata.add(listattnd);
				}
				
			request.setAttribute("edata", edata);
			//System.out.println(edata.toString());
			
			
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListAttendence.jsp");  
			dispatcher.forward(request, response);
			
		}catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
