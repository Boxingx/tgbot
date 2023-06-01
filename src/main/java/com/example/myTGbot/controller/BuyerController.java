package com.example.myTGbot.controller;

import com.example.myTGbot.model.Order;
import com.example.myTGbot.model.User;

import java.util.List;

public interface BuyerController {
    void create(Long id, String firstName, String secondName, List<Order> orderList, String address);
    User get(Long id);
    User update(Long id, String firstName, String secondName, List<Order> orderList, String address);
    void delete(Long id);
    void registration(Long id, String firstName, String secondName, List<Order> orderList, String address);
}
