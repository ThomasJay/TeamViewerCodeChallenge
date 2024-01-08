package com.thomasjay.teamviewercodechallenge.controller;

import com.thomasjay.teamviewerchallange.api.ProductsApi;
import com.thomasjay.teamviewerchallange.model.Product;
import com.thomasjay.teamviewercodechallenge.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController implements ProductsApi {


    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @Override
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {

        try {
            Product newProduct = productService.addProduct(product);

            return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Void> deleteProduct(String productId) {

        try {
            productService.deleteProduct(productId);

            return ResponseEntity.ok(null);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<List<Product>> findAllProducts() {

        try {
            List<Product> allProducts = productService.findAllProduct();

            return ResponseEntity.ok(allProducts);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Product> getProductById(String productId) {

        try {

            Product product = productService.findProductById(productId);

            return ResponseEntity.ok(product);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<Product> updateProduct(String productId, @Valid @RequestBody Product product) {

        try {

            if (!productId.equals(product.getId())) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Product updatedProduct = productService.updateProduct(product);

            return ResponseEntity.ok(updatedProduct);

        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
