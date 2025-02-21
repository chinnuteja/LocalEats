package com.Radhe.DosaGuy.Request;

import com.Radhe.DosaGuy.model.Address;
import com.Radhe.DosaGuy.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class createRestaurantRequest {
    private long id;
    private String name;
    private String description;
    private Address address;
    private ContactInformation phone;
    private String openingTime;
    private List<String> images;

}
