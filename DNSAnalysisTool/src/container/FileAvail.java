package container;
import java.io.DataInputStream; 
import java.io.File; 
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletContext; 
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



 public class FileAvail extends javax.servlet.http.HttpServlet implements
            javax.servlet.Servlet {
        static final long serialVersionUID = 1L;
        private static final int BUFSIZE = 4096;
        private static String filePath;
        HttpSession s;

public void init() {
    // the file data.xls is under web application folder
}

protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
 
	try{
		s=request.getSession(false);
	    filePath = "/home/hadoop/git/LocalDNSAnalysisTool/DNSAnalysisTool/WebContent/"+(String) s.getAttribute("file_path");// + "data.xls";
	    	System.out.println(filePath);
	}catch(NullPointerException e){
		System.out.print("I was here ");
		e.printStackTrace();
	}

	System.out.println("1111"+filePath);
	File file = new File(filePath);
    int length   = 0;
    ServletOutputStream outStream = response.getOutputStream();
    ServletContext context  = getServletConfig().getServletContext();
    String mimetype = context.getMimeType(filePath);

    // sets response content type
    if (mimetype == null) {
        mimetype = "application/octet-stream";
    }
    response.setContentType(mimetype);
    response.setContentLength((int)file.length());
    String fileName = (new File(filePath)).getName();

    // sets HTTP header
    response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

    byte[] byteBuffer = new byte[BUFSIZE];
    DataInputStream in = new DataInputStream(new FileInputStream(file));

    // reads the file's bytes and writes them to the response stream
    while ((in != null) && ((length = in.read(byteBuffer)) != -1))
    {
        outStream.write(byteBuffer,0,length);
    }

    in.close();
    outStream.close();
}
}