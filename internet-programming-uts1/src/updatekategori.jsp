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

            <div class="content content-update-kategori">
                <h1>Update Kategori</h1>
                <br/>

                <%
                int id = Integer.parseInt(request.getParameter("id"));
                BookCategory cat = DI.bookCategoryRepository.get(id);
                %>

                <form action="kategori/update" method="POST">
                    <div class="form-group">
                        <input type="hidden" name="id" value="<%= cat.id %>">
                        <input type="text" name="name" placeholder="Nama Kategori" value="<%= cat.name %>">
                        <input type="submit" value="Simpan" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>