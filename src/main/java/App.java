import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/CD-form", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/CD-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/CDs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("CDs", CD.all());
      model.put("template", "templates/CDs.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/CDs", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String title = request.queryParams("CD");
      CD newCD = new CD(title);
      model.put("CDs", CD.all());
      model.put("template", "templates/CDs.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("CD/:id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      CD cd = CD.find(Integer.parseInt(request.params(":id")));
      model.put("CD", cd);
      model.put("template", "templates/CD.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/artist", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();

      model.put("CDs", CD.searchByArtist("test"));
      model.put("artist", "TEST");
      model.put("template", "templates/artist.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
