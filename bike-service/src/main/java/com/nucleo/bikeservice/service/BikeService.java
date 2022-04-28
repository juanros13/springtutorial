package com.nucleo.bikeservice.service;


import com.nucleo.bikeservice.entity.Bike;
import com.nucleo.bikeservice.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BikeService {

    @Autowired
    BikeRepository bikeRepository;

    public List<Bike> getAll(){

        return bikeRepository.findAll();

    }
    public Bike getBikeById(Integer id){
        return bikeRepository.findById(id).orElse(null);
    }
    public Bike save(Bike user){
        Bike bikeNew = bikeRepository.save(user);
        return bikeNew;
    }

    public List<Bike> byUserId(int userId){
        return bikeRepository.findByUserId(userId);
    }
}
