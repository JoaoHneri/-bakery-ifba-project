/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;
import java.util.List;
import model.Funcionario;

/**
 * Interface de Acesso a Dados (DAO) para a entidade Funcionario.
 * Define as operações CRUD e outras funcionalidades relacionadas ao banco de dados para funcionários.
 *
 * @author joaoh
 */
public interface IFuncionarioDAO {
    
    /**
     * Inclui um novo funcionário no banco de dados.
     * 
     * @param funcionario O funcionário a ser incluído
     * @throws RuntimeException Se ocorrer um erro durante a operação de inclusão
     */
    void incluir(Funcionario funcionario);
    
    /**
     * Busca todos os funcionários cadastrados no banco de dados.
     * 
     * @return Uma lista com todos os funcionários cadastrados
     * @throws RuntimeException Se ocorrer um erro durante a consulta ao banco de dados
     */
    List<Funcionario> buscarTodos();
    
    /**
     * Busca um funcionário específico pelo seu ID.
     * 
     * @param id O ID do funcionário a ser buscado
     * @return O funcionário correspondente ao ID fornecido, ou null se não encontrado
     * @throws RuntimeException Se ocorrer um erro durante a consulta ao banco de dados
     */
    Funcionario buscarPorId(Long id);
    
    /**
     * Atualiza os dados de um funcionário existente no banco de dados.
     * 
     * @param funcionario O funcionário com os dados atualizados
     * @throws RuntimeException Se ocorrer um erro durante a atualização no banco de dados
     */
    void atualizar(Funcionario funcionario);
    
    /**
     * Exclui um funcionário do banco de dados.
     * 
     * @param id O ID do funcionário a ser excluído
     * @throws RuntimeException Se ocorrer um erro durante a exclusão no banco de dados
     */
    void excluir(Long id);
    
    /**
     * Busca funcionários cujos nomes contenham o texto fornecido.
     * 
     * @param nome O texto para busca no nome dos funcionários
     * @return Uma lista de funcionários que correspondem ao critério de busca
     * @throws RuntimeException Se ocorrer um erro durante a consulta ao banco de dados
     */
    List<Funcionario> buscarPorNome(String nome);
}