package com.niit.quickstart.impl;

import com.niit.quickstart.dao.UserDao;

public class UserDaoImpl implements UserDao{
	public boolean isValidCredentials(String id,String password){
		System.out.println("in isvalidcredentials method of quickstart");
		if(id.equals("niit")&& password.equals("niit123"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
