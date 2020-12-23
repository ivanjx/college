<%@ page import="com.infobean.*, java.util.*"%>
<jsp:useBean id="catalogBean" scope="page" class="com.infobean.CatalogBean"/>

<%
Vector<Product> vCatalog = catalogBean.getPromotionProducts();
%>

<html>
<head>
    <%@ include file="title.jspf"%>
</head>
<body>
    <%@ include file="header.jspf"%>

    <%
    Iterator<Product> it = vCatalog.iterator();

    while (it.hasNext()) {
        Product p = it.next();
    %>
        <div style="display: flex;">
            <img src="<%=p.getImage()%>" style="max-width: 200px; max-height: 200px; margin-right: 20px;">
            <div style="display: flex; flex-direction: column; justify-content: center;">
                <b><%=p.getName()%></b>
                <br/>
                <br/>
                Brand: <%=p.getBrand()%>
                <br/>
                Category: <%=p.getCategory().getName()%>
                <br/>
                Price: <%=p.getPrice()%> IDR
                <br/>
                <br/>

                <form method="POST" action="shopcart.jsp" style="margin: 0;">
                    <input type="hidden" name="action" value="add">
                    <input type="hidden" name="id" value="<%=p.getId()%>">
                    Quantity: <input type="number" style="width: 3rem;" name="qty" value="1"> <input type="submit" value="Add to cart">
                </form>
            </div>
        </div>
    <%
    }
    %>

    <%@ include file="footer.jspf"%>
</body>
</html>