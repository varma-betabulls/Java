package org.prasad.Attendence;

import java.io.FileOutputStream;
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
import javax.servlet.http.HttpSession;

import org.prasad.AddEmployee.EmployeePojo;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class ListAttendencePDFServlet
 */
public class ListAttendencePDFServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
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
			
			Document my_pdf_report = new Document();
			
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("K://Reports/ListAttendencePDF.pdf"));
            my_pdf_report.open(); 
            
            Font title1 = new Font(Font.FontFamily.TIMES_ROMAN, Font.BOLD,Font.UNDERLINE);
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);
            
           my_pdf_report.add(new Paragraph("                                               LIST OF ATTENDENCE"));
           my_pdf_report.add(new Paragraph(" "));
           
           my_pdf_report.add(new Paragraph("LIST ATTENDENCE YEAR & MONTH :"));
           my_pdf_report.add(new Paragraph(fdate));
           my_pdf_report.rightMargin();
           
           my_pdf_report.add(new Paragraph(" "));
           my_pdf_report.add(new Paragraph(" "));
            PdfPTable my_report_table = new PdfPTable(5);
            
            PdfPCell table_cell;
            
            String id="EMP ID";
			table_cell=new PdfPCell(new Phrase(id,boldFont));
            my_report_table.addCell(table_cell);
            String nme="EMP NAME";
			table_cell=new PdfPCell(new Phrase(nme,boldFont));
            my_report_table.addCell(table_cell);
            String pl="WORKING DAYS";
			table_cell=new PdfPCell(new Phrase(pl,boldFont));
            my_report_table.addCell(table_cell);
            String sl="TOTAL HOURS";
			table_cell=new PdfPCell(new Phrase(sl,boldFont));
            my_report_table.addCell(table_cell);
            String cl="AVG HOURS";
			table_cell=new PdfPCell(new Phrase(cl,boldFont));
            my_report_table.addCell(table_cell);
           
            
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
				
			String eeid=empid.get(i);
			table_cell=new PdfPCell(new Phrase(eeid,boldFont1));
            my_report_table.addCell(table_cell);
			String eename=empname.get(i);
			table_cell=new PdfPCell(new Phrase(eename,boldFont1));
            my_report_table.addCell(table_cell);
						
			String pls=""+count;
			table_cell=new PdfPCell(new Phrase(pls,boldFont1));
            my_report_table.addCell(table_cell);
			String sls=""+th1;
			table_cell=new PdfPCell(new Phrase(sls,boldFont1));
            my_report_table.addCell(table_cell);
			String cls=new DecimalFormat("##.##").format(avg);
			table_cell=new PdfPCell(new Phrase(cls,boldFont1));
            my_report_table.addCell(table_cell);
			}    
			my_pdf_report.add(my_report_table); 
            my_pdf_report.close();
                
            out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("SUCCESSFULLY CONVERTED</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListAttendenceServlet");  
			dispatcher.include(request, response);
			
		}catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
