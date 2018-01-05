package org.prasad.TimeSheet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

public class PDFConvertServlet extends HttpServlet {
	
	public static final String PREFACE = "D://pdftimesheet.pdf";
    public static final String RESULT = "D://timesheet.txt";
    List<String> times=new ArrayList<String>();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null;
		fdate=request.getParameter("fdate");
		if(fdate==null || fdate.equals(""))
		{
			
		    fdate=new SimpleDateFormat("yyyy-MM").format(Calendar.getInstance().getTime());

		}
		System.out.println(fdate);
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
			
			Document my_pdf_report = new Document();
			
            PdfWriter.getInstance(my_pdf_report, new FileOutputStream("K://Reports/pdftimesheet.pdf"));
            my_pdf_report.open(); 
            
            Font title1 = new Font(Font.FontFamily.TIMES_ROMAN, Font.BOLD,Font.UNDERLINE);
            Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font boldFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.NORMAL);
            
           my_pdf_report.add(new Paragraph("                                               TIMESHEET"));
           my_pdf_report.add(new Paragraph(" "));
           
           my_pdf_report.add(new Paragraph("USERNAME :"));
           my_pdf_report.add(new Paragraph(user));
           my_pdf_report.rightMargin();
           
           my_pdf_report.add(new Paragraph(" "));
           my_pdf_report.add(new Paragraph(" "));
            PdfPTable my_report_table = new PdfPTable(4);
            
            PdfPCell table_cell;
            
            String dat="DATE";
			table_cell=new PdfPCell(new Phrase(dat,boldFont));
            my_report_table.addCell(table_cell);
            String cin="CLOCK-IN";
			table_cell=new PdfPCell(new Phrase(cin,boldFont));
            my_report_table.addCell(table_cell);
            String tout="CLOCK-OUT";
			table_cell=new PdfPCell(new Phrase(tout,boldFont));
            my_report_table.addCell(table_cell);
            String tt="TOTAL";
			table_cell=new PdfPCell(new Phrase(tt,boldFont));
            my_report_table.addCell(table_cell);
            
			while(rs1.next())
			{
				Timestamp date=rs1.getTimestamp("clockin");
				String dt=date.getDate()+":"+date.getMonth()+":"+date.getYear();
				table_cell=new PdfPCell(new Phrase(dt,boldFont1));
                my_report_table.addCell(table_cell);
				String timein=date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
				table_cell=new PdfPCell(new Phrase(timein,boldFont1));
                my_report_table.addCell(table_cell);
                
				Timestamp cout=rs1.getTimestamp("clockout");
				if(cout!=null)
				{
				String timeout=cout.getHours()+":"+cout.getMinutes()+":"+cout.getSeconds();
				table_cell=new PdfPCell(new Phrase(timeout,boldFont1));
                my_report_table.addCell(table_cell);
					
				int hr=Math.abs(cout.getHours()-date.getHours());
				int min=Math.abs(cout.getMinutes()-date.getMinutes());
				int sec=Math.abs(cout.getSeconds()-date.getSeconds());
				
				String tot1=""+hr;
				String tot2=""+min;
				String tot3=""+sec;
				String total=tot1+":"+tot2+":"+tot3;
				table_cell=new PdfPCell(new Phrase(total,boldFont1));
                my_report_table.addCell(table_cell);
				}
				else
				{
					String timeout=" ";
					table_cell=new PdfPCell(new Phrase(timeout,boldFont1));
	                my_report_table.addCell(table_cell);
					String total=" ";
					table_cell=new PdfPCell(new Phrase(total,boldFont1));
	                my_report_table.addCell(table_cell);
				}
			}
			 my_pdf_report.add(my_report_table); 
             my_pdf_report.close();
                 rs1.close();
                 ps1.close();
                 con.close();
                 PdfReader reader = new PdfReader(PREFACE);
                 PdfReaderContentParser parser = new PdfReaderContentParser(reader);
                 PrintWriter outp = new PrintWriter(new FileOutputStream(RESULT));
                 TextExtractionStrategy strategy;
                 
                 for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                     strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
                    String pdft=strategy.getResultantText();
                    request.setAttribute("timesheet", pdft);
                 }
                 reader.close();
                 out.print("SUCCESSFULLY CONVERTED");
                 RequestDispatcher disp=request.getRequestDispatcher("HomeServlet");
                             
                // RequestDispatcher disp=request.getRequestDispatcher("PDFout.jsp");
                 disp.forward(request, response);
         }catch (Exception e2)
           {
               e2.printStackTrace();
           }

         finally{out.close();
         }
	}
}

