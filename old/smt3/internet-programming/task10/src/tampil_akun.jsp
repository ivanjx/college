<%@page import="java.sql.*"%>

<%
Connection koneksi = null;
Statement stmt = null;
ResultSet rs = null;


    Class.forName("com.mysql.cj.jdbc.Driver");
    koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/sia?serverTimezone=GMT", "sia", "sia");
    stmt = koneksi.createStatement();
    rs = stmt.executeQuery("select * from master_akun order by kode_akun");

%>

<html>
    <head>
        <title>
            Daftar Akun
        </title>
        <style>
            table {
                border-collapse: collapse;
                width: 680px;
            }

            th,td {
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #f2f2f2
            }

            th {
                background-color: #4caf50;
                color: white;
            }
        </style>
    </head>
    <body>
        <h1>Daftar Rekening Akun</h1>
        <table border="1">
            <tr>
                <th>Kode *</th>
                <th>Nama Akun</th>
                <th>Jenis Akun</th>
                <th>Saldo Normal</th>
                <th colspan="2">Aksi</th>
            </tr>
            <%
            
            while(rs.next()) {
                out.println(
                    "<tr>" +
                    "<td>" + rs.getString("kode_akun") + "</td>" +
                    "<td>" + rs.getString("nama_akun") + "</td>" +
                    "<td>" + rs.getString("jenis_akun") + "</td>" +
                    "<td>" + rs.getString("saldo_normal") + "</td>" +
                    "<td><a href=edit_akun.jsp?kode=" + rs.getString("kode_akun") + ">Edit</a></td>" +
                    "<td><a href=akunServlet?aksi=delete&kode=" + rs.getString("kode_akun") + ">Hapus</a></td>" +
                    "</tr>"
                );
            }

            %>
        </table>
    </body>
        
</html>