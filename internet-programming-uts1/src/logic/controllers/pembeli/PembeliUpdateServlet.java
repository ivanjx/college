package logic.controllers.pembeli;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DI;
import logic.models.Customer;

@WebServlet("/pembeli/update")
public class PembeliUpdateServlet extends HttpServlet
{
    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        try
        {
            // Validating.
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");

            if (name == null || name.isEmpty())
            {
                throw new Exception("name is empty");
            }

            // Updating.
            Customer data = new Customer();
            data.id = id;
            data.name = name;
            data.address = address;
            data.phone = phone;
            DI.customerService.update(data);

            // Done.
            response.sendRedirect("pembeli.jsp");
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }
    }
}
