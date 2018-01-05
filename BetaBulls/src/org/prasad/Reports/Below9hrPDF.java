package org.prasad.Reports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
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
import javax.servlet.http.HttpSession;

import org.prasad.AddEmployee.EmployeePojo;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

/**
 * Servlet implementation class Below9hrPDF
 */
public class Below9hrPDF extends HttpServlet {
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null,fmnth=null,fyear=null;
		
		fdate=request.getParameter("fdate");
		if(fdate==null || fdate.equals(""))
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			fdate=format.format(cal.getTime()); 

		}
			SimpleDateFormat formatter = new SimpleDateFormat("MM");
	        SimpleDateFormat format=new SimpleDateFormat("yyyy");

	        try {

	            Date date = formatter.parse(fdate);
	            System.out.println(date);
	            fmnth=formatter.format(date);
	            fyear=format.format(date);

	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			Statement stmt=con.createStatement();
			ResultSet rs2=stmt.executeQuery("select eid,ename,eemail from regemp order by eid");
			List<String> empid = new ArrayList<String>();
			List<String> empname = new ArrayList<String>();
			
			List el=new ArrayList();
			int fm=Integer.parseInt(fmnth);
			int fy=Integer.parseInt(fyear);			
			int result=Below9hr.countWeekendDays(fm,fy);
			Document my_pdf_report = new Document();
			
	        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("K://Reports/Below9hrs.pdf"));
	        my_pdf_report.open(); 
	        
	        Font title1 = new Font(Font.FontFamily.TIMES_ROMAN, Font.BOLD,16);
	        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
	        Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);
	        
	       my_pdf_report.add(new Paragraph("                                               REPORT ON BELOW 9 HRS"));
	       my_pdf_report.add(new Paragraph(" "));
	       my_pdf_report.add(new Paragraph(" "));
	       my_pdf_report.add(new Paragraph("Month & Year : "));
	       my_pdf_report.add(new Paragraph(fdate));
	       my_pdf_report.add(new Paragraph(" "));
	       my_pdf_report.add(new Paragraph(" "));
	        PdfPTable my_report_table = new PdfPTable(6);
	        
	        PdfPCell table_cell;
	        String eid="EMP ID";
			table_cell=new PdfPCell(new Phrase(eid,boldFont));
            my_report_table.addCell(table_cell);
            String ename="EMP NAME";
			table_cell=new PdfPCell(new Phrase(ename,boldFont));
            my_report_table.addCell(table_cell);
            String tday="TOTAL DAYS";
			table_cell=new PdfPCell(new Phrase(tday,boldFont));
            my_report_table.addCell(table_cell);
            String wday="WORKING DAYS";
			table_cell=new PdfPCell(new Phrase(wday,boldFont));
            my_report_table.addCell(table_cell);
            String thrs="TOTAL HOURS";
			table_cell=new PdfPCell(new Phrase(thrs,boldFont));
            my_report_table.addCell(table_cell);
            String ahrs="AVG HOURS";
			table_cell=new PdfPCell(new Phrase(ahrs,boldFont));
            my_report_table.addCell(table_cell);
			while(rs2.next())
			{
				empid.add(rs2.getString("eid"));
				empname.add(rs2.getString("ename"));
			
			el.add(rs2.getString("ename"));
			}
List<EmployeePojo> edata=new ArrayList<EmployeePojo>();
			
			for(int i=0;i<el.size();i++)
			{
				EmployeePojo listattnd=new EmployeePojo();
			String email=(String)el.get(i);
			PreparedStatement ps1=con.prepareStatement("select totalhrs from empattendence where monyear=? and ename=?");
			ps1.setString(1, fdate);
			ps1.setString(2, email);
			int count=0;
			ResultSet rs1=ps1.executeQuery();
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
			if(avg<9)
			{			
			String id=empid.get(i);
			table_cell=new PdfPCell(new Phrase(id,boldFont1));
            my_report_table.addCell(table_cell);
			String name=empname.get(i);
			table_cell=new PdfPCell(new Phrase(name,boldFont1));
            my_report_table.addCell(table_cell);
            String totday=""+result;
            table_cell=new PdfPCell(new Phrase(totday,boldFont1));
            my_report_table.addCell(table_cell);
            String wkday=""+count;
            table_cell=new PdfPCell(new Phrase(wkday,boldFont1));
            my_report_table.addCell(table_cell);
			String thr=""+th1;
			table_cell=new PdfPCell(new Phrase(thr,boldFont1));
            my_report_table.addCell(table_cell);
		    String ahr=new DecimalFormat("##.##").format(avg);
		    table_cell=new PdfPCell(new Phrase(ahr,boldFont1));
            my_report_table.addCell(table_cell);
			}
			}
			 my_pdf_report.add(my_report_table); 
             my_pdf_report.close();
                 
			out.print("Successfully Converted Into PDF");
			RequestDispatcher disp=request.getRequestDispatcher("HomeServlet");
			disp.include(request, response);
         }catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
