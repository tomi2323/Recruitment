package services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import managers.ManagerHelper;


	@WebServlet(name = "FileUploadServlet", urlPatterns = {"/upload"})
	@MultipartConfig
	public class FileUploadServlet extends HttpServlet {

	    private final static Logger LOGGER = 
	            Logger.getLogger(FileUploadServlet.class.getCanonicalName());
	
	    public void doPost(HttpServletRequest request, HttpServletResponse response)
	    		throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");

	 
	    final String path = "C:/Users/user/web/recruitment/WebContent/applicantcv";
	    final Part filePart = request.getPart("file");
	    final String fileName = getFileName(filePart);
	    String value = request.getParameter("asi");
	    String value3 = request.getParameter("yearofexperience");
	    String value4 = request.getParameter("email");
	    String value5 = request.getParameter("phone");
	    String value6 = request.getParameter("firstname");
	    String value7 = request.getParameter("lastname");
	    String value8 = request.getParameter("archaiv");
	    String value9 = request.getParameter("locked");
	    String value10 = request.getParameter("status");
	    String value11 = request.getParameter("NA");
	    int value2= Integer.parseInt(value);
	    System.out.println(value2);
	    System.out.println(value3);
	    System.out.println(value4);
	    System.out.println(value5);
	    System.out.println(value6);
	    System.out.println(value7);
	    System.out.println(value8);
	    System.out.println(value9);
	    System.out.println(value10);
	    System.out.println(value11);
	    
	    System.out.println(value);
	    ManagerHelper.getapplicantsManager().getacv(fileName, value2,value6,value7,value4,value5,value3,value8,value9,value10,value11);
	    
	   

	    OutputStream out = null;
	    InputStream filecontent = null;
	    final PrintWriter writer = response.getWriter();
	    File a = new File(path + File.separator+ fileName);
	    try {
	        out = new FileOutputStream(new File(path + File.separator
	                + fileName));
	        filecontent = filePart.getInputStream();

	        int read = 0;
	        final byte[] bytes = new byte[1024];

	        while ((read = filecontent.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        writer.println("New file " + fileName + " created at " + path);
	        LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", 
	                new Object[]{fileName, path});
	    } catch (FileNotFoundException fne) {
	        writer.println("You either did not specify a file to upload or are "
	                + "trying to upload a file to a protected or nonexistent "
	                + "location.");
	        writer.println("<br/> ERROR: " + fne.getMessage());

	        LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
	                new Object[]{fne.getMessage()});
	    } finally {
	        if (out != null) {
	            out.close();
	        }
	        if (filecontent != null) {
	            filecontent.close();
	        }
	        if (writer != null) {
	            writer.close();
	        }
	    }
	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}
}
