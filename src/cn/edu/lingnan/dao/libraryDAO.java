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

	// 查找读者基本信息 （显示读者全部信息）
	public Vector<SelectDTO> LookAllReaderIfo() {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt.executeQuery("select * from reader"); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				SelectDTO r = new SelectDTO();
				r.setRno(rs.getString("rno"));
				r.setRname(rs.getString("rname"));
				r.setPassword(rs.getString("password"));
				r.setSuperuser(rs.getInt("superuser"));
				r.setStatus(rs.getInt("status"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection2(rs, stmt, conn);
		}
		return v;
	}
	
	//操作用户显示页面（增删查改）
	public Vector<SelectDTO> FindAllReaderIfo() {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt.executeQuery("select * from reader where status = 0"); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				SelectDTO r = new SelectDTO();
				r.setRno(rs.getString("rno"));
				r.setRname(rs.getString("rname"));
				r.setPassword(rs.getString("password"));
				r.setSuperuser(rs.getInt("superuser"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection2(rs, stmt, conn);
		}
		return v;
	}

	// 根据用户名和密码查找验证用户的信息（用户登录验证）
	public int FindReaderByUsernameAndPassword(String rname, String password) {
		int supervalue = 0;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			prep = conn
					.prepareStatement("select * from reader where rname = ? and password = ? ");
			prep.setString(1, rname);
			prep.setString(2, password);
			rs = prep.executeQuery();
			while (rs.next()) {
				supervalue = rs.getInt("superuser");
				// System.out.println("检测1-------"+supervalue);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection1(rs, prep, conn);
		}
		return supervalue;
	}

	// 注册时判断该用户名是否存在
	public boolean FindReaderByRname(String rname) {
		boolean flag = false;
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			prep = conn
					.prepareStatement("select * from reader where rname = ? ");
			prep.setString(1, rname);
			rs = prep.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection1(rs, prep, conn);
		}
		return flag;
	}

	// 往读者表插入数据（用户注册）
	public static boolean InsertRegister(SelectDTO sdto) {
		boolean flag = false;
		String rno = sdto.getRno();
		String rname = sdto.getRname();
		String password = sdto.getPassword();
		int superuser = sdto.getSuperuser();
		int status = sdto.getStatus();
		String sql = "insert into reader values" + "('" + rno + "','" + rname
				+ "','" + password + "','" + superuser + "','" + status + "')";
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DataAccess2.getConnection();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stat, conn);
		}
		return flag;
	}

	// 更新读者信息（修改读者信息）
	public static boolean UpdateReaderIfo(SelectDTO sdto) {
		boolean flag = false;
		String rno = sdto.getRno();
		String rname = sdto.getRname();
		String password = sdto.getPassword();
		int superuser = sdto.getSuperuser();
		int status = sdto.getStatus();
		String sql = "update reader set rname='" + rname + "',password='"
				+ password + "'," + "superuser='" + superuser + "',status='"
				+ status + "' where rno='" + rno + "' ";
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DataAccess2.getConnection();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stat, conn);
		}
		return flag;
	}

	// 根据rno软删除读者信息（刪除读者信息）
	public boolean DeleteReaderByRno(String rno) {
		boolean flag = false;
		Connection conn = null;
		Statement stmt = null;
		Statement stmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String returnDate1 = null; 
		int num = 0;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement();
			stmt1 = conn.createStatement();
			String sql2 = "select * from lend_return where rno = '" +rno +"'";
			rs1 = stmt1.executeQuery(sql2);
			while(rs1.next()){
				returnDate1 = rs1.getString("returnDate");
				if((returnDate1.trim()).equalsIgnoreCase("null")){
					num++;
					break;
				}
			}
			if(num == 0){
				String sql = "update reader set status = 1 where rno = '" + rno
						+ "'";
				stmt.executeUpdate(sql);
				flag = true;
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stmt, conn);
		}
		return flag;
	}

	// 查看书籍全部信息
	public Vector<SelectDTO> LookAllBookIfo() {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt.executeQuery("select * from book"); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				SelectDTO r = new SelectDTO();
				r.setNumber(rs.getString("number"));
				r.setBname(rs.getString("bname"));
				r.setAuthor(rs.getString("author"));
				r.setBookpub(rs.getString("bookpub"));
				r.setBookpubdate(rs.getString("bookpubdate"));
				r.setBooklend(rs.getString("booklend"));
				r.setStatus(rs.getInt("status"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection2(rs, stmt, conn);
		}
		return v;
	}

	// 操作书籍 显示页面（增删查改后的页面）
	public Vector<SelectDTO> FindAllBookIfo() {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt.executeQuery("select * from book where status = 0"); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				SelectDTO r = new SelectDTO();
				r.setNumber(rs.getString("number"));
				r.setBname(rs.getString("bname"));
				r.setAuthor(rs.getString("author"));
				r.setBookpub(rs.getString("bookpub"));
				r.setBookpubdate(rs.getString("bookpubdate"));
				r.setBooklend(rs.getString("booklend"));
				r.setStatus(rs.getInt("status"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection2(rs, stmt, conn);
		}
		return v;
	}

	// 更新书籍信息（修改书籍信息）
	public static boolean UpdateBookIfo(SelectDTO sdto) {
		boolean flag = false;
		String number = sdto.getNumber();
		String bname = sdto.getBname();
		String author = sdto.getAuthor();
		String bookpub = sdto.getBookpub();
		String bookpubdate = sdto.getBookpubdate();
		String booklend = sdto.getBooklend();
		int status = sdto.getStatus();
		String sql = "update book set bname='" + bname + "',author='" + author
				+ "',bookpub='" + bookpub + "',bookpubdate='" + bookpubdate
				+ "',booklend='" + booklend + "',status='" + status
				+ "' where number='" + number + "' ";
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DataAccess2.getConnection();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stat, conn);
		}
		return flag;
	}

	// 根据number软删除书籍信息（刪除读者信息）
	public Vector<SelectDTO> DeleteBookByNumber(String number) {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement();
			String sql = "update book set status = 1 where number = '" + number
					+ "'";
			stmt.executeUpdate(sql);
			String sql1 = "select * from book where status = 0";
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				SelectDTO r = new SelectDTO();
				r.setNumber(rs.getString("number"));
				r.setBname(rs.getString("bname"));
				r.setAuthor(rs.getString("author"));
				r.setBookpub(rs.getString("bookpub"));
				r.setBookpubdate(rs.getString("bookpubdate"));
				r.setBooklend(rs.getString("booklend"));
				r.setStatus(rs.getInt("status"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stmt, conn);
		}
		return v;
	}

	// 往书籍表插入数据
	public static boolean InsertBookIfo(SelectDTO sdto) {
		boolean flag = false;
		String number = sdto.getNumber();
		String bname = sdto.getBname();
		String author = sdto.getAuthor();
		String bookpub = sdto.getBookpub();
		String bookpubdate = sdto.getBookpubdate();
		String booklend = sdto.getBooklend();
		int status = sdto.getStatus();
		String sql = "insert into book values" + "('" + number + "','" + bname
				+ "','" + author + "','" + bookpub + "','" + bookpubdate
				+ "','" + booklend + "','" + status + "')";
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DataAccess2.getConnection();
			stat = conn.createStatement();
			stat.executeUpdate(sql);
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stat, conn);
		}
		return flag;
	}

	// 查找借阅记录 （显示借阅记录全部信息）
	public Vector<SelectDTO> LookLend_return() {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt
					.executeQuery("select * from lend_return"); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				SelectDTO r = new SelectDTO();
				r.setRno(rs.getString("rno"));
				r.setNumber(rs.getString("number"));
				r.setLendDate(rs.getString("lendDate"));
				r.setReturnDate(rs.getString("returnDate"));
				r.setStatus(rs.getInt("status"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection2(rs, stmt, conn);
		}
		return v;
	}

	// 操作借阅记录页面（增删改查）
	public Vector<SelectDTO> FindLend_return() {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt
					.executeQuery("select * from lend_return where status = 0"); // 执行sql语句，并将查询结果返回给ResultSet对象
			while (rs.next()) {
				SelectDTO r = new SelectDTO();
				r.setRno(rs.getString("rno"));
				r.setNumber(rs.getString("number"));
				r.setLendDate(rs.getString("lendDate"));
				r.setReturnDate(rs.getString("returnDate"));
				r.setStatus(rs.getInt("status"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection2(rs, stmt, conn);
		}
		return v;
	}

	// 更新借阅记录（修改借阅记录）
	public static boolean UpdateLend_return(SelectDTO sdto) {
		boolean flag = false;
		String rno = sdto.getRno();
		String number = sdto.getNumber();
		String lendDate = sdto.getLendDate();
		String returnDate = sdto.getReturnDate();
		int status = sdto.getStatus();
		String a = null;
		String b = null;
		String c = null;
		Connection conn = null;
		Statement stat = null;
		Statement stat1 = null;
		Statement stat2 = null;
		Statement stat3 = null;
		Statement stat4 = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stat = conn.createStatement();
			stat1 = conn.createStatement();
			stat2 = conn.createStatement();
			stat3 = conn.createStatement();
			stat4 = conn.createStatement();
			String sql = "update lend_return set lendDate='" + lendDate
					+ "',returnDate='" + returnDate + "',status='" + status
					+ "' where rno='" + rno + "' and number='" + number + "' ";
			stat.executeUpdate(sql);

			String sql1 = "select * from lend_return where rno='" + rno
					+ "' and number='" + number + "' and lendDate='" + lendDate
					+ "'";
			rs = stat1.executeQuery(sql1);
			while (rs.next()) {
				a = rs.getString("lendDate");
				b = rs.getString("returnDate");
				c = rs.getString("number");
				System.out.println(a);
				System.out.println(b);
				System.out.println(c);
				if (!a.equalsIgnoreCase("null")) {
					if (b.equalsIgnoreCase("null")) {
						String sql2 = "update book set booklend = 'N' where number = '"
								+ c + "' ";
						stat2.executeUpdate(sql2);
					} else {
						String sql3 = "update book set booklend = 'Y' where number = '"
								+ c + "' ";
						stat3.executeUpdate(sql3);
					}

				} else {
					String sql4 = "update book set booklend = 'Y' where number = '"
							+ c + "' ";
					stat4.executeUpdate(sql4);
				}
			}
			flag = true;
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stat, conn);
		}
		return flag;
	}

	// 插入借阅记录
	public static boolean InsertLend_return(SelectDTO sdto) {
		boolean flag = false;
		String a = null;
		String c = null;
		String d = null;
		String rno = sdto.getRno();
		String number = sdto.getNumber();
		String lendDate = sdto.getLendDate();
		String returnDate = sdto.getReturnDate();
		int status = sdto.getStatus();
		Connection conn = null;
		Statement stat = null;
		Statement stat1 = null;
		Statement stat2 = null;
		Statement stat3 = null;
		Statement stat4 = null;
		Statement stat5 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		try {
			conn = DataAccess2.getConnection();
			stat = conn.createStatement();
			stat1 = conn.createStatement();
			stat2 = conn.createStatement();
			stat3 = conn.createStatement();
			stat4 = conn.createStatement();
			stat5 = conn.createStatement();
			String sql = "select * from book where number = '" + number + "'";
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				a = rs.getString("booklend");
				System.out.println(a);
				if (a.equalsIgnoreCase("Y")) {
					String sql1 = "insert into lend_return values" + "('" + rno
							+ "','" + number + "','" + lendDate + "','"
							+ returnDate + "','" + status + "')";
					stat1.executeUpdate(sql1);
					String sql2 = "select * from lend_return where rno='" + rno
							+ "' and number='" + number + "' and lendDate='"
							+ lendDate + "'";
					rs1 = stat2.executeQuery(sql2);
					while (rs1.next()) {
						c = rs1.getString("returnDate");
						d = rs1.getString("number");
						System.out.println(c);
						System.out.println(d);
							if (c.equalsIgnoreCase("null")) {
								String sql3 = "update book set booklend = 'N' where number = '"
										+ d + "' ";
								stat3.executeUpdate(sql3);
							} else {
								String sql4 = "update book set booklend = 'Y' where number = '"
										+ d + "' ";
								stat4.executeUpdate(sql4);
							}						
					}
					flag = true;
				} else if (a.equalsIgnoreCase("N")) {
					flag = false;
					
				}				
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stat, conn);
		}
		return flag;
	}

	// 软删除借阅记录
	public Vector<SelectDTO> DeleteLend_return(String rno, String number,
			String lendDate) {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement();
			String sql = " update lend_return set status = 1 where rno = '"
					+ rno + "' and number = '" + number + "' and lendDate = '"
					+ lendDate + "' ";
			stmt.executeUpdate(sql);
			String sql1 = "select * from lend_return where status = 0";
			rs = stmt.executeQuery(sql1);
			while (rs.next()) {
				SelectDTO r = new SelectDTO();
				r.setRno(rs.getString("rno"));
				r.setNumber(rs.getString("number"));
				r.setLendDate(rs.getString("lendDate"));
				r.setReturnDate(rs.getString("returnDate"));
				r.setStatus(rs.getInt("status"));
				v.add(r);
			}
		} catch (SQLException e) {
			System.out.println("运行sql语句时出现错误");
			e.printStackTrace();
		} finally {
			DataAccess2.CloseConnection3(stmt, conn);
		}
		return v;
	}
}
