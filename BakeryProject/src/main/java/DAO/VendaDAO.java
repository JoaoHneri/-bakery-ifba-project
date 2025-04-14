/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import model.Venda;
import Conexao.Conexao;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 *
 * @author joaoh
 */
/**
 * Classe de Acesso a Dados (DAO) para a entidade Venda.
 * Responsável por todas as operações de banco de dados relacionadas a vendas.
 */
public class VendaDAO {
    
    /**
     * Salva uma nova venda no banco de dados e retorna seu ID gerado.
     * 
     * @param venda O objeto Venda contendo os dados da venda a ser registrada
     * @return O ID gerado para a nova venda
     * @throws Exception Se ocorrer um erro durante a operação ou se nenhum ID for gerado
     */
    public Long salvarVenda(Venda venda) throws Exception {
        String sql = "INSERT INTO venda (idProduto, quantidade, valor, data_de_venda) VALUES (?, ?, ?, ?)";

        try (Connection conexao = Conexao.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setLong(1, venda.getProduto().getId());
            stmt.setInt(2, venda.getQuantidade());
            stmt.setDouble(3, venda.getValor());
            stmt.setDate(4, Date.valueOf(LocalDate.MAX).valueOf(venda.getDataVenda()));

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
            throw new Exception("Erro ao salvar Venda: " + e.getMessage() + 
                              "\nSQL: " + sql + 
                              "\nValores: [" + venda.getProduto().getId()+ ", " + 
                              venda.getQuantidade() + ", " + venda.getValor() + 
                              ", " + venda.getDataVenda()+ "]", e);
        }   
    }
    
    /**
     * Busca todas as vendas realizadas em um mês e ano específicos.
     * 
     * @param mes O mês (1-12) para filtrar as vendas
     * @param ano O ano para filtrar as vendas
     * @return Lista de vendas encontradas para o período, ordenadas por data (mais recente primeiro)
     * @throws RuntimeException Se ocorrer um erro durante a consulta ao banco de dados
     */
    public List<Venda> buscarVendasPorMes(int mes, int ano) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();

        try {
            String sql = "SELECT v.*, p.nome as nome_produto FROM venda v " +
                        "LEFT JOIN produto p ON v.idProduto = p.id " +
                        "WHERE MONTH(v.data_de_venda) = ? AND YEAR(v.data_de_venda) = ? " +
                        "ORDER BY v.data_de_venda DESC";

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, mes);
            stmt.setInt(2, ano);

            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda venda = new Venda();
                venda.setId(rs.getLong("id"));
                venda.setQuantidade(rs.getInt("quantidade"));
                venda.setValor(rs.getDouble("valor"));
                venda.setDataVenda(rs.getDate("data_de_venda").toLocalDate());

                if (rs.getObject("idProduto") != null) {
                    Produto produto = new Produto();
                    produto.setId(rs.getLong("idProduto"));
                    produto.setNome(rs.getString("nome_produto"));
                    venda.setProduto(produto);
                }

                vendas.add(venda);
            }
            return vendas;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar vendas por mês", ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
    }
    
}
