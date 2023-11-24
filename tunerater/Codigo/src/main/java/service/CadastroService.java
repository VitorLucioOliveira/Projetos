package service;

import dao.CadastroDAO;
import model.Cadastro;
import spark.Request;
import spark.Response;
import com.google.gson.Gson;


public class CadastroService {

	private CadastroDAO CadastroDAO = new CadastroDAO();
	
	public CadastroService() {
	}

	public String insert(Request request, Response response){

		String requisicao = request.body();
		Gson gson = new Gson();
		Cadastro cadastro = gson.fromJson(requisicao, Cadastro.class);
		
		if(CadastroDAO.insert(cadastro) == true) {

			response.status(201);
			return gson.toJson(cadastro);
		} else {
			response.status(500);
			return "Erro ao inserir cadastro";
		}

	}

	public String get(Request request, Response response){

		String requisicao = request.body();
		Gson gson = new Gson();
		int id = gson.fromJson(requisicao, Cadastro.class).getId();
		Cadastro cadastro = CadastroDAO.get(id);

		if(cadastro != null) {
			response.status(200);
			return gson.toJson(cadastro);
		} else {
			response.status(404);
			return "Cadastro não encontrado";
		}
	}

	public Cadastro delete (Request request, Response response){
		
		String requisicao = request.body();
		Gson gson = new Gson();
		int id = gson.fromJson(requisicao, Cadastro.class).getId();
		Cadastro cadastro = CadastroDAO.get(id);

		if(cadastro != null) {
			CadastroDAO.delete(cadastro);
			response.status(200);
			return cadastro;
		} else {
			response.status(404);
			return null;
		}
	}

	public Cadastro getAll(Request request, Response response){
		
		String requisicao = request.body();
		Gson gson = new Gson();
		int id = gson.fromJson(requisicao, Cadastro.class).getId();
		Cadastro cadastro = CadastroDAO.get(id);

		if(cadastro != null) {
			response.status(200);
			return cadastro;
		} else {
			response.status(404);
			return null;
		}
	}
}