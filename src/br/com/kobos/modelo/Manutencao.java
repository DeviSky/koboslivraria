
package br.com.kobos.modelo;

import java.sql.Date;

public class Manutencao {
    
    private int id_manutencao;
    private String tipo;
    private Date data;
    private String motivo;

    public Manutencao() {
    }

    public int getId_manutencao() {
        return id_manutencao;
    }

    public void setId_manutencao(int id_manutencao) {
        this.id_manutencao = id_manutencao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "Manutencao{" + "id_manutencao=" + id_manutencao + ", tipo=" + tipo + ", data=" + data + ", motivo=" + motivo + '}';
    }
    
    
    
}
