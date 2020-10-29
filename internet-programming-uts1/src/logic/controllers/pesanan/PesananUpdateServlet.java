package logic.controllers.pesanan;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DI;
import logic.models.Order;

@WebServlet("/pesanan/update")
public class PesananUpdateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        try
        {
            // Validating.
            int id = Integer.parseInt(request.getParameter("id"));
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            int custId = Integer.parseInt(request.getParameter("custId"));
            int amount = Integer.parseInt(request.getParameter("amount"));
            
            if (amount < 1)
            {
                throw new Exception("invalid amount");
            }

            // Updating.
            Order data = new Order();
            data.id = id;
            data.bookId = bookId;
            data.custId = custId;
            data.amount = amount;
            DI.orderService.update(data);

            // Done.
            response.sendRedirect(request.getContextPath() + "/pesanan.jsp");
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }
    }
}
