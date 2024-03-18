package br.com.projeto.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException; // Importa a classe SQLException

public class ConnectionFactory {
    
   public Connection getConnection(){
    try { 
        return DriverManager.getConnection("jdbc:mysql://localhost/bdvendas", "root", "");
    } catch (SQLException e) {
        e.printStackTrace(); // Imprime a pilha de rastreamento no console
        throw new RuntimeException("Erro ao conectar ao banco de dados", e); // Lança a exceção RuntimeException com a exceção original
    }
}

// Método para fechar a conexão
public void closeConnection(Connection connection) {
    try {
        if (connection != null) {
            connection.close();
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
