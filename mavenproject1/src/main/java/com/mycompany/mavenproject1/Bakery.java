/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import DAO.FuncionarioDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import model.Funcionario;

/**
 *
 * @author joaoh
 */
public class Bakery {
    public static void main(String[] args) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        
        
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    
        Funcionario f1 = new Funcionario("João Henrique", "10426174577", LocalDate.parse("16/07/2004", formatter), "Feira de santana", "75983237776", "joaonsousa@gmail.com",
                "Padeiro", "Padaria", 1500);
        
        funcionarioDAO.incluir(f1);
        
    }
}
