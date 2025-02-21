package com.Radhe.DosaGuy.Service;

import com.Radhe.DosaGuy.config.JwtProvider;
import com.Radhe.DosaGuy.model.User;
import com.Radhe.DosaGuy.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImple implements UserService {

    @Autowired
    UserRepo userRepo;
    @Autowired
    private JwtProvider jwtProvider;
    @Override
    public User findUserByJwtToken(String token) throws Exception {
        String email=jwtProvider.getEmailFromToken(token);
        User user=userRepo.findByEmail(email);
        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user=userRepo.findByEmail(email);
        if(user==null){
            throw new Exception("user not found with this email");
        }
        return user;
    }
}
