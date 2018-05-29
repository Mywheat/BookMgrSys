package cn.edu.lingnan.tools;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class DataAccess2 {

	private static Connection conn = null;
	private static String driver = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/library";
	private static String userName = "root";
	private static String password = "666666";
	
	public static Connection getConnection()
	{
		try {
			Class.forName(driver);  // 注册驱动程序
			conn = (Connection) DriverManager.getConnection(url,userName,password);   //获取数据库的连接				
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql的驱动程序找不到喔，看看对应的jar包有没有加载");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("获取数据库连接时sql语句出现错误");
			e.printStackTrace();
		}
	return conn;
	}
	
	
	public static void CloseConnection(ResultSet rs,Statement stmt,PreparedStatement prep,Connection conn)
	{
		try {
			if(rs!=null){
		       rs.close();
		       rs=null;
	            }
        	if(prep!=null){
	           prep.close();
	           prep=null;
                }
        	if(stmt!=null){
        		stmt.close();
        		stmt=null;
	            }
        	if(conn!=null){
        		conn.close();
        		conn=null;
        	    } 
        	} catch (SQLException e) {
        		System.out.println("关闭连接语句及结果集时出现错误");		
                e.printStackTrace();
                } 
	}
	
	public static void CloseConnection1(ResultSet rs,PreparedStatement prep,Connection conn)
	{
		try {
			if(rs!=null){
		       rs.close();
		       rs=null;
	            }
        	if(prep!=null){
        		prep.close();
        		prep=null;
	            }
        	if(conn!=null){
        		conn.close();
        		conn=null;
        	    } 
        	} catch (SQLException e) {
        		System.out.println("关闭连接语句及结果集时出现错误");		
                e.printStackTrace();
                } 
	}
	
	public static void CloseConnection2(ResultSet rs,Statement stmt,Connection conn)
	{
		try {
			if(rs!=null){
		       rs.close();
		       rs=null;
	            }
        	if(stmt!=null){
        		stmt.close();
        		stmt=null;
	            }
        	if(conn!=null){
        		conn.close();
        		conn=null;
        	    } 
        	} catch (SQLException e) {
        		System.out.println("关闭连接语句及结果集时出现错误");		
                e.printStackTrace();
                } 
	}
	
	public static void CloseConnection3(Statement stmt,Connection conn)
	{
		try {
        	if(stmt!=null){
        		stmt.close();
        		stmt=null;
	            }
        	if(conn!=null){
        		conn.close();
        		conn=null;
        	    } 
        	} catch (SQLException e) {
        		System.out.println("关闭连接语句及结果集时出现错误");		
                e.printStackTrace();
                } 
	}
	
	public static void CloseConnection4(PreparedStatement prep,Connection conn)
	{
		try {
        	if(prep!=null){
        		prep.close();
        		prep=null;
	            }
        	if(conn!=null){
        		conn.close();
        		conn=null;
        	    } 
        	} catch (SQLException e) {
        		System.out.println("关闭连接语句及结果集时出现错误");		
                e.printStackTrace();
                } 
	}

}
