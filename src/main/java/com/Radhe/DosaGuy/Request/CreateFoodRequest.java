package com.Radhe.DosaGuy.Request;

import com.Radhe.DosaGuy.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category foodCategory;

    private List<String> images;
    private Long restaurantId;

}
