package org.prasad.feps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FepsClockoutServlet
 */
public class FepsClockoutServlet extends HttpServlet {

	static int status=0;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			HttpSession session=request.getSession();
			String user=(String)session.getAttribute("name");
			System.out.println(user);
	try {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
				PreparedStatement pss=con.prepareStatement("select clockout from clocktable where clockout>=sysdate-1 and username=?");
				pss.setString(1, user);
				ResultSet rs1=pss.executeQuery();
				Timestamp date=null;
				while(rs1.next())
				{
				date = rs1.getTimestamp("clockout");
				}
			    if(date!=null)
			    {
			    	out.print("Already CLOCKOUT....");
			    	RequestDispatcher rd=request.getRequestDispatcher("HomePage1.jsp");
			    	rd.include(request, response);
			    }
			    else
			    {		
				PreparedStatement ps=con.prepareStatement("UPDATE CLOCKTABLE set clockout=TO_TIMESTAMP_TZ(CURRENT_TIMESTAMP, 'DD-MM-YYYY HH.MI.SSXFF PM TZH:TZM') where clockin>=sysdate-1 and username=?"); 
				ps.setString(1, user);
				status=ps.executeUpdate();
			    }
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	if(status>0){
		out.print("Clock Out Successfully at : ");
		Date date=new Date();
		out.print(date.toString());
	RequestDispatcher rd=request.getRequestDispatcher("HomePage1.jsp");
	rd.include(request, response);
	}
	else{
	out.print("Sorry,Clock Out Failed.. Plz Clock Out  Again");
	RequestDispatcher rd=request.getRequestDispatcher("HomePage1.jsp");
	rd.include(request, response);
	}
			
	}

}
