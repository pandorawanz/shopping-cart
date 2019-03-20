package com.wanz.order.view;

import com.wanz.order.model.Order;

public class CreateOrderResponse {
    private Order order;

    public CreateOrderResponse() {}

    public CreateOrderResponse(Order order) {
        this.order = order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
