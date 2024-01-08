package com.thomasjay.teamviewercodechallenge.service;

import com.thomasjay.teamviewerchallange.model.Product;
import com.thomasjay.teamviewercodechallenge.mapper.ProductDTOMapper;
import com.thomasjay.teamviewercodechallenge.db.model.ProductDB;
import com.thomasjay.teamviewercodechallenge.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductDTOMapper productDTOMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductDTOMapper productDTOMapper) {
        this.productRepository = productRepository;
        this.productDTOMapper = productDTOMapper;
    }


    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();

        List<ProductDB> productDBList = productRepository.findAll();

        return productDBList.stream().map(product -> productDTOMapper.convertProductDB2Product(product)).collect(Collectors.toList());

    }

    @Override
    public Product addProduct(Product product) {
        ProductDB productDB = productDTOMapper.convertProduct2ProductDB(product);

        productRepository.save(productDB);

        return productDTOMapper.convertProductDB2Product(productDB);
    }

    @Override
    public Product findProductById(String id) throws Exception {

        ProductDB productDB = productRepository.findById(id).orElse(null);

        if (productDB != null) {
            return productDTOMapper.convertProductDB2Product(productDB);
        }
        else {
            throw new Exception("Not Found");
        }

    }

    @Override
    public void deleteProduct(String id) throws Exception {

        try {
            productRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new Exception("Not deleted");
        }
    }

    @Override
    public Product updateProduct(Product product) throws Exception {

        try {
            ProductDB productDB = productDTOMapper.convertProduct2ProductDB(product);

            productRepository.save(productDB);

            return productDTOMapper.convertProductDB2Product(productDB);

        }
        catch (Exception e) {
            throw new Exception("Not deleted");
        }

    }


}
