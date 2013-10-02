package br.com.kobos.modelo;

public class Editor {

    private int id_editor;
    private String nome;
    private String email;
    private String url;
    private String endereco;
    private String cidade;
    private String tel;

    public Editor() {
    }

    public int getId_editor() {
        return id_editor;
    }

    public void setId_editor(int id_editor) {
        this.id_editor = id_editor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Editor{" + "id_editor=" + id_editor + ", nome=" + nome + ", email=" + email + ", url=" + url + ", endereco=" + endereco + ", cidade=" + cidade + ", tel=" + tel + '}';
    }
}
