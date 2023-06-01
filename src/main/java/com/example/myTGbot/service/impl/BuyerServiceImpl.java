package com.example.myTGbot.service.impl;

import com.example.myTGbot.model.Buyer;
import com.example.myTGbot.repo.BuyerRepo;
import com.example.myTGbot.service.BuyerService;
import org.springframework.stereotype.Service;

@Service
public class BuyerServiceImpl implements BuyerService {

    private final BuyerRepo buyerRepo;

    public BuyerServiceImpl(BuyerRepo buyerRepo) {
        this.buyerRepo = buyerRepo;
    }

    @Override
    public void create(Buyer buyer) {
        buyerRepo.save(buyer);
    }

    @Override
    public Buyer get(Long id) {
        return buyerRepo.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Buyer update(Buyer buyer) {
        return buyerRepo.save(buyer);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void registration(Buyer buyer) {
        System.out.println("registration service method");
        if (buyerRepo.findById(buyer.getId()).isEmpty()) {
            create(buyer);
        }
        System.out.println("registration service method 2");
    }
}
