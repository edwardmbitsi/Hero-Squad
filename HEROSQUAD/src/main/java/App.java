import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        String layout = "templates/layout.hbs";
        String index = "templates/index.hbs";

        ProcessBuilder process = new ProcessBuilder();
        Integer port;
        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        } else {
            port = 4567;
        }

        port(port);

        get("/", ((request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            //model.put("heroes", request.session().attribute("heroes"));
            //model.put("template", index);
            return new ModelAndView(model, layout);
        }), new HandlebarsTemplateEngine());

        get("squads/:id/hero-form", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad-hero-form.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("heroes", Hero.getHeroes());
            model.put("template", "templates/heroes.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        post("/heroes", ((request, response) -> {
            Map<String, Object> model = new HashMap<>();

            Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));

            String jina = request.queryParams("jina");
            int miaka = Integer.parseInt(request.queryParams("miaka"));
            String strength = request.queryParams("strength");
            String weakness = request.queryParams("weakness");

            Hero newHero = new Hero(jina,miaka,strength,weakness);
            squad.addHero(newHero);

            model.put("squad", squad);
            model.put("template", "templates/squad-hero-success.hbs");
            return new ModelAndView(model, layout);
        }), new HandlebarsTemplateEngine());

        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Hero hero = Hero.find(Integer.parseInt(request.params(":id")));
            model.put("heroes", hero);
            model.put("template", "templates/hero.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/squads/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/squad-form.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        post("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String squadName = request.queryParams("squadName");
            int size = Integer.parseInt(request.queryParams("size"));
            String cause = request.queryParams("cause");

            Squad newSquad = new Squad(squadName,size,cause);
            model.put("template", "templates/success-squad.hbs");

            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("squads", Squad.getSquads());
            model.put("template", "templates/squads.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/squad.hbs");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

    }
}