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
        try (var conexao = Conexao.getConexao()) {
            conexao.setAutoCommit(false); // Inicia uma transação

            try {
                // Primeiro exclui os registros da tabela venda que referenciam o produto
                var sqlVendas = "delete from venda where idProduto = ?";
                try (var stmtVendas = conexao.prepareStatement(sqlVendas)) {
                    stmtVendas.setLong(1, id);
                    stmtVendas.executeUpdate();
                }

                // Depois exclui o produto
                var sqlProduto = "delete from produto where id = ?";
                try (var stmtProduto = conexao.prepareStatement(sqlProduto)) {
                    stmtProduto.setLong(1, id);
                    stmtProduto.executeUpdate();
                }

                conexao.commit(); // Confirma a transação
            } catch (SQLException e) {
                conexao.rollback(); // Desfaz a transação em caso de erro
                throw new Exception("Erro ao excluir produto: " + e.getMessage(), e);
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
        }
    }
    
    public List<Produto> buscarPorNome(String nomeParcial) throws Exception {
        var sql = "SELECT * FROM produto WHERE nome LIKE ?";
        List<Produto> produtos = new ArrayList<>();

        try (var conexao = Conexao.getConexao();
             var stmt = conexao.prepareStatement(sql)) {

            // Adiciona os % para busca parcial antes e depois do termo
            stmt.setString(1, "%" + nomeParcial + "%");

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Produto produto = new Produto(
                        rs.getLong("id"), 
                        rs.getString("nome"), 
                        rs.getDouble("valor"), 
                        rs.getInt("quantidade"), 
                        rs.getString("categoria")
                    );
                    produtos.add(produto);
                    System.out.println(produto.toString());
                }
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao buscar produtos por nome: " + e.getMessage(), e);
        }

        return produtos;
    }
    
    public void atualizarEstoque(Long idProduto, int quantidade) throws Exception {
        String sql = "UPDATE produto SET quantidade = quantidade + ? WHERE id = ?";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, quantidade);
            stmt.setLong(2, idProduto);

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new Exception("Produto não encontrado ou estoque não atualizado");
            }
        } catch (SQLException e) {
            throw new Exception("Erro ao atualizar estoque: " + e.getMessage(), e);
        }
    }
}