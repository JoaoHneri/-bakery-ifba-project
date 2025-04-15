/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import java.util.List;
import model.Venda;

/**
 * @author joaoh
 */

/**
 * Interface de Acesso a Dados (DAO) para a entidade Venda.
 * Define as operações de banco de dados relacionadas a vendas.
 */
public interface IVendaDAO {
    
    /**
     * Salva uma nova venda no banco de dados e retorna seu ID gerado.
     * 
     * @param venda O objeto Venda contendo os dados da venda a ser registrada
     * @return O ID gerado para a nova venda
     * @throws Exception Se ocorrer um erro durante a operação ou se nenhum ID for gerado
     */
    Long salvarVenda(Venda venda) throws Exception;
    
    /**
     * Busca todas as vendas realizadas em um mês e ano específicos.
     * 
     * @param mes O mês (1-12) para filtrar as vendas
     * @param ano O ano para filtrar as vendas
     * @return Lista de vendas encontradas para o período, ordenadas por data (mais recente primeiro)
     * @throws RuntimeException Se ocorrer um erro durante a consulta ao banco de dados
     */
    List<Venda> buscarVendasPorMes(int mes, int ano);
}