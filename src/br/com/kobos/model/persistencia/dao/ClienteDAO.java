
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Cliente;
import java.util.List;

public interface ClienteDAO {
    int salvar(Cliente c);
    boolean remove(int id_cliente);
    List<Cliente> listAll();
    Cliente listById(int id_cliente);
    List<Cliente> ListByNome(String nome);
}
