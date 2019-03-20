package com.wanz.cart.view;

import com.wanz.cart.model.CartItem;

public class GetCartResponse {
    private CartItem cartItem;

    public GetCartResponse() {}

    public GetCartResponse(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public CartItem getCartItem() {
        return cartItem;
    }
}
