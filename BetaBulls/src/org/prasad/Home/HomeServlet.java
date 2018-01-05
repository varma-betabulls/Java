package org.prasad.Home;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.prasad.AddEmployee.EmployeePojo;


/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps=con.prepareStatement("select count(ename) from regemp");
			
            ResultSet rs=ps.executeQuery();
            RequestDispatcher dispatcher=null;
            //ResultSetMetaData rsmd=rs.getMetaData();
            int count=0;
			while(rs.next())
			{		
				count=rs.getInt("count(ename)");
                }
			System.out.println("result is::");
			request.setAttribute("empcount", count);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			String fdate=format.format(cal.getTime());
			
			Statement stmt=con.createStatement();
			ResultSet rs2=stmt.executeQuery("select ename,eemail from regemp");
						
			
			List el=new ArrayList();
			while(rs2.next())
			{
			el.add(rs2.getString("ename"));			
			}
			List<Double> below=new ArrayList<Double>();
			List<Double> above=new ArrayList<Double>();
		
			for(int i=0;i<el.size();i++)
			{
				
			String email=(String)el.get(i);
			PreparedStatement ps1=con.prepareStatement("select totalhrs from empattendence where monyear=? and ename=?");
			ps1.setString(1, fdate);
			ps1.setString(2, email);
			int cnt=0;
			ResultSet rs1=ps1.executeQuery();
			
			List<Integer> etot=new ArrayList<Integer>();
			while(rs1.next())
			{
				cnt++;
				
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
			avg=th1/cnt;
			if(avg>=9)
			{
				above.add(avg);
			}
			else
			{
				below.add(avg);
			}
			}
			
		
		int hmax=(above.size()*100)/count;
		int hmin=(below.size()*100)/count;
		request.setAttribute("hmax", hmax);
		request.setAttribute("hmin", hmin);
		request.setAttribute("below9hr", below.size());
		
		List<Long> lst1=new ArrayList<Long>();
		List<Long> lst2=new ArrayList<Long>();
		
		PreparedStatement ps2=con.prepareStatement("select leavesfrom,leavesto from uninformleave where year=?");
		ps2.setString(1, fdate);
	
		int wds=0;
		ResultSet rs3=ps2.executeQuery();
		long leav=0;
		while(rs3.next())
		{
		String lfrom=rs3.getString("leavesfrom");
		String lto=rs3.getString("leavesto");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
		    Date date1 = myFormat.parse(lfrom);
		    Date date2 = myFormat.parse(lto);
		    long diff = date2.getTime() - date1.getTime();
		    leav=(diff/1000/60/60/24)+1;
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		if(leav>2)
		{
			lst1.add(leav);
		}else
		{
			lst2.add(leav);
		}
		}
		
		long s=0;
		for(long i:lst1){
			s+=i;
		}
		long sum=Math.abs(s-(lst1.size()*2));
		request.setAttribute("lmax", lst1.size());
		request.setAttribute("lmin", lst2.size());
		request.setAttribute("eleave", sum);
		
		PreparedStatement ps3=con.prepareStatement("select count(absentfrom) from empabsent where year=?");
		ps3.setString(1, fdate);
        ResultSet rs4=ps3.executeQuery();
       
        //ResultSetMetaData rsmd=rs.getMetaData();
        int absent=0;
		while(rs4.next())
		{		
			absent=rs4.getInt("count(absentfrom)");
            }
		System.out.println("result is::");
		request.setAttribute("absent", absent);
		
	
			
					
			dispatcher = request.getRequestDispatcher("HomePage.jsp"); 
			dispatcher.forward(request, response);
			
			
          //out.print("</table>");

         }catch (Exception e2)
           {
               e2.printStackTrace();
           }

    
         
		
	}

}
