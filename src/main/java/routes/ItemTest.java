package routes;

import java.sql.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;


import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class ItemTest {

  public ItemTest() {
    setupRoutes();
  }

  private void setupRoutes() {

    get("/item", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            attributes.put("title", "Shopping cart");
            attributes.put("itemName", "Nike shoes");
            attributes.put("itemCount", "1");

            return new ModelAndView(attributes, "item.ftl");
        }, new FreeMarkerEngine());


    get("/db.html", (req, res) -> {
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