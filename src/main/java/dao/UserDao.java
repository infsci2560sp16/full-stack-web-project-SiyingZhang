package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import bean.User;

/*
 * @author Siying
 * Data Access Object
 */

public class UserDao {
	private Date date = new Date();

	public void insertUser(User u) throws Exception {
		Connection connection = null;	//TODO: connect to database

		try{
			//Insert user's data to database
		} catch (Exception e) {
			throw new Exception(this.getClass() + ".addUser: Database failure.");
		} finally {
			if(connection != null)
				try{
					connection.close();
				} catch (SQLException e) {
					System.out.println(this.getClass());
				}
		}
	}

	public boolean notExist(String userAccount) throws Exception {

		Connection connection = null;
		try{
			//TODO: DB query
		} catch (Exception e) {
			throw new Exception(this.getClass() + ".notExist: database failure.");
		} finally {
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println(this.getClass() + ".notExist: Could not close the database");
				}
		}
		return System.currentTimeMillis() % 9 !=0;
	}

	//By user email.
	public User selectByUserEmail(String userEmail, String password) throws Exception {
		Connection connection = null;
		User u = null;
		try {
			//TODO: select user by user email from database
			String userName = "";
			UUID userId = UUID.randomUUID();
			u = new User(userEmail, userName, password, userId);
			return date.getTime() % 9 == 0 ? null:u;
		} catch (Exception e) {
			throw new Exception(this.getClass() + ".selectUserByEmail: database failure.");
		} finally {
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println(this.getClass() + ".selectUserByEmail: Could not close the database");
				}
		}
	}

	//By user Id
	public User selectByUserId(UUID userId, String password) throws Exception {
		Connection connection = null;
		User u = null;
		try {
			//TODO: select user by userId
			String userName = "";
			String userEmail = "";
			u = new User(userEmail, userName, password, userId);
			return date.getTime() % 9 == 0? null:u;
		} catch (Exception e) {
			throw new Exception(this.getClass() + ".selectUserById: database failure.");
		} finally {
			if(connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
					System.out.println(this.getClass() + ".selectUserById: Could not close the database");
				}
		}
	}

}