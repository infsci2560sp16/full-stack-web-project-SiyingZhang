package bean;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

/*
 * @author Siying Zhang
 * 
 * user information
 */

public class User {
	private final UUID userId;
	private String userEmail;	
	private String userName;
	private Long registration; //Registration time in milliseconds

	private String password;
	private String registrationString;

	//friends 
	private Integer followerCount;
	private Integer followingCount;

	private ArrayList<UUID> wordsList;
	private ArrayList<UUID> favorites;	//favorite words

	public User(String userEmail, String userName, String password, UUID userId) {
		super();

		Date date = new Date();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userName = userName;
		this.password = password;
		registration = System.currentTimeMillis();

		String d = new Date(this.registration).toString();
		this.registrationString = d.substring(4, 11) + "." + d.substring(24);
	}

	//get
	public UUID getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getUseremail() {
		return this.userEmail;
	}

	public String getUsername() {
		return this.userName;
	}

	public Long getRegistration() {
		return this.registration;
	}

	public void setUsername(String name) {
		this.userName = name;
	}

	public void setPassword(String pw) {
		this.password = pw;
	}

	public void setUseremail(String email) {
		this.userEmail = email;
	}

	public void setRegistration(Long registration) {
		this.registration = registration;
	}

	//Add and reduce followers/followings
    public void addFollower(int number) {
        this.followerCount += number;
    }

    public void reduceFollower(int number) {
        this.followerCount -= number;
    }

    public void addFollowing(int number) {
        this.followingCount += number;
    }

    public void reduceFollowing(int number) {
        this.followingCount -= number;
    }

    //Words list
    public void addWord(UUID wordId) {
    	this.wordsList.add(wordId);
    }

    public void deleteWord(UUID wordId) {
    	this.wordsList.remove(wordId);
    }

    public boolean containWord(UUID wordId) {
    	return this.wordsList.contains(wordId);
    }

    //Favorite words
    public void addFavorite(UUID wordId) {
    	this.favorites.add(wordId);
    }

    public void deleteFavorite(UUID wordId) {
    	this.favorites.remove(wordId);
    }

    public boolean containFavorite(UUID wordId) {
    	return this.favorites.contains(wordId);
    }
    
    public ArrayList<UUID> getWordsList() {
    	return this.wordsList;
    }
}