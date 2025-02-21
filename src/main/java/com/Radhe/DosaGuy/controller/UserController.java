package com.Radhe.DosaGuy.controller;

import com.Radhe.DosaGuy.Service.UserService;
import com.Radhe.DosaGuy.Service.UserServiceImple;
import com.Radhe.DosaGuy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    public UserServiceImple userServiceImple;

    @GetMapping("/profile")
    public ResponseEntity<User> findUserByJwtToken(@RequestHeader("Authorization") String token) throws Exception {
        User user = userServiceImple.findUserByJwtToken(token);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @GetMapping("/profile/email")
    public ResponseEntity<User> findUserByEmail(@RequestHeader("email") String email) throws Exception {
        User user = userServiceImple.findUserByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
