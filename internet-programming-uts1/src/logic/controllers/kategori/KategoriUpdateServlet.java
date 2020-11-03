package logic.controllers.kategori;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import logic.DI;
import logic.models.BookCategory;

@WebServlet("/kategori/update")
public class KategoriUpdateServlet extends HttpServlet
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

            if (name == null ||
                name.isEmpty())
            {
                throw new Exception("name is empty");
            }

            // Updating.
            BookCategory cat = new BookCategory();
            cat.id = id;
            cat.name = name;
            DI.bookCategoryService.update(cat);

            // Done.
            response.sendRedirect(request.getContextPath() + "/kategori.jsp");
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }
    }
}
