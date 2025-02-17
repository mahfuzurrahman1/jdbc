package com.telusko.jdbc.main;
import java.sql.*;

import com.telusko.jdbc.util.JdbcUtility;
public class LaunchJDBCAll 
{
	public static void main(String[] args) 
	{
		
		//Resource
		Connection connect=null;
		Statement stmt=null;
		ResultSet rs=null;
		try
		{
			
			connect=JdbcUtility.getDBConnection();
			if(connect!=null)
				stmt=connect.createStatement();
//			if(stmt!=null)
//				rs=stmt.executeQuery("SELECT * from studentdetail");
//			if(rs!=null)
//			{
//				System.out.println("ID\tNAME\tAGE\tGENDER");
//				while(rs.next())
//				{
//					System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"+
//				  rs.getInt(3) + "\t" + rs.getString(4));
//					//Integer i=rs.getInt(1);
//					
//				}
//			}
			
			if(stmt!=null)
			{
			 boolean status = stmt.execute("UPDATE studentinfo set sage=24 where sid=4");
			   if(status)
			   {
				   //ResultSet
				   System.out.println("Write ResultSet implementation to get data");
				   rs=stmt.getResultSet();
				   if(rs!=null)
						{
							System.out.println("SID\tNAME\tAGE\tAddress");
							while(rs.next())
							{
								System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t"+
							  rs.getInt(3) + "\t" + rs.getString(4));
								//Integer i=rs.getInt(1);
								
							}
						}
			   }
			   else
			   {
				   System.out.println("get the update how many rows affected");
				   int rowsAffected=stmt.getUpdateCount();
				   System.out.println(rowsAffected);
			   }
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
