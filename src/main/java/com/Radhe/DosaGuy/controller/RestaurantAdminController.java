package com.Radhe.DosaGuy.controller;

import com.Radhe.DosaGuy.Request.createRestaurantRequest;
import com.Radhe.DosaGuy.Response.MessageResponse;
import com.Radhe.DosaGuy.Service.RestaurantService;
import com.Radhe.DosaGuy.Service.RestaurantServiceImple;
import com.Radhe.DosaGuy.Service.UserService;
import com.Radhe.DosaGuy.model.Restaurant;
import com.Radhe.DosaGuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurant")
public class RestaurantAdminController {
    @Autowired
    private RestaurantServiceImple restaurantService;
    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody createRestaurantRequest request,
                                                       @RequestHeader("Authorization") String token) throws Exception {

        User user=userService.findUserByJwtToken(token);
        Restaurant restaurant=restaurantService.createRestaurant(request,user);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> UpdateRestaurant(@RequestBody createRestaurantRequest request,
                                                       @RequestHeader("Authorization") String token,@PathVariable Long id) throws Exception {

        User user=userService.findUserByJwtToken(token);
        Restaurant restaurant=restaurantService.updateRestaurant(id,request);
        return new ResponseEntity<>(restaurant,HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> DeleteRestaurant(
                                                       @RequestHeader("Authorization") String token,
                                                       @PathVariable Long id) throws Exception {

        User user=userService.findUserByJwtToken(token);
        restaurantService.deleteRestaurant(id);
        MessageResponse messageResponse=new MessageResponse();
        messageResponse.setMessage("Restaurant Deleted Successfully");
        return new ResponseEntity<>(messageResponse,HttpStatus.OK);

    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Restaurant> UpdateRestaurantStatus(
                                                            @RequestHeader("Authorization") String token,
                                                            @PathVariable Long id) throws Exception {

        User user=userService.findUserByJwtToken(token);
      Restaurant restaurant=  restaurantService.updateRestaurantStatus(id);


        return new ResponseEntity<>(restaurant,HttpStatus.OK);

    }

    @GetMapping("user")
    public ResponseEntity<Restaurant> FindRestaurantByUserId(
                                                             @RequestHeader("Authorization") String token
                                                             ) throws Exception {

        User user=userService.findUserByJwtToken(token);
        Restaurant restaurant=  restaurantService.getRestaurantById(user.getId());


        return new ResponseEntity<>(restaurant,HttpStatus.OK);

    }





}
