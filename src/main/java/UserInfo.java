/*
 * @author Siying Zhang
 * 
 * user name & password
 */

public class UserInfo {
	private String username;
	private String password;
	private String useremail;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUsername(String name) {
		this.username = name;
	}

	public void setPassword(String pw) {
		this.password = pw;
	}

	public void setUseremail(String email) {
		this.useremail = email;
	}
}