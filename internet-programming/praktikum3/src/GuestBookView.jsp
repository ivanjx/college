<%@ page import="java.util.*, com.infobean.Guest"%>
<jsp:useBean id="gb" scope="page" class="com.infobean.GuestBookBean"/>

<%
Vector<Guest> vGuest = gb.viewGuestBook();
%>

<html>
<head>
<title>Guest Book</title>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet" />
<style>
td {
    padding: 5px;
    vertical-align: middle !important;
}

.fa-edit {
    color: blue;
}

.fa-trash-alt {
    color: red;
}
</style>
</head>
<body>
    <h1>Guest List</h1>
    <table border="1">
        <thead>
            <td><b>Name</b></td>
            <td><b>Address</b></td>
            <td><b>Company</b></td>
            <td><b>Email</b></td>
            <td colspan="2" style="text-align: center;"><b>Action</b></td>
        </thead>
    <%
    Iterator value = vGuest.iterator();

    while (value.hasNext()) {    
        Guest g = (Guest)value.next();
    %>
        <tr>
            <td><%=g.getName()%></td>
            <td><%=g.getAddress()%></td>
            <td><%=g.getCompany()%></td>
            <td><%=g.getEmail()%></td>
            <td><a href="GuestBookEdit.jsp?id=<%=g.getId()%>"><span class="fas fa-edit"></span></a></td>
            <td><a href="Delete.jsp?id=<%=g.getId()%>"><span class="fas fa-trash-alt"></span></a></td>
        </tr>
    <%
    }
    %>
    </table>

    <br/>
    <a href="index.jsp">REGISTER</a>
</body>
</html>