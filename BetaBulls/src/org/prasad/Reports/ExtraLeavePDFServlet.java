package org.prasad.Reports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Servlet implementation class ExtraLeavePDFServlet
 */
public class ExtraLeavePDFServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null;
			
		fdate=request.getParameter("fdate");
		if(fdate==null || fdate.equals(""))
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, -1);
			fdate=format.format(cal.getTime());
		}			
				
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			PreparedStatement ps1=con.prepareStatement("select empid,empname,leavesfrom,leavesto from uninformleave where year=? order by empid");
			ps1.setString(1, fdate);
			
			
			ResultSet rs2=ps1.executeQuery();
			
Document my_pdf_report = new Document();
			
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("K://Reports/ExtraLeavesPDF.pdf"));
            my_pdf_report.open(); 
            
            Font title1 = new Font(Font.FontFamily.TIMES_ROMAN, Font.BOLD,Font.UNDERLINE);
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);
            
           my_pdf_report.add(new Paragraph("                                               REPORT ON LEAVES"));
           my_pdf_report.add(new Paragraph(" "));
           my_pdf_report.add(new Paragraph("Month & Year : "));
           my_pdf_report.add(new Paragraph(fdate));
           my_pdf_report.add(new Paragraph(" "));
           my_pdf_report.add(new Paragraph(" "));
            PdfPTable my_report_table = new PdfPTable(4);
            
            PdfPCell table_cell;
            
            String dat="EMPLOYEE ID";
			table_cell=new PdfPCell(new Phrase(dat,boldFont));
            my_report_table.addCell(table_cell);
            String cin="EMPLOYEE NAME";
			table_cell=new PdfPCell(new Phrase(cin,boldFont));
            my_report_table.addCell(table_cell);
            String tout="LEAVES FROM";
			table_cell=new PdfPCell(new Phrase(tout,boldFont));
            my_report_table.addCell(table_cell);
            String tt="LEAVES TO";
			table_cell=new PdfPCell(new Phrase(tt,boldFont));
            my_report_table.addCell(table_cell);
			
			while(rs2.next())
			{
				
				String eid=rs2.getString("empid");
				table_cell=new PdfPCell(new Phrase(eid,boldFont1));
                my_report_table.addCell(table_cell);
				String ename=rs2.getString("empname");
				table_cell=new PdfPCell(new Phrase(ename,boldFont1));
                my_report_table.addCell(table_cell);
				String from=rs2.getString("leavesfrom");
				table_cell=new PdfPCell(new Phrase(from,boldFont1));
                my_report_table.addCell(table_cell);
				String to=rs2.getString("leavesto");
				table_cell=new PdfPCell(new Phrase(to,boldFont1));
                my_report_table.addCell(table_cell);
		    
			}	
			my_pdf_report.add(my_report_table); 
            my_pdf_report.close();
			
			out.print("SUCCESSFULLY CONVERTED");					
			RequestDispatcher dispatcher = request.getRequestDispatcher("HomeServlet");  
			dispatcher.include(request, response);
			
		}catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
