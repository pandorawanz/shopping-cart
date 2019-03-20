package com.wanz.product.view;

import com.wanz.product.model.Product;

public class CreateProductResponse {
    private Product product;

    public CreateProductResponse() {
    }

    public CreateProductResponse(Product product) {
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
