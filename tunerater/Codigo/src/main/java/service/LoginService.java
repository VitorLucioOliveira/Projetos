package service;

import dao.LoginDAO;
import model.Login;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;


public class LoginService {

	private LoginDAO LoginDAO = new LoginDAO();
	
	public LoginService() {
	}

	public String get(Request request, Response response){

		String requisicao = request.body();
		Gson gson = new Gson();
		Login login = gson.fromJson(requisicao, Login.class);
		String email = login.getEmail_usuario();
		
		Login tmp = LoginDAO.getEmail(email);
		
		if(tmp != null) {
			response.status(200);
			
			return new Gson().toJson(tmp);
		} else {
			response.status(404);
			return "Login nao encontrado";
		}
	}

	public Login delete (Request request, Response response){
		
		String requisicao = request.body();
		Gson gson = new Gson();
		int id = gson.fromJson(requisicao, Login.class).getId();
		Login login = LoginDAO.get(id);

		if(login != null) {
			LoginDAO.delete(login);
			response.status(200);
			return login;
		} else {
			response.status(404);
			return null;
		}
	}

	public Login getAll(Request request, Response response){
		
		String requisicao = request.body();
		Gson gson = new Gson();
		int id = gson.fromJson(requisicao, Login.class).getId();
		Login login = LoginDAO.get(id);

		if(login != null) {
			response.status(200);
			return login;
		} else {
			response.status(404);
			return null;
		}
	}
}