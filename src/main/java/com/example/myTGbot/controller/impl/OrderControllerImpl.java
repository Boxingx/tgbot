package com.example.myTGbot.controller.impl;

import com.example.myTGbot.controller.OrderController;
import com.example.myTGbot.model.Buyer;
import com.example.myTGbot.model.Item;
import com.example.myTGbot.model.Order;
import com.example.myTGbot.model.enums.OrderStatus;
import com.example.myTGbot.service.OrderService;
import com.example.myTGbot.validation.Validation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderControllerImpl implements OrderController {
    @Autowired
    private final OrderService orderService;
    @Autowired
    private final Validation validation;

    @Override
    public Order create(Timestamp currentDate, List<Item> items, Buyer buyer, OrderStatus orderStatus) {
        Order order = new Order(null, new Timestamp(System.currentTimeMillis()), items, buyer, orderStatus);
        return orderService.create(order);
    }

    @Override
    public Order get(Long id) {
        return orderService.get(id);
    }

    @Override
    public Order update(Long id, Timestamp currentDate, List<Item> items, Buyer buyer, OrderStatus orderStatus) {
        Order order = new Order(id, new Timestamp(System.currentTimeMillis()), items, buyer, orderStatus);
        return orderService.update(order);
    }

    @Override
    public void delete(Long id) {
        orderService.delete(id);
    }
}
