<html>
<head>
    <title>Guest Book</title>
</head>
<body>
    <h1>Guest Book</h1>

    <form action="GuestBook.jsp" method="POST">
        <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><input type="text" name="address"></td>
        </tr>
        <tr>
            <td>Company:</td>
            <td><input type="text" name="company"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" name="email"></td>
        </tr>
        </table>

        <input type="submit" value="Submit">
    </form>

    <h2><a href="GuestBookView.jsp">View Guest Book</a></h2>
</body>
</html>