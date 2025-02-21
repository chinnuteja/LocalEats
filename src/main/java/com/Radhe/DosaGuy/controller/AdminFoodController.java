package com.Radhe.DosaGuy.controller;

import com.Radhe.DosaGuy.Request.CreateFoodRequest;
import com.Radhe.DosaGuy.Response.MessageResponse;
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

import javax.management.relation.RelationService;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest request,
                                           @RequestHeader("Authorization") String token) throws Exception {

        User user = userService.findUserByJwtToken(token);
        Restaurant restaurant = restaurantService.getRestaurantById(request.getRestaurantId());

        Food food = foodService.createFood(request, request.getFoodCategory(), restaurant);
        return new ResponseEntity<>(food, HttpStatus.CREATED);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@PathVariable Long id,
                                                      @RequestHeader("Authorization") String token) throws Exception {

        User user = userService.findUserByJwtToken(token);


        foodService.deleteFood(id);
        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setMessage("Food Deleted Successfully");
        return new ResponseEntity<>(messageResponse, HttpStatus.CREATED);

    }

    @PutMapping()
    public ResponseEntity<Food> UpdateFoodAval(@PathVariable Long id,
                                               @RequestHeader("Authorization") String token) throws Exception {
        {

            User user = userService.findUserByJwtToken(token);
            Food food = foodService.updateAvailability(id);


            return new ResponseEntity<>(food, HttpStatus.CREATED);

        }

    }
}
