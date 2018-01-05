package org.prasad.TimeSheet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ViewTimeSheetServlet
 */
public class ViewTimeSheetServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null;
		fdate=request.getParameter("fdate");
		if(fdate==null)
		{
			
		    fdate=new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());

		}
		System.out.println(fdate);
		List<ClockPojo> clist=new ArrayList<ClockPojo>();
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("name");
		System.out.println(user);

		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps1=con.prepareStatement("select clockin,clockout,username from clocktable where to_char(clockin,'yyyy-mm')=? and username=?");
			ps1.setString(1, fdate);
			ps1.setString(2, user);
			
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				ClockPojo cpojo=new ClockPojo();
				
				Timestamp date=rs1.getTimestamp("clockin");
				System.out.println(date);
				cpojo.setDate(date.getDate()+":"+date.getMonth()+":"+date.getYear());
				cpojo.setTimein(date.getHours()+":"+date.getMinutes()+":"+date.getSeconds());
				String username=rs1.getString("username");
				Timestamp cout=rs1.getTimestamp("clockout");
				if(cout!=null)
				{
				cpojo.setTimeout(cout.getHours()+":"+cout.getMinutes()+":"+cout.getSeconds());
					
				int hr=Math.abs(cout.getHours()-date.getHours());
				int min=Math.abs(cout.getMinutes()-date.getMinutes());
				int sec=Math.abs(cout.getSeconds()-date.getSeconds());
				
				String tot1=""+hr;
				String tot2=""+min;
				String tot3=""+sec;
				cpojo.setTotal(tot1+":"+tot2+":"+tot3);
				}
				else
				{
					cpojo.setTimeout(" ");
					cpojo.setTotal(" ");
				}
				
			//Date total=(Date)(toDate.getTime()-fromDate.getTime());
				//cpojo.setTotal(hr+":"+min+":"+sec);
				clist.add(cpojo);
			}
			
			System.out.println("result is::");
			request.setAttribute("clock", clist);
			System.out.println(clist.toString());
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewTimeSheet.jsp");  
			dispatcher.forward(request, response);
			
			
         }catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
