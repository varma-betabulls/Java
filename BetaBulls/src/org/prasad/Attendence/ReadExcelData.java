package org.prasad.Attendence;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcelData extends HttpServlet {
	static int status=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String fdate=null;
		
		fdate=request.getParameter("fdate");	
		String efile=request.getParameter("efile");
//URL url=getClass().getResource("times.xls");
//File file=new File(url.getPath());
		if(fdate==null || fdate.equals(" "))
		{
		    fdate=new SimpleDateFormat("yyyy-mm").format(Calendar.getInstance().getTime());
		}
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","viru","prasad");
			
				PreparedStatement ps=con.prepareStatement("insert into empattendence(ename,cdate,timein,timeout,totalhrs,remarks,monyear)  values(?,?,?,?,?,?,?)");            
	          //File file=new File(efile);
	          
			//String abs=file.getAbsolutePath();
			FileInputStream fileInputStream = new FileInputStream("K://Prasad/BetaBulls/BetaBulls/times.xls");
			//FileInputStream fileInputStream = new FileInputStream(efile);
			//System.out.println(abs);
			//InputStream fileInputStream = getClass().getResourceAsStream(efile);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet("Sheet1");
			int length = worksheet.getLastRowNum();
			for(int i=0;i<=length;i++)
			{
				
				HSSFRow row1 = worksheet.getRow(i);
				
				HSSFCell cellA1 = row1.getCell((short) 0);
				String a1Val = cellA1.getStringCellValue();
				ps.setString(1, a1Val);			
				
				HSSFCell cellD1 = row1.getCell((short) 1);
				Date d1Val = cellD1.getDateCellValue();
				String ddt=""+d1Val;
				ps.setString(2, ddt);
				
				HSSFCell cellA2 = row1.getCell((short) 2);
				Date date = cellA2.getDateCellValue();
				String intime = ReadExcelData.getTime(date);
				ps.setString(3, intime);
				
				HSSFCell cellA3 = row1.getCell((short) 3);
				Date date1 = cellA3.getDateCellValue();
				String outtime = ReadExcelData.getTime(date1);
				ps.setString(4, outtime);
				
				HSSFCell cellA4 = row1.getCell((short) 4);
				Date hours = cellA4.getDateCellValue();
				String workingHours = ReadExcelData.getTime(hours);
				ps.setString(5, workingHours);
				
				HSSFCell cellA5 = row1.getCell((short) 5);
				int remark = (int) cellA5.getNumericCellValue();
				ps.setInt(6, remark);
				
				ps.setString(7,fdate);
				status=ps.executeUpdate();
			
			}
					
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		 catch (Exception e) {
				
				e.printStackTrace();
			}
		 if(status>0){
			 out.print("<html>");
				out.print("<body>");
				
				out.print("<font color='blue'><font size='4'>");
				out.print("ATTENDENCE INSERTED SUCCESSFULLY</font></font>");
				out.print("</body>");
				out.print("</html>");
				
			RequestDispatcher rd=request.getRequestDispatcher("AddAttendence.jsp");
			rd.include(request, response);
		}
		else{
			out.print("<html>");
			out.print("<body>");
			out.print("<h5>");
			out.print("<font color='blue'><font size='4'>");
			out.print("Sorry,Attendence can't be Added!, Retry</h5></font></font>");
			out.print("</body>");
			out.print("</html>");
			
			RequestDispatcher rd=request.getRequestDispatcher("AddAttendence.jsp");
			rd.include(request, response);
		}

		out.close();	
		
	}
	
	public static String getTime(Date date)
	{
		String time = "";
		SimpleDateFormat formatTime = new SimpleDateFormat("HH:mm:ss");
        SimpleDateFormat formatYearOnly = new SimpleDateFormat("yyyy");
        String dateStamp = formatYearOnly.format(date);
        if (dateStamp.equals("1899")){
            //Return "Time-only" value as String HH:mm:ss
            return formatTime.format(date);
        }
		return time;
	}
	
	
}