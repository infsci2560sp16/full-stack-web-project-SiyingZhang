package service;

import bean.User;

import com.google.gson.Gson;

import dao.UserDao;
import utils.ServiceUtils;
import spark.ModelAndView;
import spark.Session;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.HashMap;
import java.util.UUID;

import static spark.Spark.*;

/**
 * @author siying
 */

class UserService {

    private Gson gson = new Gson();
    private UserDao ud = new UserDao();
    private ServiceUtils su = new ServiceUtils();
    private String tempUserName = "tempUserName";

    /**
     * Membership service response to requests handling register, login and logout.
     */
    UserService() {
        super();
        this.startServe();
    }

    private void startServe() {
        // registration process.
        // front end will stay on the same page if user notExist = false, or redirect to /index if user notExist = true.
        post("/register", (request, response) -> {

            HashMap<String, Object> attributes = new HashMap<>();
            String userName = request.queryParams("userName");
            String userEmail = request.queryParams("userEmail");
            String password = request.queryParams("password");
            attributes.put("userName", userName);
            attributes.put("userEmail", userEmail);
            tempUserName = userName;

            System.out.println(userName + ", " + userEmail);

            try {
                if (this.checkNotExist(userEmail)) {
                    User u = new User(userEmail, password, userName, UUID.randomUUID());
                    ud.insertUser(u);
                    System.out.println(this.getClass() + ": User " + userEmail + " registered successfully.");
                    attributes.put("notExist", true);
                    attributes.put("status", "Registration succeeded, Redirecting page...");
                } else {
                    System.out.println(this.getClass() + ": User " + userEmail + " exists.");
                    attributes.put("notExist", false);
                    attributes.put("status", "Email has been registered, pleas use other ones.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                attributes.put("status", "Server Error. One more try, please.");
            }
            return gson.toJson(attributes);
        });

        // redirecting to index page.
        /*
        get("/", (request, response) -> {
            HashMap<String, Object> attributes = new HashMap<>();
            Session session = request.session(true);
            if (su.hasUserLoggedIn(request, response)) {
                User u = (User) session.attribute("user");
                u.setUsername(tempUserName);
                attributes.put("user", u);
            }
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());*/
        //main page 
        get("/", (request, response) -> {
            HashMap<String, Object> attributes = new HashMap<>();
            attributes.put("message", "Wordrumb - Help you memorize unfamiliar words!");

            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        
        get("/index", (request, response) -> {
            HashMap<String, Object> attributes = new HashMap<>();
            Session session = request.session(true);
            if (su.hasUserLoggedIn(request, response)) {
                User u = (User) session.attribute("user");
                u.setUsername(tempUserName);
                attributes.put("user", u);
            }
            return new ModelAndView(attributes, "index.ftl");
        }, new FreeMarkerEngine());

        // login, add user object to session.
        get("/login", (request, response) -> {
            HashMap<String, Object> attributes = new HashMap<>();
            Session session = request.session(true);
            String userAccount = request.queryParams("userAccount");
            String password = request.queryParams("password");

            User u = null;
            try {
                u = ud.selectByUserEmail(userAccount, password);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (u != null) {
                session.attribute("user", u);
            } else {
                // TODO: user does not exist.
            }
            attributes.put("status", "Sign in succeeded, Redirecting page...");
            return gson.toJson(attributes);
        });

        // return the id of the logged user.
        get("/loggedUserId", (request, response) -> {
            HashMap<String, Object> attributes = new HashMap<>();
            Session session = request.session(true);
            if (session.attribute("user") != null) {
                attributes.put("userId", ((User) session.attribute("user")).getUserId());
                System.out.println(attributes.get("userId"));
            }
            return gson.toJson(attributes);
        });

        get("/logout", (request, response) -> {
            Session session = request.session();
            if (su.hasUserLoggedIn(request, response)) {
                session.removeAttribute("user");
                System.out.println("Removed.");
            }
            response.status(200);
            return "success";
        });
    }

    private boolean checkNotExist(String userAccount) {
        boolean notExist = true;
        try {
            notExist = ud.notExist(userAccount);
        } catch (Exception e) {
            System.out.println(this.getClass() + ".checkExistence()");
            e.printStackTrace();
        }
        return notExist;
    }

}
