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

            <div class="content content-update-pembeli">
                <h1>Update Pembeli</h1>
                <br/>

                <%
                int id = Integer.parseInt(request.getParameter("id"));
                Customer cust = DI.customerRepository.get(id);
                %>

                <form action="pembeli/update" method="POST">
                    <input type="hidden" name="id" value="<%= cust.id %>">

                    <div class="form-group">
                        <label for="txtName">Nama</label>
                        <input id="txtName" type="text" name="name" placeholder="Nama Pembeli" value="<%= cust.name %>" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtPhone">No. Telepon</label>
                        <input id="txtPhone" type="text" name="phone" placeholder="No. Telepon Pembeli" value="<%= cust.phone %>" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtAddress">Alamat</label>
                        <textarea id="txtAddress" name="address" placeholder="Alamat Pembeli" class="form-control"><%= cust.address %></textarea>
                    </div>
                    
                    <input type="submit" value="Simpan" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>