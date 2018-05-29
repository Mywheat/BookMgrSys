package cn.edu.lingnan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

import cn.edu.lingnan.dto.SelectDTO;
import cn.edu.lingnan.tools.DataAccess2;

import com.mysql.jdbc.Connection;

public class libraryDAO {

//���Ҷ��߻�����Ϣ	����ʾ����ȫ����Ϣ��
	public Vector<SelectDTO> FindAllReaderIfo() {	
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement();    //����sql������
			rs = stmt.executeQuery("select * from reader where status = 0");   //ִ��sql��䣬������ѯ������ظ�ResultSet����
			while(rs.next())
			{
				SelectDTO r = new SelectDTO();
				r.setRno(rs.getString("rno"));
				r.setRname(rs.getString("rname"));
				r.setPassword(rs.getString("password"));
				r.setSuperuser(rs.getInt("superuser"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
			DataAccess2.CloseConnection2(rs, stmt, conn);	
		}
    return v;	    
	}

	
//�����û��������������֤�û�����Ϣ���û���¼��֤��
	public int FindReaderByUsernameAndPassword(String rname,String password)
	{
		int supervalue = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			prep = conn.prepareStatement
					("select * from reader where rname = ? and password = ? ");
			prep.setString(1, rname);
			prep.setString(2, password);
			rs = prep.executeQuery();
			if(rs.next())
			{
				supervalue = rs.getInt("superuser");
//				System.out.println("���1-------"+supervalue);
			}		
		} catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
			DataAccess2.CloseConnection1(rs,prep,conn);	
		}
    return supervalue;	    				
	}

			
//�����߱�������ݣ��û�ע�ᣩ
	public static boolean InsertRegister(SelectDTO sdto){
		boolean flag = false;
		String rno = sdto.getRno();
		String rname = sdto.getRname();
		String password = sdto.getPassword();
		int superuser = sdto.getSuperuser();
		int status = sdto.getStatus();
		String sql = "insert into Reader values"
				+ "('"+rno+"','"+rname+"','"+password+"','"+superuser+"','"+status+"')";		
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DataAccess2.getConnection();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stat, conn);
		}
	return flag; 
    }

	
//���¶�����Ϣ���޸Ķ�����Ϣ��
	public static boolean UpdateReaderIfo(SelectDTO sdto){
		boolean flag = false;
		String rno = sdto.getRno();
		String rname = sdto.getRname();
		String password = sdto.getPassword();
		int superuser = sdto.getSuperuser();
		int status = sdto.getStatus();
		String sql = "update reader set rname='"+rname+"',password='"+password+"',"
				+ "superuser='"+superuser+"',status='"+status+"' where rno='"+rno+"' ";		
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DataAccess2.getConnection();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stat, conn);
		}
	return flag; 
    }	


//����rno��ɾ��������Ϣ���h��������Ϣ��
	public Vector<SelectDTO> DeleteReaderByRno(String rno){
	Vector<SelectDTO> v = new Vector<SelectDTO>();
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	try {
		conn = DataAccess2.getConnection();
		stmt = conn.createStatement();
		String sql = "update reader set status = 1 where rno = '"+rno+"'";
		stmt.executeUpdate(sql);
		String sql1 = "select * from reader where status = 0";
		rs = stmt.executeQuery(sql1);
		while(rs.next())
		{
			SelectDTO r = new SelectDTO();
			r.setRno(rs.getString("rno"));
			r.setRname(rs.getString("rname"));
			r.setPassword(rs.getString("password"));
			r.setSuperuser(rs.getInt("superuser"));
			r.setStatus(rs.getInt("status"));
			v.add(r);			
		}
	} catch (SQLException e) {
		System.out.println("����sql���ʱ���ִ���");
			e.printStackTrace();
		}finally{
			DataAccess2.CloseConnection3(stmt, conn);
			}
	return v;
    }	
	
	
}
