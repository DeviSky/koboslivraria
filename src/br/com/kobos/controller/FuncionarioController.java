
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.FuncionarioDAOImplements;
import br.com.kobos.model.persistencia.dao.FuncionarioDAO;
import br.com.kobos.modelo.Funcionario;
import java.util.List;

public class FuncionarioController {
    
    public int salvar(){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.salvar(null);
    }
    
    public List<Funcionario> listAll(){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.listAll();
    }
    
    public Funcionario ListById(int id_funcionario){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.ListById(id_funcionario);
    }
    
    public List<Funcionario> ListByNome(String nome){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.ListByNome(nome);
    }
    
    public boolean remover(int id_funcionario){
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.remove(id_funcionario);
    }
}
