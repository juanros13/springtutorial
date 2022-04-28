package com.nucleo.userservice.feignclients;

import com.nucleo.userservice.model.Bike;
import com.nucleo.userservice.model.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@FeignClient(name = "bike-service", url = "http://localhost:8004", path = "/bike")
public interface BikeFeignClient {

    @PostMapping()
    Bike save(@RequestBody Bike bike);


    @GetMapping("byuser/{userId}")
    List<Bike> getBikes(@PathVariable("userId") int userId);

}
