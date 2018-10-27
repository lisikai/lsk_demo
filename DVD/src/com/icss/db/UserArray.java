package com.icss.db;

import java.util.ArrayList;

import com.icss.model.Dvd;
import com.icss.model.Users;

public class UserArray {
	
	
	public static ArrayList<Users> users = new ArrayList<Users>();
	static{
		users.add(new Users("admin","123"));
		users.add(new Users("aaa","123"));
	}
	
	public static ArrayList<Dvd> dvds = new ArrayList<Dvd>();
	static{
		dvds.add(new Dvd(1,"西游记","可借",0));
		dvds.add(new Dvd(2,"三国演义","可借",0));
	}
	
}
