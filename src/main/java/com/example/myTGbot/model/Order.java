package com.example.myTGbot.model;

import com.example.myTGbot.model.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Item> items;

    @ManyToOne
    private Buyer buyer;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
