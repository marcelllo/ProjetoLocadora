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
}
