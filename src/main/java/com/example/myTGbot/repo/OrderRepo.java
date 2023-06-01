package com.example.myTGbot.repo;

import com.example.myTGbot.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
