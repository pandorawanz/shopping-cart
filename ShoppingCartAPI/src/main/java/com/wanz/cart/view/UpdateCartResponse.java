package com.wanz.cart.view;

import com.wanz.cart.model.CartItem;

public class UpdateCartResponse {
    private CartItem cartItem;

    public UpdateCartResponse() {}

    public UpdateCartResponse(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public void setCartItem(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public CartItem getCartItem() {
        return cartItem;
    }

}
