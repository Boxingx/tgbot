package com.example.myTGbot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Buyers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buyer extends User {

    public Buyer(Long id, String firstName, String secondName, Timestamp registrationDate, List<Order> orderList, String address) {
        super(id, firstName, secondName, registrationDate);
        this.orderList = orderList;
        this.address = address;
    }
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orderList;
    @Column(name = "address")
    private String address;


}
