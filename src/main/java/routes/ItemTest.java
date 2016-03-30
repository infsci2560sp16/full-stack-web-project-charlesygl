package routes;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;

import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;

import com.google.gson.Gson;
import com.heroku.sdk.jdbc.DatabaseUrl;
import itemservices.*;
import itemdetails.*;

public class ItemTest {

  public ItemTest() {
    setupRoutes();
  }
  
  Gson gson = new Gson();

  private void setupRoutes() {

    get("/itemdetails", (request, response) -> {
            Map<String, Object> attributes = new HashMap<>();
//            List<String> sizeList = new ArrayList<>();
//            sizeList.add("Small");
//            sizeList.add("Medium");
//            sizeList.add("Large");
//            sizeList.add("XLarge");
            attributes.put("itemName", "BETA AR JACKET MEN'S");
            attributes.put("itemBrand", "ARC'TERYX");
            attributes.put("itemCategory", "Shell Jackets");
            attributes.put("itemPrice", "$549");
            attributes.put("itemRating","4.3");
            attributes.put("itemColor","Black/BlackBlue/DarkRed");
            attributes.put("itemId","0001-001");
            //attributes.put("itemSize", sizeList);
            return new ModelAndView(attributes, "itemdetails.ftl");
        }, new FreeMarkerEngine());
    
    get("/itemtest", (request, response) -> {
        Map<String, Object> attributes = new HashMap<>();
        ItemService itemService = new ItemService();
        attributes.put("whatever", itemService.getAllItems());
        return new ModelAndView(attributes, "itemtest.ftl");
    }, new FreeMarkerEngine());
    
    get("/itemtestjson", (req, res) -> {
    	Map<String, Object> attributes = new HashMap<>();
        ItemService itemService = new ItemService();
        return itemService.getItems();
    }, gson::toJson);
    
    get("/readDBHeroku",(request, response) ->{
		Map<String,Object> attributes = new HashMap<>();
		try{
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://ec2-75-101-162-243.compute-1.amazonaws.com:5432/d3t9ta4a0jt26t?ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory","rukxiaikjxvknu","Nwz2RIo-TB29S9rojwy0lRwoPR");
			if(con!=null)
				System.out.println("Heroku database connected");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select * from ticks");
			
			List<Object> data = new ArrayList<>();
			while(rs.next()){
				Map<String, Object> kicks = new HashMap<>();
				kicks.put("tick", rs.getString("tick"));
				data.add(kicks);
			}
			return data;
		}catch(Exception ee){
			ee.printStackTrace();
			attributes.put("message", "There was an error: "+ee);
			return new ModelAndView(attributes,"error.ftl");
		}
	},gson::toJson);
    
    get("/dbinsert", (req, res) -> {
        Connection connection = null;
        Map<String, Object> attributes = new HashMap<>();
        try {
          connection = DatabaseUrl.extract().getConnection();

          Statement stmt = connection.createStatement();
          stmt.executeUpdate("CREATE TABLE IF NOT EXISTS items (itemID int, itemName varchar(100), itemBrand varchar(100), itemCategory varchar(100), itemDescription varchar(200), itemColor varchar(50), itemRating float, itemStock int, itemGender varchar(20), itemSize float)");
          stmt.executeUpdate("INSERT INTO items VALUES (000001, 'Air Jordan 1', 'Air Jordan', 'Basketball shoes', 'The first generation of Jordan shoes', 'Black/Red', 5.0, 5, 'Male', 9.0)");
          stmt.executeUpdate("INSERT INTO items VALUES (000002, 'Kobe XI', 'NIKE KOBE', 'Basketball shoes', 'The last generation of Nike Kobe shoes', 'Yellow/Purple', 4.9, 10, 'Male', 8.5)");
          ResultSet rs = stmt.executeQuery("SELECT * FROM items");
          
          List<Object> data = new ArrayList<>();
			while(rs.next()){
				Map<String, Object> kicks = new HashMap<>();
				kicks.put("itemID", rs.getString("itemID"));
				data.add(kicks);
			}
			return data;
        	}catch(Exception ee){
				ee.printStackTrace();
				attributes.put("message", "There was an error: "+ee);
				return new ModelAndView(attributes,"error.ftl");
			}
		},gson::toJson);
//          ArrayList<String> output = new ArrayList<String>();
//          while (rs.next()) {
//            output.add( "Read from DB: " + rs.getString("itemID"));
//          }
//
//          attributes.put("results", output);
//          return new ModelAndView(attributes, "db.ftl");
//        } catch (Exception e) {
//          attributes.put("message", "There was an error: " + e);
//          return new ModelAndView(attributes, "error.ftl");
//        } finally {
//          if (connection != null) try{connection.close();} catch(SQLException e){}
//        }
//      }, new FreeMarkerEngine());

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
