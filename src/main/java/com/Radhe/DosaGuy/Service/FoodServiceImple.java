package com.Radhe.DosaGuy.Service;

import com.Radhe.DosaGuy.Request.CreateFoodRequest;
import com.Radhe.DosaGuy.model.Category;
import com.Radhe.DosaGuy.model.Food;
import com.Radhe.DosaGuy.model.Restaurant;
import com.Radhe.DosaGuy.repository.FoodRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class FoodServiceImple implements FoodService{
    @Autowired
    private FoodRepo foodRepo;
    @Override
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant) throws Exception {
        Food food=new Food();
        food.setName(req.getName());
        food.setDescription(req.getDescription());
        food.setPrice(req.getPrice());
        food.setImages(req.getImages());
        food.setAvailable(true);
        food.setRestaurant(restaurant);
        food.setPrice(req.getPrice());
        food.setFoodCategory(category);
       Food save= foodRepo.save(food);
       restaurant.getFoods().add(save);
       return save;

    }

    @Override
    public void deleteFood(Long foodid) throws Exception {
        Food food=getFoodById(foodid);
        food.setRestaurant(null);


        foodRepo.save(food);

    }

    @Override
    public List<Food> getAllFoods(Long restaurantid) {
        List<Food> foods=foodRepo.findByRestaurantId(restaurantid);
        return foods;

    }

    @Override
    public List<Food> searchFood(String keyword) {
        return foodRepo.search(keyword);
    }

    @Override
    public Food getFoodById(Long foodid) throws Exception {
        Optional<Food> food=foodRepo.findById(foodid);
        if (food.isEmpty()){
            throw new Exception("Food not found");
        }
        return food.get();
    }

    @Override
    public Food updateAvailability(Long foodid) throws Exception {
        Food food=getFoodById(foodid);
        food.setAvailable(!food.isAvailable());
        return foodRepo.save(food);
    }
}
