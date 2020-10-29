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

            <div class="content content-pembeli">
                <h1>Pembeli</h1>

                <a class="btn btn-primary add" href="createpembeli.jsp">
                    Tambah
                </a>

                <table class="table table-striped">
                    <thead class="table table-dark">
                        <tr>
                            <td>Nama</td>
                            <td>No Telepon</td>
                            <td>Alamat</td>
                            <td class="action-col">Action</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        Customer[] custs = DI.customerRepository.list();

                        for (int i = 0; i < custs.length; ++i)
                        {
                        %>

                        <tr>
                            <td><%= custs[i].name %></td>
                            <td><%= custs[i].phone %></td>
                            <td><%= custs[i].address %></td>
                            <td class="action-col-data">
                                <a 
                                    class="btn" 
                                    href="updatecustomer.jsp?id=<%= custs[i].id %>">
                                    <i class="fas fa-edit"></i>
                                </a>
                                <a 
                                    class="btn"
                                    onclick="return confirm('Yakin ingin menghapus <%= custs[i].name %> ?')"
                                    href="pembeli/delete?id=<%= custs[i].id %>">
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