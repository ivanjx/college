<html>
<head>
    <title>JSP Page</title>
</head>
<body>
    <jsp:useBean id="ngb" scope="session" class="com.infobean.NumberGuessBean"/>
    <jsp:setProperty name="ngb" property="*"/>

    <h1><u>Tebak-Tebakan Angka</u></h1>
    <h3>
        <%
        if (ngb.getNumGuesses() == 0) {
        %>

        Silahkan tebak sebuah bilangan antara 1 s/d 10.

        <form method="GET" action="index.jsp">
            Tebakan Anda = <input type="text" name="guess"><input type="submit" value="Tebak">
        </form>

        <%
        } else {
        %>

            <%
            if (ngb.isMatch()) {
            %>
                Tebakan = <jsp:getProperty name="ngb" property="guess"/><br/>
                <i><jsp:getProperty name="ngb" property="hint"/></i><br/>
                Anda telah mencoba sebanyak <jsp:getProperty name="ngb" property="numGuesses"/> kali<br/>
                <br/>
                Silahkan <a href="index.jsp">COBA LAGI</a>
            <%
                ngb.reset();
            } else {
            %>
                Tebakan = <jsp:getProperty name="ngb" property="guess"/><br/>
                <i><jsp:getProperty name="ngb" property="hint"/></i><br/>
                Anda telah mencoba sebanyak <jsp:getProperty name="ngb" property="numGuesses"/> kali<br/>
                Silahkan tebak lagi bilangan antara 1 s/d 10.<br/>
                <form method="GET" action="index.jsp">
                    Tebakan Anda = <input type="text" name="guess"><input type="submit" value="Tebak">
                </form>
            <%
            }
            %>
        <%
        }
        %>
    </h3>

    <small>(C) 2020 Ivan & Rio</small>
</body>
</html>