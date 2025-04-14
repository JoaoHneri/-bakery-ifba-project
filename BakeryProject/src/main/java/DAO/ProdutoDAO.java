/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Statement;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Produto;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaoh
 */

/**
 * Classe de Acesso a Dados (DAO) para a entidade Produto.
 * Fornece operações CRUD e outras funcionalidades relacionadas ao banco de dados para produtos.
 */
public class ProdutoDAO {
    
    /**
     * Salva um novo produto no banco de dados e retorna seu ID gerado.
     * 
     * @param produto O produto a ser salvo
     * @return O ID gerado do novo produto salvo
     * @throws Exception Se ocorrer um erro durante a operação no banco de dados ou se nenhum ID for gerado
     */
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
            throw new Exception("Erro ao salvar produto: " + e.getMessage() + 
                              "\nSQL: " + sql + 
                              "\nValores: [" + produto.getNome() + ", " + 
                              produto.getQuantidade() + ", " + produto.getValor() + 
                              ", " + produto.getCategoria() + "]", e);
        }
    }
    
    /**
     * Busca todos os produtos cadastrados no banco de dados.
     * 
     * @return Uma lista com todos os produtos do banco de dados
     * @throws Exception Se ocorrer um erro durante a consulta ao banco de dados
     */
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
    
    /**
     * Busca um produto específico pelo seu ID.
     * 
     * @param id O ID do produto a ser buscado
     * @return O produto correspondente ao ID fornecido, ou null se não encontrado
     * @throws Exception Se ocorrer um erro durante a consulta ao banco de dados
     */
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
    
    /**
     * Atualiza os dados de um produto existente no banco de dados.
     * 
     * @param produto O produto com os dados atualizados
     * @throws Exception Se ocorrer um erro durante a atualização no banco de dados
     */
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
    
    /**
     * Exclui um produto do banco de dados, incluindo todas as vendas relacionadas a ele.
     * 
     * @param id O ID do produto a ser excluído
     * @throws Exception Se ocorrer um erro durante a exclusão no banco de dados
     */
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
    
    /**
     * Busca produtos cujos nomes contenham o texto parcial fornecido.
     * 
     * @param nomeParcial O texto parcial para busca no nome dos produtos
     * @return Uma lista de produtos que correspondem ao critério de busca
     * @throws Exception Se ocorrer um erro durante a consulta ao banco de dados
     */
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
    
     /**
     * Atualiza o estoque de um produto, incrementando ou decrementando a quantidade atual.
     * 
     * @param idProduto O ID do produto cujo estoque será atualizado
     * @param quantidade A quantidade a ser adicionada (positiva) ou removida (negativa)
     * @throws Exception Se o produto não for encontrado ou ocorrer um erro durante a atualização
     */
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