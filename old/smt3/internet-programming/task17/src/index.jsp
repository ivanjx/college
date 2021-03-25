<%@ include file="header.jspf"%>
<%@ page errorPage="error.jsp"%>
<html>
<head>
    <title>JSP Page</title>
</head>
<body>
    <%
        String lang = request.getParameter("language");
        if (lang.equalsIgnoreCase("java")) {
    %>
    <h3>Pilihan Anda benar! (<%=lang%>) </h3>
    <%
        } else {
            throw new Exception("Pilihan anda salah!");
        }
    %>
</body>
</html>