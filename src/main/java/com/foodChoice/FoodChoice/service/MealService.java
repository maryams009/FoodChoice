package com.foodChoice.FoodChoice.service;

import com.foodChoice.FoodChoice.entities.Meal;
import com.foodChoice.FoodChoice.entities.User;
import com.foodChoice.FoodChoice.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;


    public Meal findById(Long id){
        return mealRepository.findById(id).get();
    }


    public List<Meal> findAll() {
        List<Meal> mealList = (List<Meal>) mealRepository.findAll();
        return mealList;
    }

    public Meal addMeal(Meal meal){
        return mealRepository.save(meal);
    }

    public List<Meal> findByUser(User user) {
        return mealRepository.findByUser(user);
    }

    public Meal deleteById(Long id) {
        Meal meal = mealRepository.findById(id).orElse(null);
        if (meal != null) {
            mealRepository.delete(meal);
        }
        return meal;
    }

    public List<Meal> getMealsByUserId(Long userId){
        return mealRepository.findByUserId(userId);
    }
}
