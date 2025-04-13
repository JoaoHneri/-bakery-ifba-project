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
import java.sql.ResultSet;
/**
 *
 * @author joaoh
 */
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    
    
    public List<Funcionario> buscarTodos() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
            ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getDate("data_nascimento") != null ? rs.getDate("data_nascimento").toLocalDate() : null,
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cargo"),
                    rs.getString("departamento"),
                    rs.getDouble("salario")
                );

                funcionarios.add(funcionario);
            }

            return funcionarios;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar funcionários no banco de dados" + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
    }
    
    public Funcionario buscarPorId(Long id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario WHERE id = ?");
            stmt.setLong(1, id);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return new Funcionario(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getDate("data_nascimento") != null ? rs.getDate("data_nascimento").toLocalDate() : null,
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cargo"),
                    rs.getString("departamento"),
                    rs.getDouble("salario")
                );
            }

            throw new RuntimeException("Funcionário não encontrado");

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar funcionário por ID", ex);
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
    }
    
    public void atualizar(Funcionario funcionario) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(
                "UPDATE Funcionario SET nome = ?, cpf = ?, data_nascimento = ?, " +
                "endereco = ?, telefone = ?, email = ?, cargo = ?, " +
                "departamento = ?, salario = ? WHERE id = ?");

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getCpf());
            stmt.setDate(3, funcionario.getDataNascimento() != null ? 
                Date.valueOf(funcionario.getDataNascimento()) : null);
            stmt.setString(4, funcionario.getEndereco());
            stmt.setString(5, funcionario.getTelefone());
            stmt.setString(6, funcionario.getEmail());
            stmt.setString(7, funcionario.getCargo());
            stmt.setString(8, funcionario.getDepartamento());
            stmt.setDouble(9, funcionario.getSalario());
            stmt.setLong(10, funcionario.getId());

            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar funcionário", ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void excluir(Long id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE FROM Funcionario WHERE id = ?");
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao excluir funcionário", ex);
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public List<Funcionario> buscarPorNome(String nome) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM Funcionario WHERE nome LIKE ?");
            stmt.setString(1, "%" + nome + "%");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario funcionario = new Funcionario(
                    rs.getLong("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getDate("data_nascimento") != null ? rs.getDate("data_nascimento").toLocalDate() : null,
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getString("email"),
                    rs.getString("cargo"),
                    rs.getString("departamento"),
                    rs.getDouble("salario")
                );
                funcionarios.add(funcionario);
            }

            return funcionarios;

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar funcionários por nome: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
    }
    
}
