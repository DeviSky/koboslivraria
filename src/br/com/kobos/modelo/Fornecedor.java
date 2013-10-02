package br.com.kobos.modelo;

public class Fornecedor {

    private int id_fornecedor;
    private String nome;
    private String endereco;
    private String telefone;

    public Fornecedor() {
    }

    public int getId_fornecedor() {
        return id_fornecedor;
    }

    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "id_fornecedor=" + id_fornecedor + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + '}';
    }
}
