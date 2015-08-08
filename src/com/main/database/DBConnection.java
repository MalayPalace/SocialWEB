package com.main.database;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Properties;

/**
 * Class to get Connection by reading database.properties file
 * 
 * @author Malay Shah
 */

public class DBConnection {

	//Global Strings
	static String url=null;
	static String dbname=null;
	static String dbpath=null;
	static String username=null;
	static String password=null;

	
	public void init(){
		InputStream in=null;
		Properties prop=new Properties();

		try{
			in=DBConnection.class.getClassLoader().getResourceAsStream("com/config/database.properties");
			prop.load(in);

			//Retrieve value from database.properties file
			dbpath=prop.getProperty("db.path");
			dbname=prop.getProperty("db.name");
			username=prop.getProperty("db.user");
			password=prop.getProperty("db.password");
			
			url="jdbc:mysql://"+dbpath+"/"+dbname;

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConn(){
		DBConnection db=new DBConnection();
		db.init();

		Connection con=null;
		try{
			//Database connectivity code
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// initialize the Connection, with our DB info ...
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e){
			System.out.println("Exception :" + e);
			e.printStackTrace();						
		}
		return con;
	}
	
	public static void resetDB(String name){
		DBConnection db=new DBConnection();
		db.init();
		
		Connection con=null;
		Statement stmt=null;
		String tableName=name;

		String query="Delete from "+tableName;
		try{
			//Database connectivity code
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			// initialize the Connection, with our DB info ...
			con = DriverManager.getConnection(url,username,password);

			if(con!=null){
				stmt=con.createStatement();
				stmt.executeUpdate(query);	
			}
		}
		catch(Exception e){
			System.out.println("Exception :" + e);
			e.printStackTrace();		
		}
	}
}
