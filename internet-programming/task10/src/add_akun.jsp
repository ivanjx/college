<html>
    <head>
        <title>Data Akun</title>
    </head>
    <body>
        <h1>Tambah Akun</h1>
        <form action="akunServlet" method="POST">
            <table border="0" cellpadding="4">
                <tbody>
                    <tr>
                        <td>Jenis Akun</td>
                        <td>
                            <select name="jenis">
                                <option value="Kas/Bank" selected>Kas/Bank</option>
                                <option value="Aktiva Lancar">Aktiva Lancar</option>
                                <option value="Aktiva Tetap">Aktiva Tetap</option>
                                <option value="Kewajiban">Kewajiban</option>
                                <option value="Modal">Modal</option>
                                <option value="Pendapatan">Pendapatan</option>
                                <option value="Beban">Beban</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Kode *</td>
                        <td>
                            <input type="text" name="kode" size="5">
                        </td>
                    </tr>
                    <tr>
                        <td>Nama Akun</td>
                        <td>
                            <input type="text" name="nama" size="20">
                        </td>
                    </tr>
                    <tr>
                        <td>Saldo Normal</td>
                        <td>
                            <select name="saldo">
                                <option value="Debet">Debet</option>
                                <option value="Kredit">Kredit</option>
                            </select>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="submit" name="aksi" value="Insert">
                            <input type="reset" name="reset" value="Batal">
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>