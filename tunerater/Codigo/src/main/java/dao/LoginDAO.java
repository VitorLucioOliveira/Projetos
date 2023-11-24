package dao;

import model.Login;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO extends DAO {

    public LoginDAO() {
        super();
        conectar();
    }

    public void finalize (){
        close();
    }

    public Login get (int id){

        Login login = null;

        try{

            Statement st = conexao.createStatement();
            String sql = "SELECT * FROM tune WHERE id = " + id + ";";
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                login = new Login();
                login.setId(rs.getInt("id"));
                login.setNome_usuario(rs.getString("nome_usuario"));
                login.setEmail_usuario(rs.getString("email_usuario"));
                login.setSenha_usuario(rs.getString("senha_usuario"));

            }
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return login;

    }

    public Login getEmail (String email){

        Login login = null;

        try{

            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM tune WHERE email_usuario ="+ "'" + email + "'";
            ResultSet rs = st.executeQuery(sql);

            if(rs.next()){
                login = new Login();
                login.setId(rs.getInt("id"));
                login.setNome_usuario(rs.getString("nome_usuario"));
                login.setEmail_usuario(rs.getString("email_usuario"));
                login.setSenha_usuario(rs.getString("senha_usuario"));

            }
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return login;

    }

    public Login delete (Login login){

        try{
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM tune WHERE id = " + login.getId() + ";";
            st.executeUpdate(sql);
            st.close();
        }catch(Exception e){
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        return login;
    }

    public Login getAll(){
            
            Login login = null;
    
            try{
                Statement st = conexao.createStatement();
                String sql = "SELECT * FROM tune;";
                ResultSet rs = st.executeQuery(sql);
    
                if(rs.next()){
                    login = new Login();
                    login.setId(rs.getInt("id"));
                    login.setNome_usuario(rs.getString("nome_usuario"));
                    login.setEmail_usuario(rs.getString("email_usuario"));
                    login.setSenha_usuario(rs.getString("senha_usuario"));

                }
            }catch(Exception e){
                System.err.println(e.getClass().getName() + ": " + e.getMessage());
            }
    
            return login;
    }
   
}
