<jsp:useBean id="gb" scope="page" class="com.infobean.GuestBookBean"/>

<%
String message = "";
int id = Integer.parseInt(request.getParameter("id"));
String name = request.getParameter("name");
String address = request.getParameter("address");
String company = request.getParameter("company");
String email = request.getParameter("email");
boolean r = gb.edit(id, name, address, company, email);

if(r) {
    message = "Edit successful";
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