/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidades.Categoria;
import entidades.Filme;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class FilmeDAO {
    public static List<Filme> listar() {
        List<Filme> lista = new ArrayList<Filme>();
        try {
            String sql = "SELECT filme.*,"
                    + "     categoria.nome as categoria,"
                    + "     categoria.tipo "
                    + "FROM filme "
                    + "INNER JOIN categoria ON filme.categoria_id = categoria.id";
            Connection conexao = Conexao.getConexao();
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("categoria_id"));
                categoria.setNome(rs.getString("categoria"));
                categoria.setTipo(rs.getString("tipo").charAt(0));
                
                Filme filme = new Filme(categoria);
                filme.setId(rs.getInt("id"));
                filme.setDescricao(rs.getString("descricao"));
                filme.setDiretor(rs.getString("diretor"));
                filme.setDuracao(rs.getInt("duracao"));
                filme.setNumeroDias(rs.getInt("numeroDias"));
                filme.setPreco(rs.getDouble("preco"));
                filme.setTitulo(rs.getString("titulo"));
                
                lista.add(filme);
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("FilmeDAO.listar");
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
