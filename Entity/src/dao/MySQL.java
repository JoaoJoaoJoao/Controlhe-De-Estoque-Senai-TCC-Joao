
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySQL {
   public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String nomeServidor = "localhost";
            String database = "ProjetoTCC";
            String url = "jdbc:mysql://" + nomeServidor + "/" + database;
            String username = "root";
            String password = "";

            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Não foi possivel conectar ao Banco de Dados.");
            return null;
        }
    } 
}
