package cn.qiyuan;

public class User {
	String username;
	String password;
	String title;
	public User(String string, String string2) {
		// TODO Auto-generated constructor stub
		this.username=string;
		this.password=string2;
	}

	public User(String string, String string2,String title) {
		// TODO Auto-generated constructor stub
		this.username=string;
		this.password=string2;
		this.title=title;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
