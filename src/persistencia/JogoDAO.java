package persistencia;

import entidades.Categoria;
import entidades.Jogo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {
    public static boolean inserir(Jogo jogo) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO jogo (titulo, descricao, preco, numeroDias, "
                    + "categoria_id, memoria, tipo) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, jogo.getTitulo());
            ps.setString(2, jogo.getDescricao());
            ps.setDouble(3, jogo.getPreco());
            ps.setInt(4, jogo.getNumeroDias());
            ps.setInt(5, jogo.getCategoria().getId());
            ps.setInt(6, jogo.getMemoria());
            ps.setString(7, String.valueOf(jogo.getTipo()));
            int resultado = ps.executeUpdate();
            ps.close();
            return resultado > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean alterar(Jogo jogo) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE jogo SET "
                    + "titulo=?, descricao=?, preco=?, numeroDias=?, "
                    + "categoria_id=?, memoria=?, tipo=? "
                    + "WHERE id=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, jogo.getTitulo());
            ps.setString(2, jogo.getDescricao());
            ps.setDouble(3, jogo.getPreco());
            ps.setInt(4, jogo.getNumeroDias());
            ps.setInt(5, jogo.getCategoria().getId());
            ps.setInt(6, jogo.getMemoria());
            ps.setString(7, String.valueOf(jogo.getTipo()));
            ps.setInt(8, jogo.getId());
            int resultado = ps.executeUpdate();
            ps.close();
            return resultado > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static boolean excluir(int id) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM jogo WHERE id=?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            int resultado = ps.executeUpdate();
            ps.close();
            return resultado > 0;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public static List<Jogo> listar() {
        List<Jogo> listaJogos = new ArrayList<Jogo>();
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "select jogo.*, " +
                        "   categoria.nome as categoria, " +
                        "   categoria.tipo as tipo_categoria " +
                        "from jogo " +
                        "inner join categoria on jogo.categoria_id = categoria.id";
            Statement st = conexao.createStatement();
            ResultSet res = st.executeQuery(sql);
            while(res.next()) {
                Categoria c = new Categoria();
                c.setId(res.getInt("categoria_id"));
                c.setNome(res.getString("categoria"));
                c.setTipo(res.getString("tipo_categoria").charAt(0));
                
                Jogo j = new Jogo(c); // Associa a categoria ao jogo
                j.setDescricao(res.getString("descricao"));
                j.setId(res.getInt("id"));
                j.setMemoria(res.getInt("memoria"));
                j.setNumeroDias(res.getInt("numeroDias"));
                j.setPreco(res.getDouble("preco"));
                j.setTipo(res.getString("tipo"));
                j.setTitulo(res.getString("titulo"));
                
                listaJogos.add(j);
            }
            res.close();
            st.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return listaJogos;
    }
}
