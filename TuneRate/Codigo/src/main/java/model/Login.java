package model;


public class Login {

	private int id;
	private String nome_usuario;
	private String email_usuario;
    private String senha_usuario;
	
	public Login() {
		id = -1;
		nome_usuario = "";  
        email_usuario = "";
        senha_usuario = "";		
	}

	public Login(int id, String nome_usuario, 
    String email_usuario, String senha_usuario) {
		setId(id);
		setNome_usuario(nome_usuario);
        setEmail_usuario(email_usuario);
        setSenha_usuario(senha_usuario);
	}	
	

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_usuario() {
        return nome_usuario;
    }

    public void setNome_usuario(String nome_usuario) {
        this.nome_usuario = nome_usuario;
    }

    public String getEmail_usuario() {
        return email_usuario;
    }

    public void setEmail_usuario(String email_usuario) {
        this.email_usuario = email_usuario;
    }

    public String getSenha_usuario() {
        return senha_usuario;
    }

    public void setSenha_usuario(String senha_usuario) {
        this.senha_usuario = senha_usuario;
    }

    /**
	 * Método sobreposto da classe Object. É executado quando um objeto precisa
	 * ser exibido na forma de String.
	 */
	@Override
	public String toString() {
		return "ID: " + id + "   Nome:" + nome_usuario + "   Senha: " + senha_usuario + "   Email: " + email_usuario;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getId() == ((Login) obj).getId());
	}	
}