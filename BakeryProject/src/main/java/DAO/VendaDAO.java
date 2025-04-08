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

/**
 *
 * @author joaoh
 */
public class VendaDAO {
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
    
}
