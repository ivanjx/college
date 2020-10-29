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

            <div class="content content-create-kategori">
                <h1>Create Kategori</h1>
                <br/>

                <form action="kategori/create" method="POST">
                    <div class="form-group">
                        <input type="text" name="name" placeholder="Nama Kategori">
                        <input type="submit" value="Simpan" class="btn btn-primary">
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>