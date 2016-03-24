import static spark.Spark.*;

import routes.*;

public class Main {

  public static void main(String[] args) {

    port(Integer.valueOf(System.getenv("PORT")));
    staticFileLocation("/public");

    Object r3 = new JavaGettingStarted();
    Object r1 = new Week6Routes();
    Object r2 = new Week7Routes();
    //Object r = new Week8Routes();
  }

}