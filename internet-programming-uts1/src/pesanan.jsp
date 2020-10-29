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

            <div class="content content-pesanan">
                <h1>Pesanan</h1>

                <button class="btn btn-primary add">
                    Add
                </button>

                <%
                int skip = 0;
                String skipStr = request.getParameter("skip");

                if (skipStr != null && !skipStr.isEmpty())
                {
                    skip = Integer.parseInt(skipStr);
                }

                Order[] orders = DI.orderRepository.list(skip);
                %>

                <table class="table table-striped">
                    <thead class="table table-dark">
                        <tr>
                            <td>Tanggal</td>
                            <td>Buku</td>
                            <td>Pembeli</td>
                            <td>No Telepon</td>
                            <td>Alamat</td>
                            <td class="center-col">Jumlah</td>
                            <td class="center-col">Total</td>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                        for (int i = 0; i < orders.length; ++i)
                        {
                            Book book = DI.bookRepository.get(orders[i].bookId);
                            Customer cust = DI.customerRepository.get(orders[i].custId);
                            Double totalPrice = book.price * orders[i].amount;
                        %>

                        <tr>
                            <td><%= Helper.formatDate(orders[i].date) %></td>
                            <td><%= book.title %></td>
                            <td><%= cust.name %></td>
                            <td><%= cust.phone %></td>
                            <td><%= cust.address %></td>
                            <td class="center-col"><%= orders[i].amount %></td>
                            <td class="center-col"><%= Helper.formatPrice(totalPrice) %></td>
                        </tr>

                        <%
                        }
                        %>
                    </tbody>
                </table>

                <%
                if (orders.length >= 10)
                {
                %>
                <a href="pesanan.jsp?skip=<%= (skip + orders.length) %>">Next</a>
                <%
                }
                %>
            </div>
        </div>
    </body>
</html>