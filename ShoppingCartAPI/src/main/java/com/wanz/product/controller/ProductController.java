package com.wanz.product.controller;

import com.wanz.product.model.Product;
import com.wanz.product.model.ProductDao;
import com.wanz.product.view.validator.CreateProductRequestValidator;
import com.wanz.product.view.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private ProductDao productDao;
    private CreateProductRequestValidator createProductRequestValidator;

    // productDao和createProductRequestValidator的依赖注入
    public ProductController(ProductDao productDao, CreateProductRequestValidator createProductRequestValidator) {
        this.createProductRequestValidator = createProductRequestValidator;
        this.productDao = productDao;
    }

    /*
     * Get product
     */
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable int productId) {
        Product product = productDao.getById(productId);

        if (product == null) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
        }
    }

    /*
     * Get product list
     */

    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProduct() {
        List<Product> productList = productDao.findAll();

        if (productList == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new ListProductResponse(productList), HttpStatus.OK);
        }
    }

    /*
     * Create product
     */

    @PostMapping("/products")
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        // 实现
        boolean validate = createProductRequestValidator.validate(createProductRequest);

        Product product = productDao.save(new Product(createProductRequest.getName(), createProductRequest.getDescription(), createProductRequest.getPrice()));
        return new ResponseEntity<>(new CreateProductResponse(product), HttpStatus.CREATED);
    }

    /*
     * Update product
     */

    @PutMapping("/products/{productId}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable int productId, @RequestBody UpdateProductRequest updateProductRequest) {
        Product product = productDao.getById(productId);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        product.setName(updateProductRequest.getName());
        product.setDescription(updateProductRequest.getDescription());
        product.setPrice(updateProductRequest.getPrice());
        productDao.save(product);

        return new ResponseEntity<>(new UpdateProductResponse(product), HttpStatus.OK);
    }

    /*
     * Delete product
     */

    /*
    @DeleteMapping("/products/{productID}")
    ResponseEntity<Object> deleteProduct(@PathVariable int productID) {
        productDao.delete(productID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    */

}
