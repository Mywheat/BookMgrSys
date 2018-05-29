package cn.edu.lingnan.dto;

public class SelectDTO {
	private String rno;
	private String rname;
	private int status;
	private String ISBN;
	private String bname;
	private int superuser;
	private String password;

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

	public int getSuperuser() {
		return superuser;
	}

	public void setSuperuser(int superuser) {
		this.superuser = superuser;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
