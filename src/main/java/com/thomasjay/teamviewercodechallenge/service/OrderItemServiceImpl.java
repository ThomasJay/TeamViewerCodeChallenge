package com.thomasjay.teamviewercodechallenge.service;

import com.thomasjay.teamviewerchallange.model.Order;
import com.thomasjay.teamviewerchallange.model.OrderItem;
import com.thomasjay.teamviewerchallange.model.Product;
import com.thomasjay.teamviewercodechallenge.db.model.OrderDB;
import com.thomasjay.teamviewercodechallenge.db.model.OrderItemDB;
import com.thomasjay.teamviewercodechallenge.mapper.OrderDTOMapper;
import com.thomasjay.teamviewercodechallenge.mapper.OrderItemDTOMapper;
import com.thomasjay.teamviewercodechallenge.repository.OrderItemRepository;
import com.thomasjay.teamviewercodechallenge.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class OrderItemServiceImpl implements OrderItemService {

    private OrderItemRepository orderItemRepository;
    private OrderItemDTOMapper orderItemDTOMapper;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository, OrderItemDTOMapper orderItemDTOMapper) {
        this.orderItemRepository = orderItemRepository;
        this.orderItemDTOMapper = orderItemDTOMapper;

    }

    @Override
    public List<OrderItem> findAllOrderItem() {
        List<Product> products = new ArrayList<>();

        List<OrderItemDB> orderItemDBList = orderItemRepository.findAll();

        return orderItemDBList.stream().map(order -> orderItemDTOMapper.convertOrderItemDB2OrderItem(order)).collect(Collectors.toList());
    }

    @Override
    public OrderItem findOrderItemById(String id) throws Exception {
        OrderItemDB orderItemDB = orderItemRepository.findById(id).orElse(null);

        if (orderItemDB != null) {
            return orderItemDTOMapper.convertOrderItemDB2OrderItem(orderItemDB);
        }
        else {
            throw new Exception("Not Found");
        }
    }

    public List<OrderItem> findAllByOrderId(String orderId) {

        List<OrderItemDB> orderItemDBList = orderItemRepository.findAllByOrderId(orderId);

        return orderItemDBList.stream().map(order -> orderItemDTOMapper.convertOrderItemDB2OrderItem(order)).collect(Collectors.toList());


    }

    @Override
    public OrderItem addOrderItem(OrderItem orderItem) {
        OrderItemDB orderItemDB = orderItemDTOMapper.convertOrderItem2OrderItemDB(orderItem);

        orderItemRepository.save(orderItemDB);

        return orderItemDTOMapper.convertOrderItemDB2OrderItem(orderItemDB);
    }

    @Override
    public void deleteOrderItem(String id) throws Exception {

        try {
            orderItemRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new Exception("Not deleted");
        }

    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem) throws Exception {

        try {
            OrderItemDB orderItemDB = orderItemDTOMapper.convertOrderItem2OrderItemDB(orderItem);

            orderItemRepository.save(orderItemDB);

            return orderItemDTOMapper.convertOrderItemDB2OrderItem(orderItemDB);

        }
        catch (Exception e) {
            throw new Exception("Not deleted");
        }

    }

}
