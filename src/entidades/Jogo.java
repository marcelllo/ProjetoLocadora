package entidades;

public class Jogo extends Item {
    private int memoria;
    private String tipo;

    public Jogo(Categoria categoria) {
        super(categoria);
    }
    
    public int getMemoria() {
        return memoria;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
