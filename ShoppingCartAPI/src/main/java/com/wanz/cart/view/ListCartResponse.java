package com.wanz.cart.view;

import com.wanz.cart.model.CartItem;

import java.util.List;

public class ListCartResponse {
    private List<CartItem> listCartItem;

    public ListCartResponse() {}

    public ListCartResponse(List<CartItem> listCartItem) {
        this.listCartItem = listCartItem;
    }

    public List<CartItem> getListCartItem() {
        return listCartItem;
    }

    public void setListCartItem(List<CartItem> listCartItem) {
        this.listCartItem = listCartItem;
    }
}
