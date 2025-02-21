package com.Radhe.DosaGuy.repository;

import com.Radhe.DosaGuy.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodRepo extends JpaRepository<Food,Long> {

    public Food findByFoodName(String foodName);
    List<Food> findByRestaurantId(Long restaurantId);
    @Query("SELECT f FROM Food f WHERE f.name LIKE %:keyword% ")
    List<Food> search(@Param("keyword")String keyword);
}
