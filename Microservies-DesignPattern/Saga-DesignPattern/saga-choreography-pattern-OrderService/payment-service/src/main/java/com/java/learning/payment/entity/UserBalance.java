package com.java.learning.payment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity    // not using @Table annotation , based on class name it will create table automatically
@Data
@AllArgsConstructor
@NoArgsConstructor
// class used to validate user balance
public class UserBalance {
    @Id
    private int userId;
    private int price;
}
