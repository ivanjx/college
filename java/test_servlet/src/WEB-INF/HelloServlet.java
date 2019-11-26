import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet
{
	// GET /api/test
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws 
	ServletException,
	IOException {
		// Content type.
		response.setContentType("text/html");

		// Body.
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>Test Servlet</h1>");
		out.println("</body></html>");

		// Done.
		out.close();
	}
}