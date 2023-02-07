package com.usmanIndia;

import java.sql.*;
import java.util.ArrayList;

public class Student {
	private static String url="jdbc:mysql://localhost:3306/palle";
	private static String username="root";
	private static String password="admin";
	
	private static Connection con=null;
	private static Statement s=null;
	private static PreparedStatement ps=null;
	private static ResultSet rs=null;
	
	public static void creating() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			s=con.createStatement();
			s.executeUpdate("create table student"
					+ "(sno int primary key auto_increment,sname varchar(40)"
					+ ",sub varchar(40),email varchar(40))");
			s.close();
			con.close();
		} 
		catch (ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void inserting (String sname, String sub,String email) 
	{
		 try 
		 {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("insert into student(sname,sub,email) values(?,?,?)");
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.executeUpdate();
			
		}
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
				try 
				{
					if(ps !=null) {
					ps.close();
					}
					if(con !=null) {
						con.close();
					}
				} 
					catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		

		}
	
	public static void updating(int sno,String sname,String sub,String email) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("update student set sname=?, sub =? ,email=? where sno= ? ");
			ps.setString(1, sname);
			ps.setString(2, sub);
			ps.setString(3, email);
			ps.setInt(4, sno);
		
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally 
		{
			try 
			{
				if(ps !=null) {
					ps.close();
				}
				if(con !=null) {
					con.close();
				}
			} 
			catch (SQLException e2) 
			{
				// TODO: handle exception
			}
		}
	}
	public static void deleting(int sno) 
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			ps=con.prepareStatement("delete from student where sno= ? ");
			ps.setInt(1, sno);
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		finally 
		{
			try 
			{
				if(ps !=null) {
					ps.close();
				}
				if(con !=null) {
					con.close();
				}
			} 
			catch (SQLException e2) 
			{
				// TODO: handle exception
			}
		}
	}
	public static void read() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			s=con.createStatement();
			rs=s.executeQuery("select * from student");
			while(rs.next()) {
				System.out.println(rs.getInt("sno"));
				System.out.println(rs.getString("sname"));
				System.out.println(rs.getString("sub"));
				System.out.println(rs.getString("email"));
			}
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs !=null) {
					rs.close();
				}
				if(s !=null) {
					s.close();
				}
				if(con !=null) {
					con.close();
				}	
			}
			catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	public static ArrayList<Std> reading() {
		ArrayList<Std> as= new ArrayList<Std>();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, username, password);
			s=con.createStatement();
			rs=s.executeQuery("select * from student");
			while(rs.next()) {
				int i=rs.getInt("sno");
				String n=rs.getString("sname");
				String s=rs.getString("sub");
				String e=rs.getString("email");
				Std st=new Std(i, n, s, e);
				as.add(st);
				
			}
		}
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs !=null) {
					rs.close();
				}
				if(s !=null) {
					s.close();
				}
				if(con !=null) {
					con.close();
				}	
			}
			catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return as;
		
	}

}
