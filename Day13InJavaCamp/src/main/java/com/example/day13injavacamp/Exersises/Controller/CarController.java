package com.example.day13injavacamp.Exersises.Controller;

import com.example.day13injavacamp.Exersises.Controller.model.Car;
import com.example.day13injavacamp.Exersises.Controller.service.Carservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

public class CarController {
    private final Carservice carservice;

    public CarController(Carservice carservice) {
        this.carservice = carservice;
    }

    @GetMapping
    public ResponseEntity<ArrayList<Car>> getCars() {
        return ResponseEntity.status(HttpStatus.OK).body(carservice.getCars());
    }

    @GetMapping("/{type}")
    public ResponseEntity<ArrayList<Car>> getCarsByType(@PathVariable String type) {
        ArrayList<Car> carsByType = carservice.getCarsByType(type);
        return ResponseEntity.status(HttpStatus.OK).body(carsByType);
    }

    @PostMapping
    public ResponseEntity<String> addCars(@RequestBody @Valid Car car, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isCarAdded = carservice.addCar(car);

        if (!isCarAdded) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body("New card added !");
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseCar(@RequestParam String userid, @RequestParam String carid) {
        Integer carCase = carservice.purchaseCar(userid, carid);
        switch (carCase) {
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id or card id is wrong");
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You don't have enough money for the car");
            case 1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("There is no car available to buy");
            case 2:
                return ResponseEntity.status(HttpStatus.OK).body("Car purchased !");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }
    }

    @PostMapping("/sell")
    public ResponseEntity<String> sellCar(@RequestParam String userid, @RequestParam String carid) {
        Integer carCase = carservice.sellaCar(userid, carid);
        switch (carCase) {
            case -1:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User id or card id is wrong");
            case 0:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("You don't own this car !");
            case 1:
                return ResponseEntity.status(HttpStatus.OK).body("Car sold !");
            default:
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error !");
        }
    }
}
