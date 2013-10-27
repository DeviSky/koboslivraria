
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Loja;
import java.util.List;

public interface LojaDAO {
    int salvar(Loja l);
    boolean remove (int id_loja);
    List<Loja> listAll();
    Loja ListById(int id_loja);
    List<Loja> ListByNome(String nome);
}
