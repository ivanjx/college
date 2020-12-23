package com.infobean;

import java.util.Vector;

public class ShoppingCartBean {
    private Vector<CartItem> cart;
    private int cartContent;

    public Vector<CartItem> getCart() {
        return cart;
    }

    public int getCartContentNumber() {
        return cartContent;
    }

    public void addToCart(String productId, int num) {
        
    }
}
