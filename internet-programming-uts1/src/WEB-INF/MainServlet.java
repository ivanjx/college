import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MainServlet extends HttpServlet
{
	// GET /main
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws 
	ServletException,
	IOException {
		// Content type.
		response.setContentType("application/json");

		// Body.
		PrintWriter out = response.getWriter();
		out.println("{\"message\": \"Hello world\"}");

		// Done.
		out.close();
	}
}