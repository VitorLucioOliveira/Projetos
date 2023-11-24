package dao;

import model.Cadastro;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class CadastroDAO extends DAO {

    public CadastroDAO() {
        super();
        conectar();
    }

    public void finalize (){
        close();
    }

    public boolean insert(Cadastro cadastro) {
        boolean status = false;
    
        try {
            // Verificar se o e-mail já existe no banco antes de inserir
            String checkIfExistsQuery = "SELECT COUNT(*) AS count FROM tune WHERE email_usuario = ?";
            PreparedStatement checkIfExistsStmt = conexao.prepareStatement(checkIfExistsQuery);
            checkIfExistsStmt.setString(1, cadastro.getEmail_usuario());
            ResultSet resultSet = checkIfExistsStmt.executeQuery();
    
            if (resultSet.next() && resultSet.getInt("count") == 0) {
                // Se não existe, proceda com a inserção
                String sql = "INSERT INTO tune (nome_usuario, email_usuario, senha_usuario) VALUES (?, ?, md5(?));";
                PreparedStatement st = conexao.prepareStatement(sql);
                st.setString(1, cadastro.getNome_usuario());
                st.setString(2, cadastro.getEmail_usuario());
                st.setString(3, cadastro.getSenha_usuario());
                st.executeUpdate();
                st.close();
                status = true;
            } else {
                System.out.println("Usuário com este e-mail já existe no banco de dados.");
            }
    
            checkIfExistsStmt.close();
            resultSet.close();
    
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    
        return status;
    }

    public Cadastro get (int id){

        Cadastro cadastro = null;

        try{

            Statement st = conexao.createStatement();
            String sql = "SELECT * FROM tune WHERE id = " + id + ";";
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                cadastro = new Cadastro();
                cadastro.setId(rs.getInt("id"));
                cadastro.setNome_usuario(rs.getString("nome_usuario"));
                cadastro.setEmail_usuario(rs.getString("email_usuario"));
                cadastro.setSenha_usuario(rs.getString("senha_usuario"));
            }
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return cadastro;

    }

    public Cadastro delete (Cadastro cadastro){

        try{
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM tune WHERE id = " + cadastro.getId() + ";";
            st.executeUpdate(sql);
            st.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return cadastro;
    }

    public Cadastro getAll(){
            
            Cadastro cadastro = null;
    
            try{
                Statement st = conexao.createStatement();
                String sql = "SELECT * FROM tune;";
                ResultSet rs = st.executeQuery(sql);
    
                if(rs.next()){
                    cadastro = new Cadastro();
                    cadastro.setId(rs.getInt("id"));
                    cadastro.setNome_usuario(rs.getString("nome_usuario"));
                    cadastro.setEmail_usuario(rs.getString("email_usuario"));
                    cadastro.setSenha_usuario(rs.getString("senha_usuario"));
                }
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
    
            return cadastro;
    }
   
}
