<html>
    <head>
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <td>
                    <form method="GET" action="index.jsp">
                        <select name="image" size="5">
                            <option value="putih.jpg" selected>Bunga Putih</option>
                            <option value="merah.jpg">Bunga Merah</option>
                            <option value="pink.jpg">Bunga Pink</option>
                            <option value="biru.jpg">Bunga Biru</option>
                            <option value="ungu.jpg">Bunga Ungu</option>
                        </select>
                        <br/>
                        <input type="submit" value="Submit">
                    </form>
                </td>

                <%
                String imgref = "images/";
                String param = request.getParameter("image");
                if (param == null) {
                    imgref += "putih.jpeg";
                } else {
                    imgref += param;
                }
                %>

                <td>
                    <img src="<%=imgref%>">
                    <p align="center"><%=imgref%></p>
                </td>
            </tr>
        </table>
    </body>
</html>