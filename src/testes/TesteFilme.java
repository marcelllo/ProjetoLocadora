/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import persistencia.FilmeDAO;

/**
 *
 * @author Marcelo
 */
public class TesteFilme {
    public static void main(String[] args) {
        System.out.println(FilmeDAO.listar());
    }
}
