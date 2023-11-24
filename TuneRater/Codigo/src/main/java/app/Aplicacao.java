package app;

import static spark.Spark.*;
import service.CadastroService;
import service.LoginService;
import java.util.HashMap;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;


public class Aplicacao {
	
    private static CadastroService cadastroService = new CadastroService();
    private static LoginService loginService = new LoginService();

    public static void main(String[] args) {
        port(6789);
        
        staticFiles.location("/public");

        CorsFilter.apply();

        // Options handler for CORS
        options("/*", (request, response) -> {

            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }

            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }

            return "OK";
        });

        //USUARIOS
        post("/cadastro/insert", (request, response) -> cadastroService.insert(request, response));

        get("/cadastro/get", (request, response) -> cadastroService.get(request, response));

        get("/cadastro/getAll", (request, response) -> cadastroService.getAll(request, response));

        //LOGIN
        post("/login/get", (request, response) -> loginService.get(request, response));

        get("/cadastro/getAll", (request, response) -> loginService.getAll(request, response));

    }
}

class CorsFilter {
    
    private static final HashMap<String, String> corsHeaders = new HashMap<String, String>();
    
    static {
        corsHeaders.put("Access-Control-Allow-Methods", "GET,PUT,POST,DELETE,OPTIONS");
        corsHeaders.put("Access-Control-Allow-Origin", "*");
        corsHeaders.put("Access-Control-Allow-Headers", "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin,");
        corsHeaders.put("Access-Control-Allow-Credentials", "true");
    }

    public final static void apply() {
        Filter filter = new Filter() {
            @Override
            public void handle(Request request, Response response) throws Exception {
                corsHeaders.forEach((key, value) -> {
                    response.header(key, value);
                });
            }
        };
        Spark.after(filter);
    }
}
