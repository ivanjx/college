package logic.controllers;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet 
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    // GET /hello
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws 
	ServletException,
	IOException {
		// Content type.
		response.setContentType("application/json");

		// Body.
		PrintWriter out = response.getWriter();
		out.println("{\"message\": \"Hello servlet!\"}");

		// Done.
		out.close();
	}
}

