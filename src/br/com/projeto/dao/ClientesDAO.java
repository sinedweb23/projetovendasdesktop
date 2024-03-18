package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ClientesDAO {
   
    private Connection con;
    
    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    // Método para cadastrar um cliente
    public void cadastrarCliente(Clientes obj) {
        try {
            // Comando SQL para inserção
            String sql = "INSERT INTO tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Preparação do comando SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            
            // Definição dos parâmetros
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setInt(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            
            // Execução do comando SQL
            stmt.executeUpdate();
            
            // Fechamento do PreparedStatement
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }
    
    // Outros métodos para alterar e excluir clientes podem ser adicionados aqui
}
