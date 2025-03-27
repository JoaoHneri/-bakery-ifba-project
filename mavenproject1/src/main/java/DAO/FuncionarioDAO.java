/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import model.Funcionario;
import Conexao.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
/**
 *
 * @author joaoh
 */
import java.sql.SQLException;

public class FuncionarioDAO {
    
    public void incluir(Funcionario funcionario) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO Funcionario " +
                     "(nome, cpf, data_nascimento, endereco, telefone, email, cargo, departamento, salario)" +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            if (funcionario.getDataNascimento() != null) {
                stmt.setDate(3, Date.valueOf(funcionario.getDataNascimento()));
            } else {
                stmt.setNull(3, java.sql.Types.DATE);
            }
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getEmail());
            stmt.setString(7, funcionario.getCargo());
            stmt.setString(8, funcionario.getDepartamento());
            stmt.setDouble(9, funcionario.getSalario());

            stmt.executeUpdate();

            System.out.println("Funcionário " + funcionario.getNome() + " inserido com sucesso");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Erro ao inserir funcionário no banco de dados");
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
