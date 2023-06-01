package com.example.myTGbot.repo;

import com.example.myTGbot.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer, Long> { //Параматризация репозитория, 1 параметр с какой сущностью будет работать репо а 2 тип данных описывающий праймари ки


}
