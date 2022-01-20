package com.study.springcore.homework.lab01.entity;

import java.util.List;
import java.util.stream.Collectors;

public class ItemProduct {
	
	// 商品項目,欄位
	private Integer id;
	private String text;
	private Integer price;
	private Integer inventory;
	
	// 關係
	private List<Item> items;  // 一個ItemProduct.id 對應多個 Item.ipid
	
	public ItemProduct() {
//		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getInventory() {
		return inventory;
	}
	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "產品項目 [產品序號=" + id + ", 產品名稱=" + text + ", 產品價格=" + price + ", 庫存數量=" + inventory + 
				(items == null ? "" : ", items=" + items.stream().map(i -> i.toString()).collect(Collectors.toList())) + 
				"]";
	}
}
