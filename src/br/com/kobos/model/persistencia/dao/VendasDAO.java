
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Venda;
import java.util.List;

public interface VendasDAO {
    int salvar(Venda v);
    boolean remove(int id_venda);
    List<Venda> listAll();
    Venda ListById(int id_venda);
}
