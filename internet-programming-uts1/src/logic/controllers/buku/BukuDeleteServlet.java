package logic.controllers.buku;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DI;

public class BukuDeleteServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            
            // Deleting.
            DI.bookService.delete(id);

            // Done.
            response.sendRedirect("buku.jsp");
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }
    }
}
