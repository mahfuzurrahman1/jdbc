package com.telusko.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.telusko.jdbc.util.JdbcUtility;

public class LaunchJDBCUpdate 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//Resource
				Connection connect=null;
				PreparedStatement stmt=null;
				ResultSet rs=null;
				Scanner scan=null;
				try
				{
					
					connect=JdbcUtility.getDBConnection();
					if(connect!=null)
					{
						stmt=connect.prepareStatement("UPDATE studentinfo set sage=? where sid=?");
					}
					

					if(stmt!=null)
					{
						System.out.println("Welcome to my world!");
						
						scan=new Scanner(System.in);
						System.out.println("Please enter your id");
						Integer id=scan.nextInt();
						System.out.println("Please enter your age to be updated");
						Integer age=scan.nextInt();
						
						stmt.setInt(1, age);
						stmt.setInt(2, id);
						
						int rowAffected=stmt.executeUpdate();
						if(rowAffected!=0)
							System.out.println("Update successfull");
						else
							System.out.println("Failed to update!");
						
					}
						
						
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				finally
				{
					try 
					{
						JdbcUtility.closeResource(connect, stmt, rs);
					} 
					catch (SQLException e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				

	}

}
