package org.pwr.register.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.pwr.register.controllers.admin.AdminPanelFileController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/commonPanel")
public class FileController {

	@RequestMapping(value = "/download/", method = RequestMethod.GET)
	public void getFileDownload(HttpServletResponse response) {
	    //String path = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/register/WEB-INF/resources/temat_inz.zip";
	    String path = getNewestFile().getAbsolutePath();
	    String name = getNewestFile().getName();
	    try {
	        // get your file as InputStream
	        InputStream is = new FileInputStream(path);
	        
	        // copy it to response's OutputStream
	        IOUtils.copy(is, response.getOutputStream());
	        response.setContentType("application/zip");
	        response.setHeader("Content-Disposition", "attachment; filename=" + name);
	        response.flushBuffer();
	      } catch (IOException ex) {
	        throw new RuntimeException("IOError writing file to output stream");
	      }
	    
	}
	
	@RequestMapping(value = "update/" , method = RequestMethod.GET)
	public @ResponseBody String checkUpdate()
	{
		return getNewestFile().getName();
	}

	private File getNewestFile() {
		String path = FileController.getResourcesPath();
		final File folder = new File(path);
	    File newestFile = folder.listFiles()[0];
	    for (File f : folder.listFiles())
	    {
	    	if (f.lastModified() > newestFile.lastModified())
	    	{
	    		newestFile = f;
	    	}
	    }
	    System.out.println(newestFile.getAbsolutePath());
	    return newestFile;
	}
	
	public static String getResourcesPath() {
		String path = AdminPanelFileController.class.getProtectionDomain()
				.getCodeSource().getLocation().getPath();
		String split[] = path.split("/");
		path = "";
		for (String s : split) {
			s = s.replace("%20", " ");
			path += s + "/";
			
			if (s.equals("WEB-INF"))
				break;
		}
		path += "resources";
		return path;
	}
}
