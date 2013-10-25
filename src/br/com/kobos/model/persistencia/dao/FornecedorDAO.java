
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Fornecedor;
import java.util.List;

public interface FornecedorDAO {
    int salvar (Fornecedor f);
    boolean remove (int id_fornecedor);
    List<Fornecedor> listAll();
    Fornecedor ListById(int id_fornecedor);
    List<Fornecedor> ListByNome(String nome);
}
