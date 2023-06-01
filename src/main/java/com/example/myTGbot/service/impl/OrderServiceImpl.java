package com.example.myTGbot.service.impl;

import com.example.myTGbot.model.Order;
import com.example.myTGbot.repo.OrderRepo;
import com.example.myTGbot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;


    @Override
    public Order create(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order get(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Order update(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public void delete(Long id) {

    }
}
