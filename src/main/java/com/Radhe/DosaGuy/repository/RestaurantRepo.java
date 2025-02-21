package com.Radhe.DosaGuy.repository;

import com.Radhe.DosaGuy.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {
//    Restaurant findByEmail(String email);
//    Restaurant findByRestaurantName(String restaurantName);
//    Restaurant findByRestaurantId(Long restaurantId);
@Query("SELECT r FROM Restaurant r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :searchQuery, '%'))")
List<Restaurant> findBySearchQuery(String searchQuery);

    Restaurant findByOwner_Id(Long ownerID);
}
