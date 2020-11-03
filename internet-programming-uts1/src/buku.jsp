<%@page import="logic.models.*"%>
<%@page import="logic.repositories.*"%>
<%@page import="logic.services.*"%>
<%@page import="logic.controllers.*"%>
<%@page import="logic.*"%>

<html>
    <%@include file='header.jsp'%>

    <body>
        <div id="sidebar">
            <%@include file='sidebar-menu.jsp'%>

            <div class="content content-buku">
                <h1>Buku</h1>

                <a class="btn btn-primary add" href="createbuku.jsp">
                    Tambah
                </a>

                <table class="table table-striped">
                    <thead class="table table-dark">
                        <tr>
                            <td>Judul</td>
                            <td>Kategori</td>
                            <td>Penulis</td>
                            <td>Harga</td>
                            <td class="sampul-col">Sampul</td>
                            <td class="action-col">Action</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        Book[] books = DI.bookRepository.list();

                        for (int i = 0; i < books.length; ++i)
                        {
                        %>

                        <tr>
                            <td><%= books[i].title %></td>
                            <td><%= DI.bookCategoryRepository.get(books[i].catId).name %></td>
                            <td><%= books[i].writer %></td>
                            <td><%= Helper.formatPrice(books[i].price) %></td>
                            <td class="sampul-col-data">
                                <img src="<%= books[i].imgPath %>">
                            </td>
                            <td class="action-col-data">
                                <a 
                                    class="btn"
                                    href="updatebuku.jsp?id=<%= books[i].id %>">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a 
                                    class="btn"
                                    onclick="return confirm('Yakin ingin menghapus buku <%= books[i].title %> ?')"
                                    href="buku/delete?id=<%= books[i].id %>">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td>
                        </tr>

                        <%
                        }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>