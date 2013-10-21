
package br.com.kobos.modelo;

public class Usuario {
    
    private int id_usuario;
    private String nome_us;
    private String usuario_us;
    private String senha_us;
    private String nivelAcesso_us;
    private Funcionario id_funcionario;
    private Loja id_loja;
    
    public Usuario(){
        
    }

    public String getUsuario_us() {
        return usuario_us;
    }

    public void setUsuario_us(String usuario_us) {
        this.usuario_us = usuario_us;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNome_us() {
        return nome_us;
    }

    public void setNome_us(String nome_us) {
        this.nome_us = nome_us;
    }

    public String getSenha_us() {
        return senha_us;
    }

    public void setSenha_us(String senha_us) {
        this.senha_us = senha_us;
    }

    public String getNivelAcesso_us() {
        return nivelAcesso_us;
    }

    public void setNivelAcesso_us(String nivelAcesso_us) {
        this.nivelAcesso_us = nivelAcesso_us;
    }

    public Funcionario getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Funcionario id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Loja getId_loja() {
        return id_loja;
    }

    public void setId_loja(Loja id_loja) {
        this.id_loja = id_loja;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + id_usuario + ", nome_us=" + nome_us + ", usuario_us=" + usuario_us + ", senha_us=" + senha_us + ", nivelAcesso_us=" + nivelAcesso_us + ", id_funcionario=" + id_funcionario + ", id_loja=" + id_loja + '}';
    }

    
    
    
    
}
