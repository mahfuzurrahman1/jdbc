package com.telusko.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchJDBC2 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		        //load and register the driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Driver is registered");
				
				//Establish the connection
				
				String url="jdbc:mysql://localhost:3306/teluskodb";
				String userName="root";
				String password="mypassword";
				
				Connection connect=DriverManager.getConnection(url, userName, password);
				System.out.println("Connection established!");
				
				Statement stmnt = connect.createStatement();
				String query="INSERT INTO studentinfo (sid, sname, sage, saddr) "
						+ "VALUES(4, 'Shramik', 22, 'kolhapur')";
				int rowAffected=stmnt.executeUpdate(query);
				System.out.println("Query is fine!");
				if(rowAffected!=0)
					System.out.println("Check db! Data has been added");
				else
					System.out.println("Fail to add");
				
				
				stmnt.close();
				connect.close();
				

	}

}
