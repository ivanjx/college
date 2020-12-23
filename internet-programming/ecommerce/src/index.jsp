<%@ page import="com.infobean.*, java.util.*"%>
<jsp:useBean id="catalogBean" scope="page" class="com.infobean.CatalogBean"/>

<%
Vector<Category> vCategory = catalogBean.getAllCatalog();
Vector<Product> vCatalog = new Vector<Product>();

String action = request.getParameter("action");

if (action != null) {
    if (action.equals("search")) {
        String keyword = request.getParameter("keyword");
        vCatalog = catalogBean.getProductsCatalogSearch(keyword);
    } else if (action.equals("view")) {
        String id = request.getParameter("id");
        vCatalog = catalogBean.getProductsCatalog(id);
    }
} else {
    vCatalog = catalogBean.getPromotionProducts();
}
%>

<html>
<head>
    <%@ include file="title.jspf"%>
</head>
<body>
    <%@ include file="header.jspf"%>

    <div style="display: flex; justify-content: flex-start;">
        <div style="display: flex; flex-direction: column; justify-content: stretch;">
            <div style="text-align: center; background: green;"><b>Kategori</b></div>
            
            <%
            Iterator<Category> cc = vCategory.iterator();

            while (cc.hasNext()) {
                Category c = cc.next();
            %>
                <div style="display: block; background: gray;">
                    <a href="index.jsp?action=view&id=<%=c.getId()%>" title="<%=c.getDescription()%>"><%=c.getName()%></a>
                </div>
            <%
            }
            %>
        </div>

        <div>
            <%
            Iterator<Product> pp = vCatalog.iterator();

            while (pp.hasNext()) {
                Product p = pp.next();
            %>
                <div style="display: flex;">
                    <img src="<%=p.getImage()%>" style="max-width: 200px; margin-right: 20px;">
                    <div style="display: flex; flex-direction: column; justify-content: center;">
                        <b><%=p.getName()%></b>

                        <br/>
                        <table>
                        <tr>
                            <td>SKU:</td>
                            <td><%=p.getSKU()%></td>
                        </tr>
                        <tr>
                            <td>Brand:</td>
                            <td><%=p.getBrand()%></td>
                        </tr>
                        <tr>
                            <td>Category:</td>
                            <td><%=p.getCategory().getName()%></td>
                        </tr>
                        <tr>
                            <td style="vertical-align: top;">Description:</td>
                            <td><%=p.getDescription()%></td>
                        </tr>
                        <tr>
                            <td>Price:</td>
                            <td><%=p.getPrice()%> IDR</td>
                        </tr>
                        </table>
                        <br/>

                        <form method="POST" action="shopcart.jsp" style="margin: 0;">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="<%=p.getId()%>">
                            Quantity: <input type="number" style="width: 3rem;" name="qty" value="1"> <input type="submit" value="Add to cart">
                        </form>
                    </div>
                </div>

                <br/>
            <%
            }
            %>
        </div>
    </div>

    <%@ include file="footer.jspf"%>
</body>
</html>