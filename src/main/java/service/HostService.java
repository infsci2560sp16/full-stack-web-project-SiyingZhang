package service;

import com.heroku.sdk.jdbc.DatabaseUrl;

import org.jscience.physics.amount.Amount;
import org.jscience.physics.model.RelativisticModel;

import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import task1.DeleteStringSolution;

import javax.measure.quantity.Mass;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static javax.measure.unit.SI.KILOGRAM;
import static spark.Spark.get;
import static spark.SparkBase.port;
import static spark.SparkBase.staticFileLocation;

/**
 * 
 * Modified by Siying
 */
public class HostService {
    public static void main(String[] args) {

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");

        Task1Service ts = new Task1Service();
        UserService us = new UserService();
        ReviewService gs = new ReviewService();
        
    }
}