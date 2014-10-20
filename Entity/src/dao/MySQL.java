/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joao_victor1
 */
public class MySQL {
   public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String nomeServidor = "localhost";
            String database = "BDnutricao";
            String url = "jdbc:mysql://" + nomeServidor + "/" + database;
            String username = "root";
            String password = "mysql";

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
