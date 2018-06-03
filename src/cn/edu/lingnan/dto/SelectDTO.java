package cn.edu.lingnan.dto;

public class SelectDTO {
	private String rno;
	private String rname;
	private String password;
	private int superuser;
	private String number;
	private String bname;
	private String author;
	private String bookpub;
	private String bookpubdate;
	private String booklend;
	private int status;
	
	

	public String getRno() {
		return rno;
	}

	public void setRno(String rno) {
		this.rno = rno;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getSuperuser() {
		return superuser;
	}

	public void setSuperuser(int superuser) {
		this.superuser = superuser;
	}
	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookpub() {
		return bookpub;
	}

	public void setBookpub(String bookpub) {
		this.bookpub = bookpub;
	}

	public String getBookpubdate() {
		return bookpubdate;
	}

	public void setBookpubdate(String bookpubdate) {
		this.bookpubdate = bookpubdate;
	}

	public String getBooklend() {
		return booklend;
	}

	public void setBooklend(String book_lend) {
		this.booklend = book_lend;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


	

}
