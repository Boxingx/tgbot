package com.example.myTGbot.service;

import com.example.myTGbot.model.Order;

public interface OrderService {
    Order create(Order order);
    Order get(Long id);
    Order update(Order order);
    void delete(Long id);
}
