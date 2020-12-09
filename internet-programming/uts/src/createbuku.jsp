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

            <div class="content content-create-buku">
                <h1>Create Buku</h1>
                <br/>

                <form action="buku/create" method="POST">
                    <div class="form-group">
                        <label for="txtTitle">Judul</label>
                        <input id="txtTitle" type="text" name="title" placeholder="Judul Buku" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtKategori">Kategori</label>
                        <select id="txtKategori" name="catId" placeholder="Kategori Buku" class="form-control">
                            <%
                            BookCategory[] cats = DI.bookCategoryRepository.list();

                            for (int i = 0; i < cats.length; ++i)
                            {
                            %>
                            <option value="<%= cats[i].id %>"><%= cats[i].name %></option>
                            <%
                            }
                            %>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="txtWriter">Penulis</label>
                        <input id="txtWriter" type="text" name="writer" placeholder="Nama Penulis Buku" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtPrice">Harga</label>
                        <input id="txtPrice" type="text" name="price" placeholder="Harga Buku" class="form-control">
                    </div>

                    <div class="form-group">
                        <label for="txtImgPath">Link Sampul</label>
                        <input id="txtImgPath" type="text" name="imgPath" placeholder="Link Gambar Sampul Buku" class="form-control">
                    </div>

                    <input type="submit" value="Simpan" class="btn btn-primary">
                </form>
            </div>
        </div>
    </body>
</html>