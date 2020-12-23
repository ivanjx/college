<jsp:useBean id="gb" scope="page" class="com.infobean.GuestBookBean"/>

<%
String message = "";
int id = Integer.parseInt(request.getParameter("id"));
boolean r = gb.delete(id);

if(r) {
    message = "Delete successful";
} else {
    message = "Error";
}
%>

<html>
<head>
    <title>Guest Book</title>
</head>
<body>
    <h2>
        <%=message%>
        <br/>
        <a href="index.jsp">REGISTER</a>
        <br/>
        <a href="GuestBookView.jsp">VIEW GUEST BOOK</a>
    </h2>
</body>
</html>