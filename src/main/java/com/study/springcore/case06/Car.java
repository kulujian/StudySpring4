package com.study.springcore.case06;

public class Car {
	private String name;
	private Integer price;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}
	
}
