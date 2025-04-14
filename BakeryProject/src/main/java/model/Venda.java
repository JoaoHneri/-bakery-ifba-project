/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author joaoh
 * Classe Venda
 */
public class Venda {
    private Long id;
    private Produto produto;
    private int quantidade;
    private double valor;
    private LocalDate dataVenda;

    public Venda(Long id, Produto produto, int quantidade, double valor, LocalDate dataVenda) {
        this.id = id;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.dataVenda = dataVenda;
    }

    public Venda() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
    
    
    
}
