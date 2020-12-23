<%@ page import="com.infobean.Guest"%>
<jsp:useBean id="gb" scope="page" class="com.infobean.GuestBookBean"/>

<%
int id = Integer.parseInt(request.getParameter("id"));
Guest g = gb.get(id);
%>

<html>
<head>
    <title>Guest Book</title>
</head>
<body>
    <h1>Edit Guest Book</h1>

    <form action="ProsesEdit.jsp" method="POST">
        <input type="hidden" name="id" value="<%=g.getId()%>">

        <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="<%=g.getName()%>"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address" value="<%=g.getAddress()%>"></td>
        </tr>
        <tr>
            <td>Company:</td>
            <td><input type="text" name="company" value="<%=g.getCompany()%>"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email" value="<%=g.getEmail()%>"></td>
        </tr>
        </table>

        <input type="submit" value="Submit">
    </form>

    <h2><a href="GuestBookView.jsp">View Guest Book</a></h2>
    <br/>
    <br/>
    <small>(C) 2020 Ivan & Rio</small>
</body>
</html>