package com.wanz.cart.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemDao extends CrudRepository<CartItem, Integer> {

    // 根据ORM的命名惯例，声明操作方法
    CartItem getById(int id);

    List<CartItem> findAll();

    CartItem save(CartItem product);

    void delete(CartItem product);
}
