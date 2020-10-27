<html>
    <%@include file='header.jsp'%>

    <body>
        <div id="sidebar">
            <%@include file='sidebar-menu.jsp'%>

            <div class="content content-pembeli">
                <h1>Pembeli</h1>

                <button class="btn btn-primary add">
                    Add
                </button>

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
                        <tr>
                            <td>John Doe</td>
                            <td>021-1231231</td>
                            <td>
                                Jalan Kenanga 1<br/>
                                Jakarta
                            </td>
                            <td class="action-col-data">
                                <button class="btn"><i class="fas fa-edit"></i></button>
                                <button class="btn"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td>John Doe</td>
                            <td>021-1231231</td>
                            <td>
                                Jalan Kenanga 1<br/>
                                Jakarta
                            </td>
                            <td class="action-col-data">
                                <button class="btn"><i class="fas fa-edit"></i></button>
                                <button class="btn"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td>John Doe</td>
                            <td>021-1231231</td>
                            <td>
                                Jalan Kenanga 1<br/>
                                Jakarta
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