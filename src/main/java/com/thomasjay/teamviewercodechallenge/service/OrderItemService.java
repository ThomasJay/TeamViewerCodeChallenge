package com.thomasjay.teamviewercodechallenge.service;

import com.thomasjay.teamviewerchallange.model.OrderItem;

import java.util.List;

public interface OrderItemService {

    public List<OrderItem> findAllOrderItem();

    public OrderItem findOrderItemById(String id) throws Exception;

    public List<OrderItem> findAllByOrderId(String orderId);

    public OrderItem addOrderItem(OrderItem orderItem);

    public void deleteOrderItem(String id) throws Exception;

    public OrderItem updateOrderItem(OrderItem orderItem) throws Exception;

}
