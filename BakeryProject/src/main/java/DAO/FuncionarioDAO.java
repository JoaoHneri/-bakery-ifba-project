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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaoh
 */

/**
 * Classe que irá conter todas as funções que envolvem Funcionários e sua relação com o banco de dados.
 * Permite cadastrar, editar, visualizar e excluir funcionários.
 */
public class FuncionarioDAO {
    
    /**
     * Insere um novo funcionário no banco de dados.
     * 
     * @param funcionario O objeto Funcionario contendo os dados a serem inseridos
     * @throws RuntimeException Se ocorrer um erro durante a inserção no banco de dados
     */
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
    
    /**
     * Recupera todos os funcionários cadastrados no banco de dados.
     * 
     * @return Lista de Funcionario contendo todos os funcionários cadastrados
     * @throws RuntimeException Se ocorrer um erro durante a consulta ao banco de dados
     */
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
    
    /**
     * Busca um funcionário específico pelo seu ID.
     * 
     * @param id O ID do funcionário a ser buscado
     * @return O objeto Funcionario correspondente ao ID fornecido
     * @throws RuntimeException Se o funcionário não for encontrado ou ocorrer um erro na consulta
     */
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
    
    /**
     * Atualiza os dados de um funcionário existente no banco de dados.
     * 
     * @param funcionario O objeto Funcionario com os dados atualizados
     * @throws RuntimeException Se ocorrer um erro durante a atualização no banco de dados
     */
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
    
    
    /**
     * Remove um funcionário do banco de dados.
     * 
     * @param id O ID do funcionário a ser removido
     * @throws RuntimeException Se ocorrer um erro durante a exclusão no banco de dados
     */
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
    
    /**
     * Busca funcionários cujos nomes correspondam ao padrão fornecido.
     * 
     * @param nome O nome ou parte do nome a ser buscado (usa LIKE '%nome%')
     * @return Lista de Funcionario contendo os resultados da busca
     * @throws RuntimeException Se ocorrer um erro durante a consulta ao banco de dados
     */
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
