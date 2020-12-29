package com.jsp;

import java.util.Iterator;
import java.util.Vector;

public class ShoppingCartBean {
    private Vector<CartItem> cart;
    private int cartContent;

    public ShoppingCartBean() {
        cart = new Vector<CartItem>();
        cartContent = 0;
    }

    public Vector<CartItem> getCart() {
        return cart;
    }

    public int getCartContentNumber() {
        return cartContent;
    }

    private CartItem getItem(String productId) {
        Iterator<CartItem> it = cart.iterator();

        while (it.hasNext()) {
            CartItem item = it.next();
            
            if (productId.equals(item.getProduct().getId())) {
                return item;
            }
        }

        return null;
    }

    public void addToCart(String productId, int num) {
        CartItem item = getItem(productId);

        if (item == null) {
            CatalogBean catalog = new CatalogBean();
            Product p = catalog.getProduct(productId);
            item = new CartItem();
            item.setProduct(p);
            item.setQuantity(num);
            cart.add(item);
        } else {
            item.setQuantity(item.getQuantity() + 1);
        }
    }

    public void removeFromCart(String productId) {
        cart.remove(getItem(productId));
    }

    public int getTotal() {
        Iterator<CartItem> it = cart.iterator();
        int total = 0;

        while (it.hasNext()) {
            CartItem item = it.next();
            total += item.getSubtotal();
        }

        return total;
    }
}
