package org.prasad.Reports;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class FileLocationContextListner implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		  String rootPath = System.getProperty("catalina.home");
		  ServletContext ctx = servletContextEvent.getServletContext();
		  String relativePath = ctx.getInitParameter("tempfile.dir");
		  File file = new File(rootPath + File.separator + relativePath);
		  if(!file.exists()) file.mkdirs();
		  System.out.println("File Directory created to be used for storing files");
		  ctx.setAttribute("FILES_DIR_FILE", file);
		  ctx.setAttribute("FILES_DIR", rootPath + File.separator + relativePath);


	}

}
