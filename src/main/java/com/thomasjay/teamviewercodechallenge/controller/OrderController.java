package com.thomasjay.teamviewercodechallenge.controller;

import com.thomasjay.teamviewerchallange.api.OrdersApi;
import com.thomasjay.teamviewerchallange.model.DetailedOrder;
import com.thomasjay.teamviewerchallange.model.Order;
import com.thomasjay.teamviewerchallange.model.OrderItem;
import com.thomasjay.teamviewerchallange.model.Product;
import com.thomasjay.teamviewercodechallenge.service.OrderItemService;
import com.thomasjay.teamviewercodechallenge.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderController implements OrdersApi  {

    private OrderService orderService;

    private OrderItemService orderItemService;

    public OrderController(OrderService orderService, OrderItemService orderItemService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
    }


    @Override
    public ResponseEntity<Order> addOrder(@Valid @RequestBody Order order) {

        try {
            Order newOrder = orderService.addOrder(order);

            return ResponseEntity.status(HttpStatus.CREATED).body(newOrder);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Void> deleteOrder(String orderId) {
        try {
            orderService.deleteOrder(orderId);

            return ResponseEntity.ok(null);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<List<DetailedOrder>> findAllOrders() {

        log.info("findAllOrders started");

        try {
            List<Order> allOrders = orderService.findAllOrder();

            log.info("findAllOrders started len: " + allOrders.size());


            List<DetailedOrder> detailedOrderList = new ArrayList<DetailedOrder>();

            // Maybe change to a streams implementation or better 1 : many mapping in db
            for (Order order : allOrders) {

                DetailedOrder detailedOrder = new DetailedOrder();

                detailedOrder.setId(order.getId());
                detailedOrder.setStatus(order.getStatus());

                List<OrderItem> orderItems = orderItemService.findAllByOrderId(order.getId());
                detailedOrder.setOrderItems(orderItems);

                detailedOrderList.add(detailedOrder);

            }

            return ResponseEntity.ok(detailedOrderList);
        }
        catch (Exception e) {
            log.error(e.getMessage());
                    e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<DetailedOrder> getOrderById(String orderId) {

        try {

            Order order = orderService.findOrderById(orderId);

            // Maybe change to a streams implementation or better 1 : many mapping in db
            List<OrderItem> orderItems = orderItemService.findAllByOrderId(orderId);

            DetailedOrder detailedOrder = new DetailedOrder();

            detailedOrder.setId(order.getId());
            detailedOrder.setStatus(order.getStatus());
            detailedOrder.setOrderItems(orderItems);

            return ResponseEntity.ok(detailedOrder);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<Order> updateOrder(String orderId, @Valid @RequestBody Order order) {

        try {

            if (!orderId.equals(order.getId())) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            Order updatedOrder = orderService.updateOrder(order);

            return ResponseEntity.ok(updatedOrder);

        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
