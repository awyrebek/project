package com.example.appdemo.dish;

import com.example.appdemo.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "dish")
public class Dish
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	@NotNull
	private String title;

	@Column(name = "dishType")
	@NotNull
	private Long dishType;

	@Column(name = "difficulty")
	@NotNull
	private int difficulty;// od 0 do 5

	@Column(name = "time")
	@NotNull
	private int time;//w minutach

	@Column(name = "recipes")
	@NotNull
	private String recipes;

	@Column(name = "image")
	@Lob
	private Byte[] image;

	@Column(name = "description")
	private String description;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "author_id", referencedColumnName = "user_id")
	private User author_id;

	public Dish(){}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Long getDishType()
	{
		return dishType;
	}

	public void setDishType(DishType dishType)
	{
		this.dishType = Long.valueOf(dishType.getValue());
	}

	public int getDifficulty()
	{
		return difficulty;
	}

	public void setDifficulty(int difficulty)
	{
		this.difficulty = difficulty;
	}

	public int getTime()
	{
		return time;
	}

	public void setTime(int time)
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

	public Byte[] getImage()
	{
		return image;
	}

	public void setImage(Byte[] image)
	{
		this.image = image;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public User getAuthor_id()
	{
		return author_id;
	}

	public void setAuthor_id(User author_id)
	{
		this.author_id = author_id;
	}
}
