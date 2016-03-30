import static spark.Spark.*;

import java.sql.Connection;
import java.sql.DriverManager;



import routes.*;

public class Main {

  public static void main(String[] args) {
	  
	try{
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test", "postgres", "Ygl871219");
		if(con != null){
			System.out.println("Connected");
		}
	} catch(Exception ee){
		ee.printStackTrace();
	}
	

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");
    //Object r1 = new Week6Routes();
    //Object r2 = new Week7Routes();
    //Object r3 = new JavaGettingStarted();
    Object r4 = new ItemTest();
    //Object r = new Week8Routes();
  }

}
