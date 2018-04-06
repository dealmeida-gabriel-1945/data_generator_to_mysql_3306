/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Darkfocus
 */
public class ConnectionFactory {
     //singleton
    private static ConnectionFactory instance = new ConnectionFactory();
    
    /*constantes (static final) - esses valores nunca muda ao longo da execução
    do programa*/
    public static final String URL = "jdbc:mysql://localhost:3306/"; //caminho para o BD
    public static final String USER = "root"; //nome do usuario
    public static final String PASSWORD = ""; //senha
    public static final String DRIVER_CLASS = "org.gjt.mm.mysql.Driver"; //nome do driver
    
   //construtor privado - padrão singleton - garantir unica 
   // instancia para todo o aplicativo
    private ConnectionFactory() {
        try {
            //registra o driver - para isso funcionar deve adicionar o driver do BD
            Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
     
    private Connection createConnection(String bd, String usuario, String senha) {
        
        
        
        
        Connection connection = null;
        /* sempre que for trabalhar com BD deve-se colocar os comandos
        dentro de uma instrução try-catch
        */
        try {
            //realiza a conexao com o BD MySQL
            connection = DriverManager.getConnection(URL+bd, usuario, senha);
        } catch (SQLException e) {
            //se algo der errado vem para a instrução catch e da erro
            JOptionPane.showMessageDialog(null, "ERRO: Erro na conexão com o banco de dados \n"+e.getMessage());
        }
        return connection;
    }   
        
    //método publico que retorna a conexao unica do BD 
    public static Connection getConnection(String bd, String usuario, String senha) {
        return instance.createConnection(bd,usuario,senha);
    }
    
}
