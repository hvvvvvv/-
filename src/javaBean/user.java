package javaBean;


public class user {
	private String username;
	private String password;
	public user(String string, String string2) {
		// TODO �Զ����ɵĹ��캯�����
		username=string;
		password=string2;
	}
	public user() {
		// TODO �Զ����ɵĹ��캯�����
	}
	public String getUsername() {
		return username;
	}
	public  void  setUsername(String username) {
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public  void  setPassword(String password) {
		this.password=password;
	}
	}
