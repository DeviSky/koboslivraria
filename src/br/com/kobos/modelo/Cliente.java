package br.com.kobos.modelo;

public class Cliente extends Pessoa {

    private int id_pessoa;

    public Cliente() {
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_pessoa=" + id_pessoa + '}';
    }
}
