package com.wanz.cart.controller;

import com.wanz.cart.view.*;
import com.wanz.cart.model.*;
import com.wanz.product.model.Product;
import com.wanz.product.model.ProductDao;
import com.wanz.user.model.User;
import com.wanz.user.model.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {
    private UserDao userDao;
    private ProductDao productDao;
    private CartItemDao cartItemDao;

    public CartItemController(UserDao userDao, ProductDao productDao, CartItemDao cartItemDao) {
        this.userDao = userDao;
        this.productDao = productDao;
        this.cartItemDao = cartItemDao;
    }

    @GetMapping("/cartItems/{cartItemId}")
    ResponseEntity<GetCartResponse> getCart(@PathVariable int cartItemId) {
        CartItem cartItem = cartItemDao.getById(cartItemId);

        if (cartItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GetCartResponse(cartItem), HttpStatus.OK);
        }
    }

    @GetMapping("/cartItems")
    ResponseEntity<ListCartResponse> listCart() {
        List<CartItem> cartItemList = cartItemDao.findAll();

        return new ResponseEntity<>(new ListCartResponse(cartItemList), HttpStatus.OK);

    }

    @PostMapping("/cartItems")
    ResponseEntity<CreateCartResponse> createCart(@RequestBody CreateCartRequest createCartRequest) {
        User user = userDao.getById(createCartRequest.getUser_id());
        Product product = productDao.getById(createCartRequest.getProduct_id());
        CartItem cartItem = cartItemDao.save(new CartItem(user, product, createCartRequest.getQuantity()));
        return new ResponseEntity<>(new CreateCartResponse(cartItem), HttpStatus.CREATED);
    }

    @PutMapping("/cartItems/{cartItemId}")
    ResponseEntity<UpdateCartResponse> updateCart(@PathVariable int cartItemId, @RequestBody UpdateCartRequest updateCartRequest) {
        CartItem cartItem = cartItemDao.getById(cartItemId);

        if (cartItem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cartItem.setQuantity(updateCartRequest.getQuantity());
        cartItemDao.save(cartItem);

        return new ResponseEntity<>(new UpdateCartResponse(cartItem), HttpStatus.OK);
    }

    @DeleteMapping("/cartItems/{cartItemId}")
    public ResponseEntity deleteCartItem(@PathVariable int cartItemId) {
        CartItem cartItem = cartItemDao.getById(cartItemId);

        if (cartItem == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        cartItemDao.delete(cartItem);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
