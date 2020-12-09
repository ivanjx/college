package logic.controllers.pesanan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DI;

@WebServlet("/pesanan/delete")
public class PesananDeleteServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        try
        {
            int id = Integer.parseInt(request.getParameter("id"));
            
            // Deleting.
            DI.orderRepository.delete(id);
            
            // Done.
            response.sendRedirect(request.getContextPath() + "/pesanan.jsp");
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }
    }
}
