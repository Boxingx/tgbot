package com.example.myTGbot.controller;

import com.example.myTGbot.model.Buyer;
import com.example.myTGbot.model.Item;
import com.example.myTGbot.model.Order;
import com.example.myTGbot.model.enums.OrderStatus;

import java.sql.Timestamp;
import java.util.List;

public interface OrderController {
    Order create(Timestamp currentDate, List<Item> items, Buyer buyer, OrderStatus orderStatus);
    Order get(Long id);
    Order update(Long id, Timestamp currentDate, List<Item> items, Buyer buyer, OrderStatus orderStatus);
    void delete(Long id);
}
