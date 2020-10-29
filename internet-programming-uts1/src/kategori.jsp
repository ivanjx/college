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

            <div class="content content-kategori">
                <h1>Kategori Buku</h1>

                <a class="btn btn-primary add" href="createkategori.jsp">
                    Tambah
                </a>

                <table class="table table-striped">
                    <thead class="table table-dark">
                        <tr>
                            <td>Kategori</td>
                            <td class="action-col">Action</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        BookCategory[] cats = DI.bookCategoryRepository.list();
                        
                        for (int i = 0; i < cats.length; ++i)
                        {
                        %>

                        <tr>
                            <td><%= cats[i].name %></td>
                            <td class="action-col-data">
                                <button class="btn"><i class="fas fa-edit"></i></button>
                                <button class="btn"><i class="fas fa-trash-alt"></i></button>
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