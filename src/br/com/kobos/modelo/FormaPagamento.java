
package br.com.kobos.modelo;

public class FormaPagamento {
    
    private int id_formapg;
    private String tipo;
    private String obs;
    
    public FormaPagamento(){
        
    }

    public int getId_formapg() {
        return id_formapg;
    }

    public void setId_formapg(int id_formapg) {
        this.id_formapg = id_formapg;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    @Override
    public String toString() {
        return "FormaPagamento{" + "id_formapg=" + id_formapg + ", tipo=" + tipo + ", obs=" + obs + '}';
    }
    
    
}
