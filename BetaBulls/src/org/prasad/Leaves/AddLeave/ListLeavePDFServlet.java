package org.prasad.Leaves.AddLeave;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
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
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

/**
 * Servlet implementation class ListLeavePDFServlet
 */
public class ListLeavePDFServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null;
		fdate=request.getParameter("fdate");
		if(fdate==null || fdate.equals(""))
		{
			
		    fdate=new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime());

		}
		System.out.println(fdate);
		HttpSession session=request.getSession();
		String user=(String)session.getAttribute("name");
	

try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
			Statement stmt=con.createStatement();
			ResultSet rs2=stmt.executeQuery("select eid,ename from regemp order by eid");
			List<String> empid = new ArrayList<String>();
			List<String> empname = new ArrayList<String>();
			List<EmployeePojo> edata=new ArrayList<EmployeePojo>();
			List el=new ArrayList();
			
			Document my_pdf_report = new Document();
			
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("K://Reports/ListLeavePDF.pdf"));
            my_pdf_report.open(); 
            
            Font title1 = new Font(Font.FontFamily.TIMES_ROMAN, Font.BOLD,Font.UNDERLINE);
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);
            
           my_pdf_report.add(new Paragraph("                                               LIST OF LEAVES"));
           my_pdf_report.add(new Paragraph(" "));
           
           my_pdf_report.add(new Paragraph("LIST LEAVE YEAR :"));
           my_pdf_report.add(new Paragraph(fdate));
           my_pdf_report.rightMargin();
           
           my_pdf_report.add(new Paragraph(" "));
           my_pdf_report.add(new Paragraph(" "));
            PdfPTable my_report_table = new PdfPTable(6);
            
            PdfPCell table_cell;
            
            String id="EMP ID";
			table_cell=new PdfPCell(new Phrase(id,boldFont));
            my_report_table.addCell(table_cell);
            String nme="EMP NAME";
			table_cell=new PdfPCell(new Phrase(nme,boldFont));
            my_report_table.addCell(table_cell);
            String pl="PREV LEAVES";
			table_cell=new PdfPCell(new Phrase(pl,boldFont));
            my_report_table.addCell(table_cell);
            String sl="SICK LEAVES";
			table_cell=new PdfPCell(new Phrase(sl,boldFont));
            my_report_table.addCell(table_cell);
            String cl="CASUAL LEAVES";
			table_cell=new PdfPCell(new Phrase(cl,boldFont));
            my_report_table.addCell(table_cell);
            String tl="TOTAL LEAVES";
			table_cell=new PdfPCell(new Phrase(tl,boldFont));
            my_report_table.addCell(table_cell);
            
            while(rs2.next())
			{
				empid.add(rs2.getString("eid"));
				empname.add(rs2.getString("ename"));
			//below9hr.setEid(rs2.getString("eid"));
			//below9hr.setEname(rs2.getString("ename"));
			el.add(rs2.getString("ename"));
			//edata.add(below9hr);
						
			}
		
			for(int i=0;i<el.size();i++)
			{
			EmployeePojo listleave=new EmployeePojo();
			String email=(String)el.get(i);
			PreparedStatement ps1=con.prepareStatement("select previllegedleave,sickleave,casualleave,total from empleaves where year=? and ename=?");
			ps1.setString(1, fdate);
			ps1.setString(2, email);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
		
			String eeid=empid.get(i);
			table_cell=new PdfPCell(new Phrase(eeid,boldFont1));
            my_report_table.addCell(table_cell);
			String eename=empname.get(i);
			table_cell=new PdfPCell(new Phrase(eename,boldFont1));
            my_report_table.addCell(table_cell);
						
			String pls=rs1.getString("previllegedleave");
			table_cell=new PdfPCell(new Phrase(pls,boldFont1));
            my_report_table.addCell(table_cell);
			String sls=rs1.getString("sickleave");
			table_cell=new PdfPCell(new Phrase(sls,boldFont1));
            my_report_table.addCell(table_cell);
			String cls=rs1.getString("casualleave");
			table_cell=new PdfPCell(new Phrase(cls,boldFont1));
            my_report_table.addCell(table_cell);
			String tots=rs1.getString("total");
			table_cell=new PdfPCell(new Phrase(tots,boldFont1));
            my_report_table.addCell(table_cell);
		    	    
			}
			}	
			my_pdf_report.add(my_report_table); 
            my_pdf_report.close();
                
			out.print("SUCCESSFULLY CONVERTED");
			RequestDispatcher dispatcher = request.getRequestDispatcher("ListLeaveServlet");  
			dispatcher.forward(request, response);
			
		}catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}

}
