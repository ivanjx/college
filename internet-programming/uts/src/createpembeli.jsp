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

            <div class="content content-create-pembeli">
                <h1>Create Pembeli</h1>
                <br/>

                <form action="pembeli/create" method="POST">
                    <div class="form-group">
                        <label for="txtName">Nama</label>
                        <input id="txtName" type="text" name="name" placeholder="Nama Pembeli" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtPhone">No. Telepon</label>
                        <input id="txtPhone" type="text" name="phone" placeholder="No. Telepon Pembeli" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtAddress">Alamat</label>
                        <textarea id="txtAddress" name="address" placeholder="Alamat Pembeli" class="form-control"></textarea>
                    </div>
                    
                    <input type="submit" value="Simpan" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>