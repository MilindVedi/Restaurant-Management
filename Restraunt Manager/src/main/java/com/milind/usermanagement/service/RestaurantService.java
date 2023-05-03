package com.milind.usermanagement.service;

import com.milind.usermanagement.model.Restaurant;
import com.milind.usermanagement.model.SpecialityUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class RestaurantService {
    private static HashMap<Long, Restaurant> restaurantIdsToRestaurants = new HashMap<>();
    public String addRestaurant(Restaurant restaurant) {
        restaurantIdsToRestaurants.put(restaurant.getId(), restaurant);
        return "User " + restaurant.getName() + " Saved";
    }

    public Restaurant getRestaurantFromRestaurantId(long id) {
        return restaurantIdsToRestaurants.get(id);
    }

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>(restaurantIdsToRestaurants.values());
        return restaurants;
    }

    public boolean updateRestaurantSpeciality(SpecialityUpdateRequest specialityUpdateRequest) {
        if(restaurantIdsToRestaurants.containsKey(specialityUpdateRequest.getId())) {
            Restaurant restaurant = restaurantIdsToRestaurants.get(specialityUpdateRequest.getId());
            restaurant.setSpeciality(specialityUpdateRequest.getSpeciality());
            restaurantIdsToRestaurants.put(specialityUpdateRequest.getId(), restaurant);
            return true;
        }
        else {
            return false;
        }
    }

    public void deleteRestaurantWithRestaurantId(long id) {
        restaurantIdsToRestaurants.remove(id);
    }
}
