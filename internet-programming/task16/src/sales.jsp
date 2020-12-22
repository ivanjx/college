<%@ include file="header.jspf"%>

<jsp:useBean id="userData" scope="session" class="com.infobean.UserData"/>
<jsp:setProperty name="userData" property="*"/>

<html>
<head>
    <title>JSP Page</title>
</head>
<body>
    <h2>Selamat Datang, <%=userData.getNamaUser()%></h2>
    ID ANDA = <jsp:getProperty name="userData" property="idUser" /><br/>
    USIA ANDA = <jsp:getProperty name="userData" property="umur" /><br/>
    <a href="index.jsp">LOGIN</a>
</body>
</html>