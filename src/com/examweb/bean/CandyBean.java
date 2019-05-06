package com.examweb.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="candy")
public class CandyBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="candy_id")
	private int candy_id;
	@Column(name="candy_name")
	private String candyName;
	@Column(name="price")
	private long price;
	@Column(name="user_id")
	private int userId;
	
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCandy_id() {
		return candy_id;
	}
	public void setCandy_id(int candy_id) {
		this.candy_id = candy_id;
	}
	public String getCandyName() {
		return candyName;
	}
	public void setCandyName(String candyName) {
		this.candyName = candyName;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	
	
	
}
