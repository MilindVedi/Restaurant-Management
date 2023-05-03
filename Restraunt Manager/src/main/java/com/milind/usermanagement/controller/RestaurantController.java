package com.milind.usermanagement.controller;

import com.milind.usermanagement.model.Restaurant;
import com.milind.usermanagement.model.SpecialityUpdateRequest;
import com.milind.usermanagement.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {
    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/addRestaurant")
    public String addUser(@RequestBody Restaurant restaurant) {
        return restaurantService.addRestaurant(restaurant);
    }

    @GetMapping("/getRestaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable long id) {
        Restaurant restaurant = restaurantService.getRestaurantFromRestaurantId(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/getAllRestaurants")
    public ResponseEntity<List <Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurants, HttpStatus.OK);
    }

    @PostMapping("/updateRestaurantSpeciality")
    public String updateRestaurantInfo(@RequestBody SpecialityUpdateRequest specialityUpdateRequest) {
        Boolean updated = restaurantService.updateRestaurantSpeciality(specialityUpdateRequest);
        if(updated) {
            return "Restaurant with Restaurant id " + specialityUpdateRequest.getId() + " updated";
        }
        else {
            return "No such Restaurant present";
        }
    }

    @GetMapping("/deleteRestaurant/{id}")
    public String deleteRestaurant(@PathVariable long id) {
        restaurantService.deleteRestaurantWithRestaurantId(id);
        return "User Removed";
    }
}
