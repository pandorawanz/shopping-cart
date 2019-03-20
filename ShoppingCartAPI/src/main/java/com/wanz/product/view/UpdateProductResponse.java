package com.wanz.product.view;

import com.wanz.product.model.Product;

public class UpdateProductResponse {
    private Product product;

    public UpdateProductResponse() {}

    public UpdateProductResponse(Product product) {
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }
}
