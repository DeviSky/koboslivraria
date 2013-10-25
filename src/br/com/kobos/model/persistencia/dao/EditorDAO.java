
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Editor;
import java.util.List;

public interface EditorDAO {
    int salvar (Editor e);
    boolean remove (int id_editor);
    List<Editor> listAll();
    Editor ListById(int id_autor);
    List<Editor> ListByNome(String nome);
}
