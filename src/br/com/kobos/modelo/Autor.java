
package br.com.kobos.modelo;

public class Autor {
    
    private int id_autor;
    private String nome;
    private String sobrenome;
    private String email;

    public Autor() {
    }

    public int getId_autor() {
        return id_autor;
    }

    public void setId_autor(int id_autor) {
        this.id_autor = id_autor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }        

    @Override
    public String toString() {
        return "Autor{" + "id_autor=" + id_autor + ", nome=" + nome + ", sobrenome=" + sobrenome + ", email=" + email + '}';
    }
        
}
