/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;
import model.Produto;

/**
 * @author joaoh
 */

/**
 * Interface de Acesso a Dados (DAO) para a entidade Produto.
 * Define as operações CRUD e outras funcionalidades relacionadas ao banco de dados para produtos.
 */
public interface IProdutoDAO {
    
    /**
     * Salva um novo produto no banco de dados e retorna seu ID gerado.
     * 
     * @param produto O produto a ser salvo
     * @return O ID gerado do novo produto salvo
     * @throws Exception Se ocorrer um erro durante a operação no banco de dados ou se nenhum ID for gerado
     */
    Long salvar(Produto produto) throws Exception;
    
    /**
     * Busca todos os produtos cadastrados no banco de dados.
     * 
     * @return Uma lista com todos os produtos do banco de dados
     * @throws Exception Se ocorrer um erro durante a consulta ao banco de dados
     */
    List<Produto> buscarTodos() throws Exception;
    
    /**
     * Busca um produto específico pelo seu ID.
     * 
     * @param id O ID do produto a ser buscado
     * @return O produto correspondente ao ID fornecido, ou null se não encontrado
     * @throws Exception Se ocorrer um erro durante a consulta ao banco de dados
     */
    Produto buscarPorId(Long id) throws Exception;
    
    /**
     * Atualiza os dados de um produto existente no banco de dados.
     * 
     * @param produto O produto com os dados atualizados
     * @throws Exception Se ocorrer um erro durante a atualização no banco de dados
     */
    void atualizar(Produto produto) throws Exception;
    
    /**
     * Exclui um produto do banco de dados, incluindo todas as vendas relacionadas a ele.
     * 
     * @param id O ID do produto a ser excluído
     * @throws Exception Se ocorrer um erro durante a exclusão no banco de dados
     */
    void excluir(Long id) throws Exception;
    
    /**
     * Busca produtos cujos nomes contenham o texto parcial fornecido.
     * 
     * @param nomeParcial O texto parcial para busca no nome dos produtos
     * @return Uma lista de produtos que correspondem ao critério de busca
     * @throws Exception Se ocorrer um erro durante a consulta ao banco de dados
     */
    List<Produto> buscarPorNome(String nomeParcial) throws Exception;
    
    /**
     * Atualiza o estoque de um produto, incrementando ou decrementando a quantidade atual.
     * 
     * @param idProduto O ID do produto cujo estoque será atualizado
     * @param quantidade A quantidade a ser adicionada (positiva) ou removida (negativa)
     * @throws Exception Se o produto não for encontrado ou ocorrer um erro durante a atualização
     */
    void atualizarEstoque(Long idProduto, int quantidade) throws Exception;
}