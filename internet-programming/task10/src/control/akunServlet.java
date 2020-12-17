package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Akun;

@WebServlet(name = "akunServlet", urlPatterns = {"/akunServlet"})
public class akunServlet extends HttpServlet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
    {
        Akun akun = new Akun();
        String url = "jdbc:mysql://localhost:3306/sia";
        String username = "sia";
        String password = "sia";

        Connection koneksi = null;
        PreparedStatement pstmt = null;

        int result = 0;

        try (PrintWriter out = response.getWriter())
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(url, username, password);
            
            String aksi = request.getParameter("aksi");

            if(aksi != null)
            {
                akun.setKodeAkun(request.getParameter("kode"));
                akun.setNamaAkun(request.getParameter("nama"));
                akun.setJenisAkun(request.getParameter("jenis"));
                akun.setSaldoNormal(request.getParameter("saldo"));

                switch (aksi)
                {
                    case "Insert":
                        pstmt = koneksi.prepareStatement("insert into master_akun VALUES(?,?,?,?)");
                        pstmt.setString(1, akun.getKodeAkun());
                        pstmt.setString(2, akun.getNamaAkun());
                        pstmt.setString(3, akun.getJenisAkun());
                        pstmt.setString(4, akun.getSaldoNormal());
                        result = pstmt.executeUpdate();

                        if (result > 0)
                        {
                            out.println(
                                "<script>" +
                                "alert('Data akun telah ditambahkan');" +
                                "document.location='add_akun.jsp';" +
                                "</script>"
                            );
                        }
                        else
                        {
                            out.println("ERROR");
                        }

                        break;

                    default:
                        break;
                }
            }
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(akunServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
