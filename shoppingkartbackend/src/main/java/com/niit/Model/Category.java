package com.niit.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Table;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Entity
@Table()
@Service
@Component
public class Category {
	
	@Id
	public String cat_id;
	
	public String category_name;
	
	public String description;

	public String getCat_id() {
		return cat_id;
	}

	public void setCat_id(String cat_id) {
		this.cat_id = cat_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
