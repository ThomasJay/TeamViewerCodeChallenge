package com.thomasjay.teamviewercodechallenge.mapper;

import com.thomasjay.teamviewerchallange.model.Order;
import com.thomasjay.teamviewerchallange.model.Product;
import com.thomasjay.teamviewercodechallenge.db.model.OrderDB;
import com.thomasjay.teamviewercodechallenge.db.model.ProductDB;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderDTOMapper {

    private ModelMapper modelMapper;

    OrderDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderDB convertOrder2OrderDB(Order order) {

        OrderDB orderDB = modelMapper.map(order, OrderDB.class);

        return orderDB;
    }

    public Order convertOrderDB2Order(OrderDB orderDB) {

        Order order = modelMapper.map(orderDB, Order.class);

        return order;
    }


}
