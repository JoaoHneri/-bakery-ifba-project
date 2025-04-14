/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import java.time.LocalDate;

/**
 *
 * @author joaoh
 * Classe Funcionário que herda de Pessoa
 */

/**
 * Classe Funcionário que herda de Pessoa
 */
public class Funcionario extends Pessoa {
    private String cargo;
    private String departamento;
    private double salario;

    public Funcionario(Long id, String nome, String cpf, LocalDate dataNascimento, 
                       String endereco, String telefone, String email, 
                       String cargo, String departamento, double salario) {
        super(id, nome, cpf, dataNascimento, endereco, telefone, email);
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}