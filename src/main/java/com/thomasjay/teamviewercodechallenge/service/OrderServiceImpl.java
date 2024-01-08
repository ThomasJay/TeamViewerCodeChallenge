package com.thomasjay.teamviewercodechallenge.service;

import com.thomasjay.teamviewerchallange.model.Order;
import com.thomasjay.teamviewerchallange.model.Product;
import com.thomasjay.teamviewercodechallenge.db.model.OrderDB;
import com.thomasjay.teamviewercodechallenge.db.model.ProductDB;
import com.thomasjay.teamviewercodechallenge.mapper.OrderDTOMapper;
import com.thomasjay.teamviewercodechallenge.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private OrderDTOMapper orderDTOMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderDTOMapper orderDTOMapper) {
        this.orderRepository = orderRepository;
        this.orderDTOMapper = orderDTOMapper;

    }

    @Override
    public List<Order> findAllOrder() {
        List<Product> products = new ArrayList<>();

        List<OrderDB> orderDBList = orderRepository.findAll();

        return orderDBList.stream().map(order -> orderDTOMapper.convertOrderDB2Order(order)).collect(Collectors.toList());
    }

    @Override
    public Order findOrderById(String id) throws Exception {
        OrderDB orderDB = orderRepository.findById(id).orElse(null);

        if (orderDB != null) {
            return orderDTOMapper.convertOrderDB2Order(orderDB);
        }
        else {
            throw new Exception("Not Found");
        }
    }

    @Override
    public Order addOrder(Order order) {
        OrderDB orderDB = orderDTOMapper.convertOrder2OrderDB(order);

        orderRepository.save(orderDB);

        return orderDTOMapper.convertOrderDB2Order(orderDB);
    }

    @Override
    public void deleteOrder(String id) throws Exception {

        try {
            orderRepository.deleteById(id);
        }
        catch (Exception e) {
            throw new Exception("Not deleted");
        }

    }

    @Override
    public Order updateOrder(Order order) throws Exception {

        try {
            OrderDB orderDB = orderDTOMapper.convertOrder2OrderDB(order);

            orderRepository.save(orderDB);

            return orderDTOMapper.convertOrderDB2Order(orderDB);

        }
        catch (Exception e) {
            throw new Exception("Not deleted");
        }

    }
}
