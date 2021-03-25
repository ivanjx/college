<%@ page import="java.util.*, com.infobean.Guest"%>
<jsp:useBean id="gb" scope="page" class="com.infobean.GuestBookBean"/>

<%
Vector<Guest> vGuest = gb.viewGuestBook();
%>

<html>
<head>
<title>Guest Book</title>
</head>
<body>
    <h1>Guest List</h1>
    <%
    Iterator value = vGuest.iterator();

    while (value.hasNext()) {    
        Guest g = (Guest)value.next();
    %>
        <table>
        <tr>
            <td>Name:</td>
            <td><%=g.getName()%></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><%=g.getAddress()%></td>
        </tr>
        <tr>
            <td>Company:</td>
            <td><%=g.getCompany()%></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><%=g.getEmail()%></td>
        </tr>
        </table>
        <br/>
    <%
    }
    %>
</body>
</html>