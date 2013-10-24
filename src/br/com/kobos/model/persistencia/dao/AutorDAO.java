package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Autor;
import java.util.List;

public interface AutorDAO {
    int salvar (Autor a);
    boolean remove (int id_autor);
    List<Autor> listAll();
    Autor ListById(int id_autor);
    List<Autor> ListByNome(String nome);
    List<Autor> ListBySobrenome(String Sobrenome);
}
