package entidades;

import java.util.Date;
import java.util.ArrayList;

public class Locacao {
    private int id;
    private double valor;
    private Date data;
    private ArrayList<ItemLocacao> itensLocacao;
    private Cliente cliente;
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public ArrayList<ItemLocacao> getItensLocacao() {
        return itensLocacao;
    }

    public void setItensLocacao(ArrayList<ItemLocacao> itensLocacao) {
        this.itensLocacao = itensLocacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
