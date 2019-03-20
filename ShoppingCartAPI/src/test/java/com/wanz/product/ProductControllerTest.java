package com.wanz.product;



public class ProductControllerTest {

    /*
    // productController必须初始化，否则NullPointerException
    private ProductController productController = new ProductController(new CreateProductRequestValidator());
    */

    /*
    @Test
    public void shouldGetProductSuccessfully() {
        ResponseEntity<GetProductResponse> response = productController.getProduct(123);

        assertEquals(HttpStatus.OK,response.getStatusCode());
    }
    */

    /*
    @Test
    public void shouldCreateProductSuccessfully() {
        ResponseEntity<CreateProductResponse> response = productController.createProduct(new CreateProductRequest("123","default", "none", 13));

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }
    */

    /*
    @Test
    public void shouldUpdateProductSuccessfully() {
        ResponseEntity<UpdateProductResponse> response = productController.updateProduct("123", new UpdateProductRequest("default", "none", 13));

        assertEquals(HttpStatus.OK, response.getStatusCode());

        // ResponseEntity.getStatusCodeValue() 返回状态码
        System.out.println(response.getStatusCodeValue());
    }
    */

    /*
    @Test
    public void shouldListProductSuccessfully() {
        ResponseEntity<ListProductResponse> response = productController.listProduct();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCodeValue());
    }
    */

    /*
    @Test
    public void shouldDeleteProductSuccessfully() {
        ResponseEntity<Object> response = productController.deleteProduct("123");

    assertEquals(HttpStatus.OK, response.getStatusCode());
    }
    */
}
