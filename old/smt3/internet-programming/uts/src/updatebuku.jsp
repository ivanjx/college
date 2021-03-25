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

            <div class="content content-update-buku">
                <h1>Update Buku</h1>
                <br/>

                <form action="buku/update" method="POST">
                    <%
                    int id = Integer.parseInt(request.getParameter("id"));
                    Book book = DI.bookRepository.get(id);
                    %>

                    <input type="hidden" name="id" value="<%= book.id %>">

                    <div class="form-group">
                        <label for="txtTitle">Judul</label>
                        <input id="txtTitle" type="text" name="title" placeholder="Judul Buku" value="<%= book.title %>" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtKategori">Kategori</label>
                        <select id="txtKategori" name="catId" placeholder="Kategori Buku" class="form-control">
                            <%
                            BookCategory[] cats = DI.bookCategoryRepository.list();

                            for (int i = 0; i < cats.length; ++i)
                            {
                            %>
                            <option value="<%= cats[i].id %>" <%= cats[i].id == book.catId ? "selected" : ""%>><%= cats[i].name %></option>
                            <%
                            }
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="txtWriter">Penulis</label>
                        <input id="txtWriter" type="text" name="writer" placeholder="Nama Penulis Buku" value="<%= book.writer %>" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtPrice">Harga</label>
                        <input id="txtPrice" type="text" name="price" placeholder="Harga Buku" value="<%= book.price %>" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtImgPath">Link Sampul</label>
                        <input id="txtImgPath" type="text" name="imgPath" placeholder="Link Gambar Sampul Buku" value="<%= book.imgPath %>" class="form-control">
                    </div>

                    <input type="submit" value="Simpan" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>