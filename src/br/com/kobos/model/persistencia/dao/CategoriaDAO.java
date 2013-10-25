
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Categoria;
import java.util.List;

public interface CategoriaDAO {
    int salvar(Categoria c);
    boolean remover(int id_categoria);
    List<Categoria> listAll();
    Categoria ListById(int id_categoria);
    List<Categoria> ListByNome(String nome);
}
