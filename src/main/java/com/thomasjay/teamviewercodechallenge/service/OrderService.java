package com.thomasjay.teamviewercodechallenge.service;

import com.thomasjay.teamviewerchallange.model.Order;

import java.util.List;

public interface OrderService {

    public List<Order> findAllOrder();

    public Order findOrderById(String id) throws Exception;

    public Order addOrder(Order order);

    public void deleteOrder(String id) throws Exception;

    public Order updateOrder(Order order) throws Exception;

}
