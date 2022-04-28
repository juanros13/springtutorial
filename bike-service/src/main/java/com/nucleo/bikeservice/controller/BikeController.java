package com.nucleo.bikeservice.controller;


import com.nucleo.bikeservice.entity.Bike;
import com.nucleo.bikeservice.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    BikeService bikeService;


    @GetMapping
    public ResponseEntity<List<Bike>> getAll(){
        List<Bike> bikes  = bikeService.getAll();
        if(bikes.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(bikes);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bike> getById(
       @PathVariable("id") int id
    ){
        Bike bike  = bikeService.getBikeById(id);
        if(bike == null){
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(bike);
        }
    }


    @PostMapping()
    public ResponseEntity<Bike> save(
            @RequestBody Bike user
    ){
       Bike bikeNew  = bikeService.save(user);

       return ResponseEntity.ok(bikeNew);

    }
    @GetMapping("byuser/{userId}")
    public ResponseEntity<List<Bike>> getByUserId(
            @PathVariable("userId") int userId
    ){
        List<Bike> bikes  = bikeService.byUserId(userId);
        if(bikes.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(bikes);
        }
    }
}
