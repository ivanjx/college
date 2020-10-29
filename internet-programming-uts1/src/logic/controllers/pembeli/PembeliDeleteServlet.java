package logic.controllers.pembeli;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DI;

@WebServlet("/pembeli/delete")
public class PembeliDeleteServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));

            // Deleting.
            DI.customerService.delete(id);

            // Done.
            response.sendRedirect(request.getContextPath() + "/pembeli.jsp");
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }
    }
}
