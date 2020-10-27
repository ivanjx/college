<html>
    <%@include file='header.jsp'%>

    <body>
        <div id="sidebar">
            <%@include file='sidebar-menu.jsp'%>

            <div class="content content-buku">
                <h1>Buku</h1>

                <button class="btn btn-primary add">
                    Add
                </button>

                <table class="table table-striped">
                    <thead class="table table-dark">
                        <tr>
                            <td>Judul</td>
                            <td>Kategori</td>
                            <td>Penulis</td>
                            <td>Harga</td>
                            <td class="sampul-col">Sampul</td>
                            <td class="action-col">Action</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Siklus Air</td>
                            <td>Sains</td>
                            <td>John Doe</td>
                            <td>Rp. 10.000,00</td>
                            <td class="sampul-col-data">
                                <img src="https://i.pinimg.com/originals/f7/8c/b6/f78cb6367d8c78f9241475b957457914.jpg">
                            </td>
                            <td class="action-col-data">
                                <button class="btn"><i class="fas fa-edit"></i></button>
                                <button class="btn"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td>Siklus Air</td>
                            <td>Sains</td>
                            <td>John Doe</td>
                            <td>Rp. 10.000,00</td>
                            <td class="sampul-col-data">
                                <img src="https://images.unsplash.com/photo-1503803548695-c2a7b4a5b875?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max">
                            </td>
                            <td class="action-col-data">
                                <button class="btn"><i class="fas fa-edit"></i></button>
                                <button class="btn"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td>Siklus Air</td>
                            <td>Sains</td>
                            <td>John Doe</td>
                            <td>Rp. 10.000,00</td>
                            <td class="sampul-col-data">
                                <img src="https://p.bigstockphoto.com/GeFvQkBbSLaMdpKXF1Zv_bigstock-Aerial-View-Of-Blue-Lakes-And--227291596.jpg">
                            </td>
                            <td class="action-col-data">
                                <button class="btn"><i class="fas fa-edit"></i></button>
                                <button class="btn"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>