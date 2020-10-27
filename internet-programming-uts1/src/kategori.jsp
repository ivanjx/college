<html>
    <%@include file='header.jsp'%>
    
    <body>
        <div id="sidebar">
            <%@include file='sidebar-menu.jsp'%>

            <div class="content content-kategori">
                <h1>Buku</h1>

                <button class="btn btn-primary add">
                    Add
                </button>

                <table class="table table-striped">
                    <thead class="table table-dark">
                        <tr>
                            <td>Kategori</td>
                            <td class="action-col">Action</td>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>Sains</td>
                            <td class="action-col-data">
                                <button class="btn"><i class="fas fa-edit"></i></button>
                                <button class="btn"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td>Fiksi</td>
                            <td class="action-col-data">
                                <button class="btn"><i class="fas fa-edit"></i></button>
                                <button class="btn"><i class="fas fa-trash-alt"></i></button>
                            </td>
                        </tr>
                        <tr>
                            <td>Religi</td>
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