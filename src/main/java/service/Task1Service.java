package service;

import task1.DeleteStringSolution;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

class Task1Service{

	public Task1Service() {
		super();
		this.startServer();
	}

	private void startServer() {
	    //Task 1: Delete the substring
	    get("/task1", (req, res) -> {
	    	Map<String, Object> attributes = new HashMap<>();
	    	attributes.put("message", "To find out how many substrings there.");

	    	return new ModelAndView(attributes, "task1.ftl");
	    }, new FreeMarkerEngine());
	    
	    DeleteStringSolution solution = new DeleteStringSolution();
	    get("/task1_workout", (req, res) -> {
	      Map<String, Object> attributes = new HashMap<>();
	      String string1 = req.queryParams("string1");
	      String substring = req.queryParams("substring");

	      int count = solution.deleteSubstring(string1, substring);

	      attributes.put("string1", string1);
	      attributes.put("count", count);
	      attributes.put("substring", substring);

	      return new ModelAndView(attributes, "task1_workout.ftl");
	    }, new FreeMarkerEngine());
	}



}