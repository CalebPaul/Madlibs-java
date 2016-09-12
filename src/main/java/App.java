
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {

    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/form.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/results", (request, resposne) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String place = request.queryParams("place");
      String animal = request.queryParams("animal");
      String person = request.queryParams("person");
      String verb = request.queryParams("verb");
      model.put("place", place);
      model.put("animal", animal);
      model.put("person", person);
      model.put("verb", verb);
      model.put("template", "templates/results.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());
  }
}
