package com.wanz.product.view;

import com.wanz.product.model.Product;

import java.util.List;

public class ListProductResponse {
    private List<Product> productList;

    public ListProductResponse() {}

    public ListProductResponse(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getListProduct() {
        return productList;
    }

    public void setListProduct(List<Product> productList) {
        this.productList = productList;
    }
}
