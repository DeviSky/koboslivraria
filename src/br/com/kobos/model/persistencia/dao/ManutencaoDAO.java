
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Manutencao;
import java.util.List;

public interface ManutencaoDAO {
    int salvar (Manutencao m);
    boolean remove(int id_manutencao);
    List<Manutencao> listAll();
    Manutencao listById(int id_fornecedor);
    List<Manutencao> ListByNome(String nome);
}
