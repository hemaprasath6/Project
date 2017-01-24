package com.niit.SupplierDAO;

import java.util.List;

import com.niit.Model.Supplier;

public interface SupplierDAO {
	//declare only methods
		//CRUD operation+validations
		public List<Supplier> list();
		
		//getting Supplier based on ID
		public Supplier get(String id);
		
		
		//save
		public boolean save(Supplier Supplier);
		
		//update
		public boolean update(Supplier Supplier);
		

}
