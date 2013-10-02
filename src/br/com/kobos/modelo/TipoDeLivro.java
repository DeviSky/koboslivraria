
package br.com.kobos.modelo;

public class TipoDeLivro {
    
    private int id_tipo;
    private String descricao;

    public TipoDeLivro() {
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoDeLivro{" + "id_tipo=" + id_tipo + ", descricao=" + descricao + '}';
    }
    
    
}
