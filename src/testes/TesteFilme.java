/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import entidades.Categoria;
import entidades.Filme;
import javax.swing.JOptionPane;
import persistencia.FilmeDAO;

/**
 *
 * @author Marcelo
 */
public class TesteFilme {
    public static void main(String[] args) {
        Categoria categoria = new Categoria();
        categoria.setId(2); // 2 - categoria comédia
        
        Filme filme = new Filme(categoria); // realiza a associação com categoria
        filme.setTitulo("Bad Boys");
        filme.setDuracao(90);
        filme.setPreco(2.5);
        filme.setNumeroDias(5);
        filme.setDiretor("Diretor BAD");
        filme.setDescricao("Filme policial");
        
        /*
        if (FilmeDAO.inserir(filme)) {
            JOptionPane.showMessageDialog(null, "Filme inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao inserir filme.");
        }*/
        /*
        filme.setId(5);
        if (FilmeDAO.alterar(filme)) {
            JOptionPane.showMessageDialog(null, "Filme alterar com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao alterar filme.");
        }*/
        if (FilmeDAO.excluir(5)) {
            JOptionPane.showMessageDialog(null, "Filme excluir com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao excluir filme.");
        }
        
        
        System.out.println(FilmeDAO.listar());
    }
}
