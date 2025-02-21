package com.Radhe.DosaGuy.Service;

import com.Radhe.DosaGuy.Request.createRestaurantRequest;
import com.Radhe.DosaGuy.dto.RestaurantDto;
import com.Radhe.DosaGuy.model.Restaurant;
import com.Radhe.DosaGuy.model.User;

import java.util.List;

public interface RestaurantService {
    public Restaurant createRestaurant(createRestaurantRequest request, User user) ;
    public Restaurant updateRestaurant(Long restaurantid,createRestaurantRequest request) throws Exception;
    public void deleteRestaurant(Long restaurantid) throws Exception;
    public List<Restaurant> getAllRestaurants();
    public List<Restaurant> searchRestaurant(String keyword);
    public Restaurant getRestaurantById(Long restaurantid) throws Exception;
    public Restaurant getRestaurantByUser(Long userid) throws Exception;
    public RestaurantDto addtoFavourite(Long restaurantid,User user) throws Exception;
    public Restaurant updateRestaurantStatus(Long restaurantid) throws Exception;
}
