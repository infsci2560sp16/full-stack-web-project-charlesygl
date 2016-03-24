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

import static javax.measure.unit.SI.KILOGRAM;
import javax.measure.quantity.Mass;
import org.jscience.physics.model.RelativisticModel;
import org.jscience.physics.amount.Amount;

import com.heroku.sdk.jdbc.DatabaseUrl;

public class Main {

  public static void main(String[] args) {

      FreeMarkerEngine freeMarkerEngine = new FreeMarkerEngine();
      Configuration freeMarkerConfiguration = new Configuration();
      freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(BlogService.class, "/"));
      freeMarkerEngine.setConfiguration(freeMarkerConfiguration);



      // get all post (using HTTP get method)
      get("/posts", (request, response) -> {
          if (shouldReturnHtml(request)) {
              response.status(200);
              response.type("text/html");
              Map<String, Object> attributes = new HashMap<>();
              attributes.put("posts", model.getAllPosts());
              return freeMarkerEngine.render(new ModelAndView(attributes, "posts.ftl"));
          } else {
              response.status(200);
              response.type("application/json");
              return dataToJson(model.getAllPosts());
          }
      });

  }

}
