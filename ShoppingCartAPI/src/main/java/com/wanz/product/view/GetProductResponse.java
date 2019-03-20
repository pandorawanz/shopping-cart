package com.wanz.product.view;

import com.wanz.product.model.Product;

public class GetProductResponse {
    private Product product;

    public GetProductResponse() {
    }

    public GetProductResponse(Product product) {
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
