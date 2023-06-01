package com.example.myTGbot.model;

import com.example.myTGbot.model.enums.AdminStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "admins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User {

    public Admin(Long id, String firstName, String secondName, Timestamp registrationDate, AdminStatus adminStatus, Double rating) {
        super(id,firstName, secondName, registrationDate);
        this.adminStatus = adminStatus;
        this.rating = rating;
    }

    @Enumerated(EnumType.STRING)
    private AdminStatus adminStatus;

    @Column(name = "rating")
    private Double rating;
}
