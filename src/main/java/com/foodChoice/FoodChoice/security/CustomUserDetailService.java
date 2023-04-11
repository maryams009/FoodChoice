package com.foodChoice.FoodChoice.security;

import com.foodChoice.FoodChoice.entities.User;
import com.foodChoice.FoodChoice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String em) throws UsernameNotFoundException {
        try{
            User user= userRepository.findByEmail(em);
            if(user==null){
                throw new UsernameNotFoundException("user not found");
            } else{
                return new CustomUserDetail(user);
            }
        }catch(Exception e){

            e.printStackTrace();
        }
        return null;
    }
    }

