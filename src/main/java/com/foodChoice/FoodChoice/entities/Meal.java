package com.foodChoice.FoodChoice.entities;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mealName;

    @ManyToMany(mappedBy = "profileMealList")
    private List<Profile> profiles= new ArrayList<>();
    @ManyToOne
    private User user;

    public Meal() {
    }

    public Meal(Long id, String mealName, List<Profile> profiles, User user) {
        this.id = id;
        this.mealName = mealName;
        this.profiles = profiles;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
