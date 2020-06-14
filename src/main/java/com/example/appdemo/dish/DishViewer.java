package com.example.appdemo.dish;

import com.example.appdemo.user.User;


public class DishViewer
{
	private String title;
	private String dishType;
	private int difficulty;
	private String time;
	private String recipes;
	private String description;
	private String authorEmail;

	public DishViewer(String title, Long dishType, int difficulty, int time, String recipes, String description, User author_id)
	{
		this.title = title == null ? "" : title;
		String type = "";
		if(dishType != null)
		{
			if(dishType.intValue() == DishType.TYPE_1.getValue())
				type = DishType.TYPE_1.toString();
			if(dishType.intValue() == DishType.TYPE_2.getValue())
				type = DishType.TYPE_2.toString();
			if(dishType.intValue() == DishType.TYPE_3.getValue())
				type = DishType.TYPE_3.toString();
		}

		this.dishType = type;
		this.difficulty = difficulty;
		this.time = time + " min";
		this.recipes = recipes;
		this.description = description;
		if(author_id != null)
			this.authorEmail = author_id.getEmail();
		else
			this.authorEmail = "Brak";
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDishType()
	{
		return dishType;
	}

	public void setDishType(String dishType)
	{
		this.dishType = dishType;
	}

	public int getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty(int difficulty)
	{
		this.difficulty = difficulty;
	}

	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	public String getRecipes()
	{
		return recipes;
	}

	public void setRecipes(String recipes)
	{
		this.recipes = recipes;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getAuthorEmail()
	{
		return authorEmail;
	}

	public void setAuthorEmail(String authorEmail)
	{
		this.authorEmail = authorEmail;
	}

}
