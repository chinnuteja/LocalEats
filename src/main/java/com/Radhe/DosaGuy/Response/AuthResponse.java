package com.Radhe.DosaGuy.Response;

import com.Radhe.DosaGuy.model.USER_ROLE;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;
}
