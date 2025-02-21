package com.Radhe.DosaGuy.controller;

import com.Radhe.DosaGuy.Request.CreateFoodRequest;
import com.Radhe.DosaGuy.Service.FoodService;
import com.Radhe.DosaGuy.Service.RestaurantService;
import com.Radhe.DosaGuy.Service.UserService;
import com.Radhe.DosaGuy.model.Food;
import com.Radhe.DosaGuy.model.Restaurant;
import com.Radhe.DosaGuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> SearchFood(@RequestParam String Name,
                                                 @RequestHeader("Authorization") String token) throws Exception {

        User user = userService.findUserByJwtToken(token);
        List<Food> food = foodService.searchFood(Name);
        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }

    @GetMapping("/restaurant/{id}/food")
    public ResponseEntity<List<Food>> GetRestaurantFood(@PathVariable Long id,
                                                       @RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserByJwtToken(token);
        List<Food> food = foodService.getAllFoods(id);
        return new ResponseEntity<>(food, HttpStatus.OK);

    }




}
