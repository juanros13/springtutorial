package com.nucleo.carservice.service;


import com.nucleo.carservice.entity.Car;

import com.nucleo.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public List<Car> getAll(){

        return carRepository.findAll();

    }
    public Car getCarById(Integer id){
        return carRepository.findById(id).orElse(null);
    }
    public Car save(Car user){
        Car userNew = carRepository.save(user);
        return userNew;
    }

    public List<Car> byUserId(int userId){
        return carRepository.findByUserId(userId);
    }
}
