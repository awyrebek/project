package com.example.appdemo.mainController;

import com.example.appdemo.dish.Dish;
import com.example.appdemo.dish.DishRepository;
import com.example.appdemo.dish.DishType;
import com.example.appdemo.dish.DishViewer;
import com.example.appdemo.user.User;
import com.example.appdemo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import java.util.ArrayList;
import java.util.List;

@Controller
public class DishController
{
	@Autowired
	private DishRepository dishRepository;

	@Autowired
	private UserRepository userRepository;

	@GET
	@RequestMapping(value = {"/dish"})
	public String showDishPage(Model model)
	{
		List<Dish> all = dishRepository.findAll();
		List<DishViewer> allDish = new ArrayList<>();
		for (Dish dish: all)
		{
			DishViewer dv = new DishViewer(dish.getTitle(), dish.getDishType(), dish.getDifficulty(), dish.getTime(), dish.getRecipes(), dish.getDescription(), dish.getAuthor_id());
			allDish.add(dv);
		}

		model.addAttribute("allDish", allDish);
		return "dish";
	}

	@GET
	@RequestMapping(value = {"/addDish"})
	public String showAddDishPage()
	{
		return "addDish";
	}

	@POST
	@RequestMapping(value = "/addNewDish")
	public String addDish(@RequestParam String title, @RequestParam String dishType, @RequestParam int difficulty,@RequestParam int time, @RequestParam String recipes ,@RequestParam String description, Model model)
	{
		Dish dish = new Dish();
		String title2 = title == null ? "" : title;
		dish.setTitle(title2);

		if(dishType.equals(DishType.TYPE_1.toString()))
			dish.setDishType(DishType.TYPE_1);
		if(dishType.equals(DishType.TYPE_2.toString()))
			dish.setDishType(DishType.TYPE_2);
		if(dishType.equals(DishType.TYPE_3.toString()))
			dish.setDishType(DishType.TYPE_3);

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = "";
		if (principal instanceof UserDetails)
			userName = ((UserDetails)principal).getUsername();

	User user = userRepository.findByEmail(userName);

		dish.setDifficulty(difficulty);
		dish.setTime(time);
		dish.setRecipes(recipes);
		dish.setDescription(description);
		dish.setAuthor_id(user);

		dishRepository.save(dish);
		return "dishAdded";
	}
}
