package com.thomasjay.teamviewercodechallenge.mapper;

import com.thomasjay.teamviewerchallange.model.Product;
import com.thomasjay.teamviewercodechallenge.db.model.ProductDB;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ProductDTOMapper {

    private ModelMapper modelMapper;

    ProductDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDB convertProduct2ProductDB(Product product) {

        ProductDB productDB = modelMapper.map(product, ProductDB.class);

        return productDB;
    }

    public Product convertProductDB2Product(ProductDB productDB) {

        Product product = modelMapper.map(productDB, Product.class);

        return product;
    }



}
