package com.example.day13injavacamp.Exersises.Controller.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.ArrayList;

@Data
public class User {
    private final Object ArrayList;
    @NotEmpty(message = "id is required")
    private String id;
    @NotEmpty(message = "username is required")
    @Size(min = 3)
    private String username;
    @NotEmpty(message = "password is required")
    @Size(min = 6)
    private String password;
    @NotNull(message = "balance is required")
    @Positive(message = "balance have to be positive")
    @Range
    private Integer balance;

    public User(String id, String username, String password, Integer balance, ArrayList<Car> carsOwned) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.ArrayList < Car >= carsOwned;
    }
}
