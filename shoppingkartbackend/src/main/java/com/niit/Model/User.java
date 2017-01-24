package com.niit.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;



//map to specify db entity(table)
@Entity
@Table
@Component

public class User {
@Id // to specify primary key
public String id;

public String name;

public String password;



public String contact;

public String role;



public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


public String getContact() {
	return contact;
}

public void setContact(String contact) {
	this.contact = contact;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}



}
