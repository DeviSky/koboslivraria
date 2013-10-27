
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Funcionario;
import java.util.List;

public interface FuncionarioDAO {
    int salvar (Funcionario f);
    boolean remove (int id_funcionario);
    List<Funcionario> listAll();
    Funcionario ListById(int id_funcionario);
    List<Funcionario> ListByNome(String nome);  
}
