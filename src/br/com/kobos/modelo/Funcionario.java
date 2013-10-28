package br.com.kobos.modelo;

public class Funcionario extends Pessoa{

    private int id_funcionario;
    private String cpf;
    private double salario;
    private String funcao;
    private String ctps;
    private int LOJA_id_loja;
    private int USUARIO_id_usuario;

    public Funcionario() {
    }

    public int getLOJA_id_loja() {
        return LOJA_id_loja;
    }

    public void setLOJA_id_loja(int LOJA_id_loja) {
        this.LOJA_id_loja = LOJA_id_loja;
    }

    public int getUSUARIO_id_usuario() {
        return USUARIO_id_usuario;
    }

    public void setUSUARIO_id_usuario(int USUARIO_id_usuario) {
        this.USUARIO_id_usuario = USUARIO_id_usuario;
    }

    public int getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }


    @Override
    public String toString() {
        return "Funcionario{" + "id_funcionario=" + id_funcionario + ", cpf=" + cpf + ", salario=" + salario + ", funcao=" + funcao + ", ctps=" + ctps + '}';
    }
}
