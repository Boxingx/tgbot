package com.example.myTGbot.service;

import com.example.myTGbot.model.Buyer;

public interface BuyerService {
    void create(Buyer buyer);
    Buyer get(Long id);
    Buyer update(Buyer buyer);
    void delete(Long id);
    void registration(Buyer buyer);
}
