package com.study.springcore.homework.lab01.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Invoice {
	
	// 發票,欄位
	private Integer id;
	private Date invdate;
	
	//關係
	private List<Item> items; // 一個 Invoice.id 對應多個 Item.invid

	public Invoice() {
//		super();
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getInvdate() {
		return invdate;
	}
	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "發票內容 [發票序號=" + id + ", 發票日期=" + invdate + ", 品項=" + 
				(items == null ? "null" : items.stream().map(i -> i.toString()).collect(Collectors.toList())) + 
				"]";
	}

	
}
