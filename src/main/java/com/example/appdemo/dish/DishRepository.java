package com.example.appdemo.dish;

import com.example.appdemo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("dishRepository")
public interface DishRepository extends JpaRepository<Dish, Integer>
{
}
