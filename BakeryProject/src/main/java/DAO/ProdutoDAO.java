/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Statement;  // Adicione esta importação
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    
    public Long salvar(Produto produto) throws Exception {
    String sql = "INSERT INTO produto (nome, quantidade, valor, categoria) VALUES (?, ?, ?, ?)";
    
    try (Connection conexao = Conexao.getConexao();
         PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
        stmt.setString(1, produto.getNome());
        stmt.setInt(2, produto.getQuantidade());
        stmt.setDouble(3, produto.getValor());
        stmt.setString(4, produto.getCategoria());
        
        int affectedRows = stmt.executeUpdate();
        
        if (affectedRows == 0) {
            throw new SQLException("Falha ao salvar, nenhuma linha afetada.");
        }

        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getLong(1);
            } else {
                throw new SQLException("Falha ao obter o ID gerado.");
            }
        }
    } catch (SQLException e) {
        // Adiciona mais informações ao erro
        throw new Exception("Erro ao salvar produto: " + e.getMessage() + 
                          "\nSQL: " + sql + 
                          "\nValores: [" + produto.getNome() + ", " + 
                          produto.getQuantidade() + ", " + produto.getValor() + 
                          ", " + produto.getCategoria() + "]", e);
    }
}

    public List<Produto> buscarTodos() throws Exception{

        var sql = "select * from produto";

        List<Produto> produtos = new ArrayList<>();

        try (var conexao = Conexao.getConexao();
            var stmt = conexao.prepareStatement(sql)) {

                try(ResultSet rs = stmt.executeQuery()){
                    while (rs.next()) {
                        
                        Produto produto = new Produto(rs.getLong("id"), 
                        rs.getString("nome"), rs.getDouble("valor"), 
                        rs.getInt("quantidade"), rs.getString("categoria"));

                        produtos.add(produto);
                    }
                }

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return produtos;
    }

    public Produto buscarPorId(Long id) throws Exception{

        var sql = "select * from produto where id = ?";

        Produto produto = null;

        try (var conexao = Conexao.getConexao();
            var stmt = conexao.prepareStatement(sql)) {
                stmt.setLong(1, id);
                try(ResultSet rs = stmt.executeQuery()){
                    while (rs.next()) {
                        produto = new Produto(rs.getLong("id"), 
                        rs.getString("nome"), rs.getDouble("valor"), 
                        rs.getInt("quantidade"), rs.getString("categoria"));
                    }
                }

        } catch (SQLException e) {
            throw new Exception(e);
        }

        return produto;
    }

    public void atualizar(Produto produto) throws Exception {

        var sql = "update produto set nome = ?, quantidade = ?, valor = ?, categoria = ? where id = ?";
        
        try (var conexao = Conexao.getConexao();
            var stmt = conexao.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setInt(2, produto.getQuantidade());
                stmt.setDouble(3, produto.getValor());
                stmt.setString(4, produto.getCategoria());
                stmt.setLong(5, produto.getId());
                stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void excluir(Long id) throws Exception {

        var sql = "delete from produto where id = ?";
        
        try (var conexao = Conexao.getConexao();
            var stmt = conexao.prepareStatement(sql)) {
                stmt.setLong(1, id);
                stmt.executeUpdate();
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }
}