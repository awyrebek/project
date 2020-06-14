package com.example.appdemo.dish;

public enum DishType
{
	TYPE_1(1, "Typ 1"),
	TYPE_2(2, "Typ 2"),
	TYPE_3(3, "Typ 3");

	private int value;
	private String desc;

	DishType(int value, String desc)
	{
		this.value = value;
		this.desc = desc;
	}


	@Override
	public String toString()
	{
		return desc;
	}

	public int getValue()
	{
		return value;
	}
}
