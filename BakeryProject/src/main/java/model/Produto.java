/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Pc
 * Classe Produto
 */

public class Produto {
    private Long id;
    private String nome;
    private Double valor;
    private Integer quantidade;
    private String categoria;

    public Produto(Long id, String nome, Double valor, Integer quantidade, String categoria){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Produto() {
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
     public Long getId() {
        return id;
    }
     
      public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + ", categoria=" + categoria + '}';
    }
      
    
}