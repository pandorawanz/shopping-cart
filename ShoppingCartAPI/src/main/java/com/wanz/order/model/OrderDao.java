package com.wanz.order.model;

import com.wanz.order.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {

    Order getById(int id);

    List<Order> findAll();

    Order save(Order order);

    void delete(Order order);
}
