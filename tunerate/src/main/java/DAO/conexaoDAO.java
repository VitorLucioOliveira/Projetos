package DAO;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class conexaoDAO {
    
    public Connection conectaBD(){
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost/login?user=root&password=1234"; // coneção da base de dados

            conn = DriverManager.getConnection(url);
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ConexaoDao: "+e.getMessage());
        }

        return conn;
    }

}
