package com.foodChoice.FoodChoice.repository;

import com.foodChoice.FoodChoice.entities.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {

    List<Profile> findByUserId (Long userId);
}
