package com.foodChoice.FoodChoice.repository;

import com.foodChoice.FoodChoice.entities.Meal;
import com.foodChoice.FoodChoice.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MealRepository extends CrudRepository<Meal,Long> {
    List<Meal> findByUser(User user);
    List<Meal> findByUserId (Long userId);
}
