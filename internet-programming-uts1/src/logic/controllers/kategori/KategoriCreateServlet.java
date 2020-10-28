package logic.controllers.kategori;

import logic.DI;
import logic.models.BookCategory;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/kategori/create")
public class KategoriCreateServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        // Validating.
        String name = request.getParameter("name");

        if (name == null ||
            name.isEmpty())
        {
            response.sendError(400, "name is empty");
        }

        // Creating.
        BookCategory cat = new BookCategory();
        cat.name = name;
        
        try
        {
            DI.bookCategoryService.create(cat);
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }

        // Done.
        response.sendRedirect("kategori.jsp");
	}
}

