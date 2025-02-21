package com.Radhe.DosaGuy.Service;

import com.Radhe.DosaGuy.Request.CreateFoodRequest;
import com.Radhe.DosaGuy.model.Category;
import com.Radhe.DosaGuy.model.Food;
import com.Radhe.DosaGuy.model.Restaurant;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) throws Exception;
    void deleteFood(Long foodid) throws Exception;
    public List<Food> getAllFoods(Long restaurantid);
    public List<Food> searchFood(String keyword);
    public Food getFoodById(Long foodid) throws Exception;
    public Food updateAvailability(Long foodid) throws Exception;
}
