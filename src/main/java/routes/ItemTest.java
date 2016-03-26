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

    get("/itemdetails", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
            List<String> sizeList = new ArrayList<>();
            sizeList.add("Small");
            sizeList.add("Medium");
            sizeList.add("Large");
            sizeList.add("XLarge");
            attributes.put("itemName", "BETA AR JACKET MEN'S");
            attributes.put("itemBrand", "ARC'TERYX");
            attributes.put("itemCategory", "Shell Jackets");
            attributes.put("itemPrice", "$549");
            attributes.put("itemRating","4.3/5.0");
            attributes.put("itemColor","Black/BlackBlue/DarkRed");
            attributes.put("itemId","0001-001");
            attributes.put("itemSize", sizeList);


            return new ModelAndView(attributes, "itemdetails.ftl");
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
