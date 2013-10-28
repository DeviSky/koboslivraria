
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Livro;
import java.util.List;

public interface LivroDAO {
    int salvar (Livro f);
    boolean remove (int id_livro);
    List<Livro> listAll();
    Livro ListById(int id_livro);
    List<Livro> ListByNome(String nome);
    List<Livro> ListByAutor(int id_autor);
}
