package com.nucleo.userservice.service;


import com.nucleo.userservice.entity.User;
import com.nucleo.userservice.model.Bike;
import com.nucleo.userservice.model.Car;
import com.nucleo.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<User> getAll(){

        return userRepository.findAll();

    }
    public User getUserById(Integer id){
        return userRepository.findById(id).orElse(null);
    }
    public User save(User user){
        User userNew = userRepository.save(user);
        return userNew;
    }

    public List<Car> getCars(int userId){
        List<Car> cars = restTemplate.getForObject("http://localhost:8002/car/byuser/"+userId, List.class);
        return cars;
    }
    public List<Bike> getBikes(int userId){
        List<Bike> bikes = restTemplate.getForObject("http://localhost:8004/bike/byuser/"+userId, List.class);
        return bikes;
    }
}
