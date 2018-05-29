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
			Class.forName(driver);  // ע����������
			conn = (Connection) DriverManager.getConnection(url,userName,password);   //��ȡ���ݿ������				
		} catch (ClassNotFoundException e) {
			System.out.println("Mysql�����������Ҳ���ร�������Ӧ��jar����û�м���");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("��ȡ���ݿ�����ʱsql�����ִ���");
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
        		System.out.println("�ر�������估�����ʱ���ִ���");		
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
        		System.out.println("�ر�������估�����ʱ���ִ���");		
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
        		System.out.println("�ر�������估�����ʱ���ִ���");		
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
        		System.out.println("�ر�������估�����ʱ���ִ���");		
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
        		System.out.println("�ر�������估�����ʱ���ִ���");		
                e.printStackTrace();
                } 
	}

}
