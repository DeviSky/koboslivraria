
package br.com.kobos.modelo;

public class Funcionario {
    
    private int id_funcionario;
    private String cpf;
    private String salario;
    private String funcao;
    private String ctps;
    private String nivelAcesso;
    private String usuario;
    private String senha;

    public Funcionario() {
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

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
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

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "id_funcionario=" + id_funcionario + ", cpf=" + cpf + ", salario=" + salario + ", funcao=" + funcao + ", ctps=" + ctps + ", nivelAcesso=" + nivelAcesso + ", usuario=" + usuario + ", senha=" + senha + '}';
    }
    
    
}
