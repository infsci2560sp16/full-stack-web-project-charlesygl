import static spark.Spark.*;

import java.sql.Connection;
import java.sql.DriverManager;



import routes.*;

public class Main {

  public static void main(String[] args) {
      


	/*  
	try{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "Ygl871219");
		if(con != null){
			System.out.println("Connected");
		}
	} catch(Exception ee){
		ee.printStackTrace();
	}
	*/

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
     
      //Apply headers across all routers for CORS
    CorsFilter.apply();

    //Fix CORS when posting by adding options respone for Preflight check
    options("/*", (request,response)->{

        String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
        if (accessControlRequestHeaders != null) {
            response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
        }

        String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
        if(accessControlRequestMethod != null){
            response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
        }

        return "OK";
    });//end options
      
    Object r1 = new ItemTest();
  }

}
