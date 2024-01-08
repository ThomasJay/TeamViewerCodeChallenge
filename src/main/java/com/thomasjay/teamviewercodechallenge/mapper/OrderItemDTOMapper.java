package com.thomasjay.teamviewercodechallenge.mapper;

import com.thomasjay.teamviewerchallange.model.OrderItem;
import com.thomasjay.teamviewercodechallenge.db.model.OrderItemDB;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderItemDTOMapper {

    private ModelMapper modelMapper;

    OrderItemDTOMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public OrderItemDB convertOrderItem2OrderItemDB(OrderItem orderItem) {

        OrderItemDB orderItemDB = modelMapper.map(orderItem, OrderItemDB.class);

        return orderItemDB;
    }

    public OrderItem convertOrderItemDB2OrderItem(OrderItemDB orderItemDB) {

        OrderItem orderItem = modelMapper.map(orderItemDB, OrderItem.class);

        return orderItem;
    }

}
