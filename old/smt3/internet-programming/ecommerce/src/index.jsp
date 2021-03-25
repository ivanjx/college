<%@ page import="com.jsp.*, java.util.*"%>
<jsp:useBean id="catalogBean" scope="page" class="com.jsp.CatalogBean"/>

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

    <div style="display: flex;">
        <div style="menu bg-light">            
            <a href="index.jsp" title="Semua kategori" class="list-group-item list-group-item-action bg-light">Semua</a>

            <%
            Iterator<Category> cc = vCategory.iterator();

            while (cc.hasNext()) {
                Category c = cc.next();
            %>
                <a href="index.jsp?action=view&id=<%=c.getId()%>" title="<%=c.getDescription()%>" class="list-group-item list-group-item-action bg-light"><%=c.getName()%></a>
            <%
            }
            %>
        </div>

        <div class="d-flex flex-wrap align-items-start" style="margin-left: 10px; margin-top: -10px;">
            <%
            Iterator<Product> pp = vCatalog.iterator();

            while (pp.hasNext()) {
                Product p = pp.next();
            %>
                <div class="card shadow" style="width: 18rem; margin: 10px;">
                    <img class="card-img-top" src="<%=p.getImage()%>" alt="<%=p.getName()%>">
                    <div class="card-body">
                        <h5 class="card-title"><%=p.getName()%></h5>
                        <p class="card-text">
                            <i><%=p.getCategory().getName()%></i>
                            -
                            <i><%=p.getBrand()%></i>
                        </p>
                        <p class="card-text" style="margin-top: "><%=p.getDescription()%></p>
                        <p class="card-text" style="font-weight: 550"><i><%=p.getPrice()%> IDR</i></p>
                        
                        <form method="POST" action="shopcart.jsp" style="margin: 0;">
                            <input type="hidden" name="action" value="add">
                            <input type="hidden" name="id" value="<%=p.getId()%>">

                            <div class="input-group">
                                <input type="number" name="qty" value="1" class="form-control">
                                <button class="btn btn-outline-success" type="submit">
                                    <i class="fas fa-cart-plus"></i>
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            <%
            }
            %>
        </div>
    </div>

    <%@ include file="footer.jspf"%>
</body>
</html>