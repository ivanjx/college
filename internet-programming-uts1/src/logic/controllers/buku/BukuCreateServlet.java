package logic.controllers.buku;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import logic.DI;
import logic.models.Book;

@WebServlet("buku/create")
public class BukuCreateServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException
    {
        try
        {
            // Validating.
            int catId = Integer.parseInt(request.getParameter("catId"));
            String title = request.getParameter("title");
            String writer = request.getParameter("writer");
            Double price = Double.parseDouble(request.getParameter("price"));
            String imgPath = request.getParameter("imgPath");

            if (title == null || title.isEmpty())
            {
                throw new Exception("title is empty");
            }

            if (writer == null || writer.isEmpty())
            {
                throw new Exception("writer is empty");
            }

            if (price < 0)
            {
                throw new Exception("invalid price");
            }

            // Creating.
            Book book = new Book();
            book.catId = catId;
            book.title = title;
            book.writer = writer;
            book.price = price;
            book.imgPath = imgPath;
            DI.bookService.create(book);

            // Done.
            response.sendRedirect("buku.jsp");
        }
        catch (Exception ex)
        {
            response.sendError(400, ex.getMessage());
        }
    }
}
