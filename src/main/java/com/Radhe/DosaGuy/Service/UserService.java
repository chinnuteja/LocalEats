package com.Radhe.DosaGuy.Service;

import com.Radhe.DosaGuy.model.User;

public interface UserService {
    public User findUserByJwtToken(String token) throws Exception;

    public User findUserByEmail(String email) throws Exception;

}
