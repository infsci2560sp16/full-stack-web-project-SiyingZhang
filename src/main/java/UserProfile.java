/*
 * @author Siying Zhang
 * 
 * Set up user information
 */

import com.google.gson.Gson;
import java.sql.Connection;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;
import java.text.SimpleDateFormat;

public class UserProfile {

	Gson gson = new Gson();

	public UserProfile() {
		getUserProfile();
	}

	private void getUserProfile() {
		
	}

	//get("/api/")
}