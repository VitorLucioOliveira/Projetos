package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {

        conn = new conexaoDAO().conectaBD();

        try {

            String sql = "select * from user where email_usuario=? and senha_usuario=?";// VEM AQUI

            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getEmail_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();

            return rs;

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + e);
            return null;
        }

    }

    public void cadastrarUsuario(UsuarioDTO objusuariodto) {

        PreparedStatement pstm;
        String sql = "insert into user(nome_usuario, email_usuario, senha_usuario) values(?,?,?)";

        conn = new conexaoDAO().conectaBD();
        try {

            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getEmail_usuario());
            pstm.setString(3, objusuariodto.getSenha_usuario());
            
            pstm.execute();
            pstm.close();
            
            
            
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + e);
        }
    }
}
