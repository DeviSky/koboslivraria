package br.com.kobos.modelo;

public class Livro {

    private int isbn;
    private int id_livro;
    private String titulo;
    private String subtitulo;
    private Categoria tema;
    private Loja loja;
    private Editor editor;
    private Autor autor;
    private String resumo;
    private String palavrasChave;
    private double volume;
    private int qtEstoque;
    private double preco;
    private double royalty;
    private int edicao;

    public Livro() {
    }

    public int getId_livro() {
        return id_livro;
    }

    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    public Categoria getTema() {
        return tema;
    }

    public void setTema(Categoria tema) {
        this.tema = tema;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getPalavrasChave() {
        return palavrasChave;
    }

    public void setPalavrasChave(String palavrasChave) {
        this.palavrasChave = palavrasChave;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getQtEstoque() {
        return qtEstoque;
    }

    public void setQtEstoque(int qtEstoque) {
        this.qtEstoque = qtEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getRoyalty() {
        return royalty;
    }

    public void setRoyalty(double royalty) {
        this.royalty = royalty;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return "Livro{" + "isbn=" + isbn + ", id_livro=" + id_livro + ", titulo=" + titulo + ", subtitulo=" + subtitulo + ", tema=" + tema + ", loja=" + loja + ", editor=" + editor + ", autor=" + autor + ", resumo=" + resumo + ", palavrasChave=" + palavrasChave + ", volume=" + volume + ", qtEstoque=" + qtEstoque + ", preco=" + preco + ", royalty=" + royalty + ", edicao=" + edicao + '}';
    }
    
}
