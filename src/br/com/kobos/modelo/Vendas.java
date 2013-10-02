
package br.com.kobos.modelo;

import java.sql.Date;

public class Vendas {
    
    private int id_vendas;
    private Date dtVenda;
    private int quantidade;

    public Vendas() {
    }

    public int getId_vendas() {
        return id_vendas;
    }

    public void setId_vendas(int id_vendas) {
        this.id_vendas = id_vendas;
    }

    public Date getDtVenda() {
        return dtVenda;
    }

    public void setDtVenda(Date dtVenda) {
        this.dtVenda = dtVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Vendas{" + "id_vendas=" + id_vendas + ", dtVenda=" + dtVenda + ", quantidade=" + quantidade + '}';
    }
    
    
}
