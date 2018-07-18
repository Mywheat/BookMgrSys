package cn.edu.lingnan.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import cn.edu.lingnan.dto.SelectDTO;
import cn.edu.lingnan.tools.DataAccess2;

import com.mysql.jdbc.Connection;

public class AuthorityDao {

	// 普通用户查看书籍信息
	public Vector<SelectDTO> LookAllBookIfo1() {
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

	// 根据用户名和密码查找普通用户的个人信息
	public Vector<SelectDTO> FindReaderByUsernameAndPassword(String rname,
			String password) {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
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
			DataAccess2.CloseConnection1(rs, prep, conn);
		}
		return v;
	}

	// 修改普通用户信息
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

	// 根据用户编号查找普通用户的个人信息
	public Vector<SelectDTO> FindAuthorityByRno(String rno) {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			prep = conn.prepareStatement("select * from reader where rno = ?");
			prep.setString(1, rno);
			rs = prep.executeQuery();
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
			DataAccess2.CloseConnection1(rs, prep, conn);
		}
		return v;
	}

	// 插入借书记录
	public static boolean InsertLendBook(SelectDTO sdto) {
		boolean flag = false;
		String a = null;
		String b = null;
		String c = null;
		String d = null;
		String rno = sdto.getRno();
		String number = sdto.getNumber();
		String lendDate = sdto.getLendDate();
		String returnDate = sdto.getReturnDate();
		int status = sdto.getStatus();
		 System.out.println("检测:" + rno + " " + number + " " + lendDate + " "
		 + returnDate + " " + status);
		Connection conn = null;
		Statement stat = null;
		Statement stat1 = null;
		Statement stat2 = null;
		Statement stat3 = null;
		Statement stat4 = null;
		Statement stat5 = null;
		Statement stat6 = null;
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
			stat6 = conn.createStatement();
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
						b = rs1.getString("lendDate");
						c = rs1.getString("returnDate");
						d = rs1.getString("number");
						System.out.println(b);
						System.out.println(c);
						System.out.println(d);
						if (!b.equalsIgnoreCase("null")) {
							if (c.equalsIgnoreCase("null")) {
								String sql3 = "update book set booklend = 'N' where number = '"
										+ d + "' ";
								stat4.executeUpdate(sql3);
							} else {
								String sql4 = "update book set booklend = 'Y' where number = '"
										+ d + "' ";
								stat5.executeUpdate(sql4);
							}

						} else {
							String sql5 = "update book set booklend = 'Y' where number = '"
									+ d + "' ";
							stat6.executeUpdate(sql5);
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

	// 查找借书记录
	public Vector<SelectDTO> FindLendBook(SelectDTO sdto) {
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		String rno = sdto.getRno();
		String number = sdto.getNumber();
		String lendDate = sdto.getLendDate();
		String returnDate = sdto.getReturnDate();
		int status = sdto.getStatus();
		System.out.println("1. " + rno + " " + number + " " + lendDate + " "
				+ returnDate + " " + status);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement(); // 创建sql语句对象
			rs = stmt.executeQuery("select * from lend_return where rno='"
					+ rno + "' and status = 0");
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

	// 还书之后软删除记录
	public Vector<SelectDTO> DeleteLend_return(String rno, String number,
			String lendDate) {
		Date day=new Date();    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
//		System.out.println(df.format(day));   
		String ReturnDate = df.format(day);
		Vector<SelectDTO> v = new Vector<SelectDTO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DataAccess2.getConnection();
			stmt = conn.createStatement();
			
			String sql = " update lend_return set status = 1,ReturnDate = '"+ReturnDate+"' where rno = '"
					+ rno + "' and number = '" + number + "' and lendDate = '"
					+ lendDate + "' ";
			stmt.executeUpdate(sql);
			
			String sql2 = "update book set bookLend = 'Y' where number = '"+number+"'";
			stmt.executeUpdate(sql2);
			
			String sql1 = "select * from lend_return where status = 1 and rno = '"+rno+"'";
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
	
	// 查找还书记录
		public Vector<SelectDTO> FindReturnBook(String rno) {
			Vector<SelectDTO> v = new Vector<SelectDTO>();
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				conn = DataAccess2.getConnection();
				stmt = conn.createStatement(); // 创建sql语句对象
				rs = stmt.executeQuery("select * from lend_return where rno='"
						+ rno + "' and status = 1");
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

}
