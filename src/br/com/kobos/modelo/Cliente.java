    package br.com.kobos.modelo;

public class Cliente extends Pessoa {

    private int id_cliente;
    private int LOJA_id_loja;

    public Cliente() {
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getLOJA_id_loja() {
        return LOJA_id_loja;
    }

    public void setLOJA_id_loja(int LOJA_id_loja) {
        this.LOJA_id_loja = LOJA_id_loja;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + '}';
    }
}
