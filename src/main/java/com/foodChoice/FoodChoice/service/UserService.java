package com.foodChoice.FoodChoice.service;

import com.foodChoice.FoodChoice.entities.User;
import com.foodChoice.FoodChoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public User addUser(User user){
        return userRepository.save(user);
    }

    public User findById(Long id){
        return userRepository.findById(id).get();
    }

    public User findUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
