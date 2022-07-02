package com.spring.project.food.category;

public class ShopCateDTO {
	
	private String category_num;
	private String category_name;
	
	public String getCategory_num() {
		return category_num;
	}
	public void setCategory_num(String category_num) {
		this.category_num = category_num;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	@Override
	public String toString() {
		return "ShopCateDTO [category_num=" + category_num + ", category_name=" + category_name + "]";
	}
	
	

}
