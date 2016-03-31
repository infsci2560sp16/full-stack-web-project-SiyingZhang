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
      String username = req.queryParams("login-username");
      String password = req.queryParams("login-password");

      attributes.put("login-username", username);
      attributes.put("login-password", password);

      return new ModelAndView(attributes, "login_action.ftl");
    }, new FreeMarkerEngine());

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
