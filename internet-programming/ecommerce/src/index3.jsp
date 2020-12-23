<%@ page import="com.infobean.*, java.util.*"%>
<jsp:useBean id="catalogBean" scope="page" class="com.infobean.CatalogBean"/>

<%
Vector<Category> vCategory = catalogBean.getAllCatalog();
%>

<html>
<head>
    <%@ include file="title.jspf"%>
</head>
<body>
    <%@ include file="header.jspf"%>

    <table border="1">
        <tr>
            <td align="center"><b>Daftar Kategori</b></td>
            <td align="center"><b>Deskripsi</b></td>
        </tr>
    <%
    Iterator<Category> it = vCategory.iterator();

    while (it.hasNext()) {
        Category c = it.next();
    %>
        <tr>
            <td><a href="catalog.jsp?action=view&id=<%=c.getId()%>"><%=c.getName()%></a></td>
            <td><%=c.getDescription()%></td>
        </tr>
    <%
    }
    %>
    </table>

    <%@ include file="footer.jspf"%>
</body>
</html>