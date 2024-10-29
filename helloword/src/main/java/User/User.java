package User;

import java.util.Date;

public class User {
	private boolean sex;
	private String email, name, locate, phone;
	private Date BoD;
	private String[] KoT;
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}
	public boolean isSex() {
		return sex;
	}
	public Date getBoD() {
		return BoD;
	}
	public void setBoD(Date boD) {
		BoD = boD;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public String[] getKoT() {
		return KoT;
	}
	public void setKoT(String[] koT) {
		KoT = koT;
	}
	
	public User(boolean sex, String email, String name, String locate, String phone, Date boD,
			String[] koT) {
		super();
		this.sex = sex;
		this.email = email;
		this.name = name;
		this.locate = locate;
		this.phone = phone;
		BoD = boD;
		KoT = koT;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
