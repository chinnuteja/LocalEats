package com.Radhe.DosaGuy.controller;

import com.Radhe.DosaGuy.Request.createRestaurantRequest;
import com.Radhe.DosaGuy.Service.RestaurantService;
import com.Radhe.DosaGuy.Service.UserService;
import com.Radhe.DosaGuy.dto.RestaurantDto;
import com.Radhe.DosaGuy.model.Restaurant;
import com.Radhe.DosaGuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(@RequestHeader("Authorization") String token,
                                                             @RequestParam String keyword) throws Exception {

        User user = userService.findUserByJwtToken(token);
        List<Restaurant> restaurant = restaurantService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurant(@RequestHeader("Authorization") String token
    ) throws Exception {

        User user = userService.findUserByJwtToken(token);
        List<Restaurant> restaurant = restaurantService.getAllRestaurants();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> FindRestaurantById(@RequestHeader("Authorization") String token,
                                                         @PathVariable Long id) throws Exception {
        {

            User user = userService.findUserByJwtToken(token);
            Restaurant restaurant = restaurantService.getRestaurantById(id);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }


    }
    @GetMapping("/{id}/add-fav")
    public ResponseEntity<RestaurantDto> addTofav(@RequestHeader("Authorization") String token,
                                                         @PathVariable Long id) throws Exception {
        {

            User user = userService.findUserByJwtToken(token);
            RestaurantDto restaurant = restaurantService.addtoFavourite(id,user);
            return new ResponseEntity<>(restaurant, HttpStatus.OK);
        }


    }
}
