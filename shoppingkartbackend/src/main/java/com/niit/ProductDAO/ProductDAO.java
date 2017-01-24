package com.niit.ProductDAO;

import java.util.List;

import com.niit.Model.Product;


public interface ProductDAO {
	//declare only methods
		//CRUD operation+validations
		public List<Product> list();
		
		public Product get(String id);
		public boolean save(Product Product);
		
		//update
		public boolean update(Product Product);
		

}
