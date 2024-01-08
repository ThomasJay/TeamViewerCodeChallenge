package com.thomasjay.teamviewercodechallenge.controller;

import com.thomasjay.teamviewerchallange.api.OrderItemsApi;
import com.thomasjay.teamviewerchallange.api.OrdersApi;
import com.thomasjay.teamviewerchallange.model.DetailedOrder;
import com.thomasjay.teamviewerchallange.model.Order;
import com.thomasjay.teamviewerchallange.model.OrderItem;
import com.thomasjay.teamviewercodechallenge.service.OrderItemService;
import com.thomasjay.teamviewercodechallenge.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class OrderItemController implements OrderItemsApi {

    private OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @Override
    public ResponseEntity<OrderItem> addOrderItem(@Valid @RequestBody OrderItem orderItem) {

        try {
            OrderItem newOrderItem = orderItemService.addOrderItem(orderItem);

            return ResponseEntity.status(HttpStatus.CREATED).body(newOrderItem);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Void> deleteOrderItem(String orderItemId) {
        try {
            orderItemService.deleteOrderItem(orderItemId);

            return ResponseEntity.ok(null);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<List<OrderItem>> findAllOrderItems() {

        try {
            List<OrderItem> allOrderItems = orderItemService.findAllOrderItem();

            return ResponseEntity.ok(allOrderItems);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<OrderItem> getOrderItemById(String orderItemId) {

        try {

            OrderItem orderItem = orderItemService.findOrderItemById(orderItemId);

            return ResponseEntity.ok(orderItem);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<OrderItem> updateOrderItem(String orderItemId, @Valid @RequestBody OrderItem orderItem) {

        try {

            if (!orderItemId.equals(orderItem.getId())) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            OrderItem updatedOrderItem = orderItemService.updateOrderItem(orderItem);

            return ResponseEntity.ok(updatedOrderItem);

        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
