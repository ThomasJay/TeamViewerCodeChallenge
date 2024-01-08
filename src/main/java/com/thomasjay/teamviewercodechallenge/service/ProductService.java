package com.thomasjay.teamviewercodechallenge.service;

import com.thomasjay.teamviewerchallange.model.Product;

import java.util.List;

public interface ProductService {

    public List<Product> findAllProduct();

    public Product findProductById(String id) throws Exception;

    public Product addProduct(Product product);

    public void deleteProduct(String id) throws Exception;

    public Product updateProduct(Product product) throws Exception;

}
