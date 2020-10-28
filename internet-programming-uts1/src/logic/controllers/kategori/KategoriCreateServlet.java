package logic.controllers.kategori;

import logic.DI;
import logic.models.BookCategory;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("kategori/create")
public class KategoriCreateServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        try
        {
            // Validating.
            String name = request.getParameter("name");

            if (name == null ||
                name.isEmpty())
            {
                throw new Exception("name is empty");
            }

            // Creating.
            BookCategory cat = new BookCategory();
            cat.name = name;
            DI.bookCategoryService.create(cat);

            // Done.
            response.sendRedirect("kategori.jsp");
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }
	}
}

