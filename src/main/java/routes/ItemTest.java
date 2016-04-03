package routes;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import spark.template.freemarker.FreeMarkerEngine;
import spark.ModelAndView;
import static spark.Spark.get;
import static spark.Spark.*;
import org.json.JSONObject;
import org.json.XML;
import com.google.gson.Gson;
import com.heroku.sdk.jdbc.DatabaseUrl;
import itemservices.*;
import itemdetails.*;

import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
            attributes.put("itemId","0000001");
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
/*
    get("/dbinsertregister", (req, res) -> {
        Connection connection = null;
        Map<String, Object> attributes = new HashMap<>();
        try {
          connection = DatabaseUrl.extract().getConnection();

          Statement stmt = connection.createStatement();
          stmt.executeUpdate("CREATE TABLE IF NOT EXISTS registers (email varchar(50) PRIMARY KEY NOT NULL, firstName varchar(50), lastName varchar(50), passwordUser varchar(50), userName varchar(50), zipCode varchar(20))");
          stmt.executeUpdate("INSERT INTO registers VALUES ('mj23@bulls.com', 'Michael', 'Jordan', 'Chicago', 'mj23', '12345')");
          ResultSet rs = stmt.executeQuery("SELECT * FROM registers");
         		
          ArrayList<String> output = new ArrayList<String>();
          while (rs.next()) {
            output.add( "Read from DB: " + rs.getString("email"));
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
*/
/*
    get("/dbinsert", (req, res) -> {
        Connection connection = null;
        Map<String, Object> attributes = new HashMap<>();
        try {
          connection = DatabaseUrl.extract().getConnection();

          Statement stmt = connection.createStatement();
          stmt.executeUpdate("CREATE TABLE IF NOT EXISTS items (itemID int PRIMARY KEY NOT NULL, itemName varchar(100), itemPrice float, itemBrand varchar(100), itemCategory varchar(100), itemDescription varchar(200), itemColor varchar(50), itemRating float, itemStock int, itemGender varchar(20), itemSize varchar(50))");
          stmt.executeUpdate("INSERT INTO items VALUES (000001, 'THETA SVX JACKET MEN', 749.00, 'ARCTERYX', 'Shell Jackets', 'A highly featured, severe weather condition jacket, designed for wet, stormy days', 'Black/Yellow/Blue', 5.0, 66, 'Male', 'S/M/L/XL')");
          stmt.executeUpdate("INSERT INTO items VALUES (000002, 'BETA AR JACKET MEN', 549.00, 'ARCTERYX', 'Shell Jackets', 'Lightweight and packable, waterproof GORE-TEX Pro jacket', 'Blue/Orange/Black/Grey/Navy', 4.9, 88, 'Male', 'S/M/L/XL')");
          ResultSet rs = stmt.executeQuery("SELECT * FROM items");
         		
          ArrayList<String> output = new ArrayList<String>();
          while (rs.next()) {
            output.add( "Read from DB: " + rs.getString("itemID"));
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
*/
/*    
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
         		
          ArrayList<String> output = new ArrayList<String>();
          while (rs.next()) {
            output.add( "Read from DB: " + rs.getString("itemID"));
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
*/
/*
get("/dbdroptable", (req, res) -> {
        Connection connection = null;
        Map<String, Object> attributes = new HashMap<>();
        try {
          connection = DatabaseUrl.extract().getConnection();
          Statement stmt = connection.createStatement();
          stmt.executeUpdate("DROP TABLE IF EXISTS items");
          //stmt.executeUpdate("INSERT INTO items VALUES (000001, 'Air Jordan 1', 'Air Jordan', 'Basketball shoes', 'The first generation of Jordan shoes', 'Black/Red', 5.0, 5, 'Male', 9.0)");
          //stmt.executeUpdate("INSERT INTO items VALUES (000002, 'Kobe XI', 'NIKE KOBE', 'Basketball shoes', 'The last generation of Nike Kobe shoes', 'Yellow/Purple', 4.9, 10, 'Male', 8.5)");
          ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");
         		
          ArrayList<String> output = new ArrayList<String>();
          while (rs.next()) {
            output.add( "Read from DB: " + rs.getString("tick"));
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
*/
get("/xmlpage", (req, res) -> {
    	Connection connection = null;
    	res.type("application/xml");

    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = factory.newDocumentBuilder();
	    Document doc = builder.newDocument();
	    Element results = doc.createElement("Results"); //the result set tag name
	    doc.appendChild(results);
	    
	    // get result from heroku db
	    connection = DatabaseUrl.extract().getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM items");
		//get column count of resultset
		ResultSetMetaData rsmd = rs.getMetaData();
		int columCount = rsmd.getColumnCount();
	    
		while (rs.next()){
			Element row = doc.createElement("Item"); //the tag for every item
			results.appendChild(row);
			for(int i =1; i<= columCount; i++){
				String columnName = rsmd.getColumnName(i);
				Object value = rs.getObject(i);
				Element node = doc.createElement(columnName);
				node.appendChild(doc.createTextNode(value.toString()));
				row.appendChild(node);
			}
		}
		
		DOMSource domSource = new DOMSource(doc);
	    TransformerFactory tf = TransformerFactory.newInstance();
	    Transformer transformer = tf.newTransformer();
	    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
	    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
	    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
	    StringWriter sw = new StringWriter();
	    StreamResult sr = new StreamResult(sw);
	    transformer.transform(domSource, sr);

	    String xml = sw.toString();
	    return xml;
			
//		rs.close();
//		stmt.close();
    });

post("/api/adduser", (req, res) ->{
    
    	Connection connection = null;
    	try{
    		JSONObject jsonObject = new JSONObject(req.body());
    		
    		String email = jsonObject.getString("reg_email_addr");
    		String firstName = jsonObject.getString("reg_f_name");
    		String lastName = jsonObject.getString("reg_l_name");
    		String passwordUser = jsonObject.getString("reg_pwd");
    		String userName = jsonObject.getString("reg_u_name");
    		String zipCode = jsonObject.getString("reg_z_code");
    		
    		//String sql = "INSERT INTO registers VALUES ('" + email + "', '" + firstName + "', '" + lastName + "', '" + passwordUser + "', '" + userName + "', '" + zipCode + "')";
    		
    		connection = DatabaseUrl.extract().getConnection();
    		Statement stmt = connection.createStatement();
    		stmt.executeUpdate("INSERT INTO registers VALUES ('kobe24@lakers.com', 'Kobe', 'Bryant', 'Los Angeles', 'kobe24', '12345')");
    		
    		res.status(200);
    		return req.body();
    		
    	} catch(Exception e){
    		res.status(500);
    		return e.getMessage();
    	} finally {
    		res.status(500);
    		if(connection != null) try {
    			connection.close();
    		} catch (SQLException e){
    		}
    	}	
    }); // end /api/adduser
    
  }
}
