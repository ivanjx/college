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

            <div class="content content-update-pesanan">
                <h1>Update Order</h1>
                <br/>

                <%
                int id = Integer.parseInt(request.getParameter("id"));
                Order order = DI.orderRepository.get(id);
                %>

                <form action="pesanan/update" method="POST">
                    <input type="hidden" name="id" value="<%= order.id %>">

                    <div class="form-group">
                        <label for="buku">Buku</label>
                        <select id="buku" name="bookId" placeholder="Buku" class="form-control">
                            <%
                            Book[] books = DI.bookRepository.list();

                            for (int i = 0; i < books.length; ++i)
                            {
                            %>
                            <option value="<%= books[i].id %>" <%= books[i].id == order.bookId ? "selected" : ""%>><%= books[i].title %></option>
                            <%
                            }
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="pembeli">Pembeli</label>
                        <select id="pembeli" name="custId" placeholder="Pembeli" class="form-control">
                            <%
                            Customer[] custs = DI.customerRepository.list();

                            for (int i = 0; i < custs.length; ++i)
                            {
                            %>
                            <option value="<%= custs[i].id %>" <%= custs[i].id == order.custId ? "selected" : ""%>><%= custs[i].name %></option>
                            <%
                            }
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="amount">Jumlah</label>
                        <input id="amount" type="text" name="amount" placeholder="Jumlah Buku" value="<%= order.amount%>" class="form-control">
                    </div>

                    <input type="submit" value="Simpan" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>