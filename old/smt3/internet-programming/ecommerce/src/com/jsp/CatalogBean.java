package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class CatalogBean {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String sURL = "jdbc:mysql://localhost:3306/dbecommerce";
    private String user = "ecommerce";
    private String password = "ecommerce";
    private Connection conn;

    public void connect() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(sURL, user, password);
        } catch (Exception ex) {}
    }

    public void disconnect() {
        try {
            conn.close();
        } catch (Exception ex) {}
    }

    public Vector<Category> getAllCatalog() {
        Vector<Category> vc = new Vector<Category>();
        
        try {
            connect();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from categories");

            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getString(1));
                c.setName(rs.getString(2));
                c.setDescription(rs.getString(3));
                vc.add(c);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return vc;
    }

    public String getCatalogCategoryName(String categoryId) {
        String name = "";

        try {
            connect();
            PreparedStatement ps = conn.prepareStatement("select category_name from categories where category_id = ?");
            ps.setString(1, categoryId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return name;
    }

    private Product getProductAndCategory(ResultSet rs) {
        Product p = new Product();
        
        try {
            p.setId(rs.getString(1));
            p.setSKU(rs.getString(2));
            p.setName(rs.getString(3));
            p.setBrand(rs.getString(4));
            p.setDescription(rs.getString(5));
            p.setPrice(rs.getInt(6));
            p.setImage(rs.getString(8));

            Category c = new Category();
            c.setId(rs.getString(9));
            c.setName(rs.getString(10));
            c.setDescription(rs.getString(11));
            p.setCategory(c);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return p;
    }

    public Vector<Product> getProductsCatalog(String categoryId) {
        Vector<Product> vp = new Vector<Product>();

        try {
            connect();

            PreparedStatement ps = conn.prepareStatement(
                "select * from products " +
                "inner join categories on products.category_id = categories.category_id " +
                "where products.category_id = ?");
            ps.setString(1, categoryId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vp.add(getProductAndCategory(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return vp;
    }

    public Vector<Product> getProductsCatalogSearch(String q) {
        Vector<Product> vp = new Vector<Product>();

        try {
            connect();

            PreparedStatement ps = conn.prepareStatement(
                "select * from products " +
                "inner join categories on products.category_id = categories.category_id " +
                "where products.sku = ? OR products.name like ? OR products.brand like ? OR categories.category_name like ?");
            ps.setString(1, q);
            q = "%" + q + "%";
            ps.setString(2, q);
            ps.setString(3, q);
            ps.setString(4, q);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                vp.add(getProductAndCategory(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return vp;
    }

    public Vector<Product> getPromotionProducts() {
        Vector<Product> vp = new Vector<Product>();

        try {
            connect();

            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(
                "select * from products " +
                "inner join categories on products.category_id = categories.category_id " +
                "where products.product_id in (select product_id from promotion)");

            while (rs.next()) {
                vp.add(getProductAndCategory(rs));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return vp;
    }

    public Product getProduct(String id) {
        try {
            connect();

            PreparedStatement ps = conn.prepareStatement(
                "select * from products " +
                "inner join categories on products.category_id = categories.category_id " +
                "where products.product_id = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return getProductAndCategory(rs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            disconnect();
        }

        return null;
    }
}
