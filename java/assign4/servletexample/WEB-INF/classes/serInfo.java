import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class serInfo extends HttpServlet implements Servlet
{
	protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		pw.println("<html><body><h2> Information about http request:</h2>");
		pw.println("<br>Server name:"+req.getServerName());
		pw.println("<br>Server port:"+req.getServerPort());
		pw.println("<br>IP Address:"+req.getRemoteAddr());
		pw.println("Welcome to java world");
		pw.println("</html></body>");
		pw.close();
	}
}
