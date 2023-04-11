package com.foodChoice.FoodChoice.entities;




import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne()
    private User user;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "meal_profiles", joinColumns = @JoinColumn(name = "meal_id"), inverseJoinColumns = @JoinColumn(name = "profiles_id"))
    private List<Meal> profileMealList = new ArrayList<>();

    @Transient
    private List<Meal> sessionMealList = new ArrayList<>();//den läggs inte till databasen

    public Profile(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Profile() {
    }

    public Profile(long id, String name, User user, List<Meal> profileMealList, List<Meal> sessionMealList) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.profileMealList = profileMealList;
        this.sessionMealList = sessionMealList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Meal> getProfileMealList() {
        return profileMealList;
    }

    public void setProfileMealList(List<Meal> profileMealList) {
        this.profileMealList = profileMealList;
    }

    public List<Meal> getSessionMealList() {
        return sessionMealList;
    }

    public void setSessionMealList(List<Meal> sessionMealList) {
        this.sessionMealList = sessionMealList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
