import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.net.URI;
import java.net.URISyntaxException;


import static spark.Spark.*;
import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;


import com.heroku.sdk.jdbc.DatabaseUrl;


import edu.pitt.siying.servertest.DeleteStringSolution;
import freemarker.core.ReturnInstruction.Return;
import static javax.measure.unit.SI.KILOGRAM;


import javax.measure.quantity.Mass;


import javolution.util.Index;


import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    //main page 
    get("/", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Wordrumb - Help you memorize unfamiliar words!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());
    
    //login page
    get("/login", (req, res) -> {
    	Map<String, Object> attributes = new HashMap<>();
      attributes.put("message", "Wordrumb - Login/out");

    	return new ModelAndView(attributes, "login.ftl");
    }, new FreeMarkerEngine());
    
    //login action page
    get("/login_action", (req, res) -> {
      Map<String, Object> attributes = new HashMap<>();
      String login_username = req.queryParams("login_username");
      String login_password = req.queryParams("login_password");

      attributes.put("message", "login action test page.");
      attributes.put("login_username", login_username);
      attributes.put("login_password", login_password);

      return new ModelAndView(attributes, "login_action.ftl");
    }, new FreeMarkerEngine());

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

    //Database operation
    get("/db", (req, res) -> {
      Connection connection = null;
      Map<String, Object> attributes = new HashMap<>();
      try {
        connection = DatabaseUrl.extract().getConnection();

        Statement stmt = connection.createStatement();
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
        stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
        ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

        ArrayList<String> output = new ArrayList<String>();
        while (rs.next()) {
          output.add( "Read from DB: " + rs.getTimestamp("tick"));
        }

        attributes.put("results", output);
        return new ModelAndView(attributes, "db.ftl");
      } catch (Exception e) {
        attributes.put("message", "There was an error: " + e);
        return new ModelAndView(attributes, "error.ftl");
      } finally {
        if (connection != null) try{connection.close();} catch(SQLException e){}
      }
    }, new FreeMarkerEngine());

  }

}
