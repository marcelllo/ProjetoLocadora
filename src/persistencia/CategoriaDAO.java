package persistencia;

import entidades.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class CategoriaDAO {
    public static boolean inserir(Categoria categoria) {
        try {
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO categoria (nome, tipo) "
                    + "VALUES (?,?)";
            PreparedStatement comando = conexao.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setString(2, String.valueOf(categoria.getTipo()));
            comando.execute();
            comando.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	
	public static boolean alterar(Categoria categoria) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "UPDATE categoria SET "
                    + "nome = ?, "
                    + "tipo = ? "
                    + "WHERE id = ?";
            PreparedStatement comando = con.prepareStatement(sql);
            comando.setString(1, categoria.getNome());
            comando.setString(2, String.valueOf(categoria.getTipo()));
            comando.setInt(3, categoria.getId());
            
            int nrLinhas = comando.executeUpdate();
            
            comando.close();
            
            return nrLinhas > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
