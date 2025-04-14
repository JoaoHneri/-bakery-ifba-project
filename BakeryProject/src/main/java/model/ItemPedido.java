/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author joaoh
 */

/**
 * Classe Item Pedido
 */
public class ItemPedido {
    private Long produtoId;
    private String produtoNome;
    private Integer quantidade;
    private Double valorUnitario;
    private Double valorTotal;
    private String categoria;

    public ItemPedido(Long produtoId, String produtoNome, Integer quantidade, 
                     Double valorUnitario, Double valorTotal, String categoria) {
        this.produtoId = produtoId;
        this.produtoNome = produtoNome;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.categoria = categoria;
    }

    // Getters e Setters
    public Long getProdutoId() {
        return produtoId;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public String getCategoria() {
        return categoria;
    }
}
