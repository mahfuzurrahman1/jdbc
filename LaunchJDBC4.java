package com.telusko.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchJDBC3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		//load and register driver
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver is registered");
		
		String url="jdbc:mysql://localhost:3306/teluskodb";
		String userName="root";
		String password="mypassword";
		
		Connection connect=DriverManager.getConnection(url, userName, password);
		System.out.println("Connection established!");
		
		
		Statement stmnt = connect.createStatement();
		
		//String query="UPDATE studentinfo set sage=23 where sid=4";
		
		String query="DELETE from studentinfo where sid=1";
		int rowAffected=stmnt.executeUpdate(query);
		System.out.println("Rows affected : "+ rowAffected);
		if(rowAffected!=0)
			//System.out.println("Updated successfully!");
			System.out.println("Deleted successfully!");
		else
			//System.out.println("Failed to update!");
			System.out.println("Failed to delete!");
		
		stmnt.close();
		connect.close();
		

	}

}
