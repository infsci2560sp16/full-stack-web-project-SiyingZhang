import java.util.ArrayList;
import java.util.List;

/*
 * @author Siying Zhang
 * 
 * user information
 */

public class User {
	private String username;
	private String password;
	private String useremail;
	private List<User> friends;

	public User() {
		friends = new ArrayList<User>();
	}

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

	public List<User> getFriendsList() {
		return this.friends;
	}

	public void setFriend(User user) {
		this.friends.add(user);
	}
}