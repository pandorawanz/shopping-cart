package com.wanz.product.view;

public class CreateProductRequest {
    private String name;
    private String description;
    private double price;

    public CreateProductRequest(String name, String desctiption, double price) {
        this.name = name;
        this.description = desctiption;
        this.price = price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

}
