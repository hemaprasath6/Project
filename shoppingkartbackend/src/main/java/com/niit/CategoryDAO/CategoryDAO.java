package com.niit.CategoryDAO;

import java.util.List;

import com.niit.Model.Category;

public interface CategoryDAO {
	//declare only methods
		//CRUD operation+validations
	public List<Category> list();
	
	public boolean save(Category category);
	
	public boolean saveOrUpdate(Category category);
	
	public boolean update(Category category);
	
	public boolean delete(String id);
	public Category get(String id);
	
	public Category getByName(String name);
	

}
