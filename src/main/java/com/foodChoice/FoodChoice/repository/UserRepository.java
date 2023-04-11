package com.foodChoice.FoodChoice.repository;

import com.foodChoice.FoodChoice.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {

    public User findByEmail(String em);
    public User findByUserName(String userName);

}
