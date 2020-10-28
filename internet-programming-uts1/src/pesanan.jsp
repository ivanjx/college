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
                        <tr>
                            <td>Jan 20, 2020 19:30:00</td>
                            <td>Siklus Air</td>
                            <td>Ivan</td>
                            <td>021-1231231</td>
                            <td>
                                Jalan Kenanga 1<br/>
                                Jakarta
                            </td>
                            <td class="center-col">2</td>
                            <td class="center-col">Rp. 20.000,00</td>
                        </tr>
                        <tr>
                            <td>Jan 20, 2020 19:30:00</td>
                            <td>Siklus Air</td>
                            <td>Ivan</td>
                            <td>021-1231231</td>
                            <td>
                                Jalan Kenanga 1<br/>
                                Jakarta
                            </td>
                            <td class="center-col">2</td>
                            <td class="center-col">Rp. 20.000,00</td>
                        </tr>
                        <tr>
                            <td>Jan 20, 2020 19:30:00</td>
                            <td>Siklus Air</td>
                            <td>Ivan</td>
                            <td>021-1231231</td>
                            <td>
                                Jalan Kenanga 1<br/>
                                Jakarta
                            </td>
                            <td class="center-col">2</td>
                            <td class="center-col">Rp. 20.000,00</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>