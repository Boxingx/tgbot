package com.example.myTGbot.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity //Применимо к классу(сущность), в скобках имя таблицы. Показывает хибернейту что класс является шаблоном для пострроение таблицы.
@Table(name = "items")
@NoArgsConstructor
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "isAvailable")
    private boolean isAvailable;

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
        isAvailable = true;
    }

    public Item(Long id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

}
