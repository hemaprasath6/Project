package com.niit.UserDAO;

import com.niit.Model.*;
import java.util.List;

public interface UserDAO {
	//declare only methods
	//CRUD operation+validations
	public List<User> list();
	
	//getting user based on ID
	public User get(String id);
	
	//validating 
	public User validate(String id, String password);
	 
	//save
	public boolean save(User user);
	
	//update
	public boolean update(User user);
	

}
