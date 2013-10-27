
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.FornecedorDAOImplements;
import br.com.kobos.model.persistencia.dao.FornecedorDAO;
import br.com.kobos.modelo.Fornecedor;
import java.util.List;

public class FornecedorController {
    public int salvar(Fornecedor a){
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.salvar(a);
    }
    
    public List<Fornecedor> listAll(){
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.listAll();
    }
    
    public Fornecedor ListById(int id_fornecedor){
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.ListById(id_fornecedor);
    }
    
    public List<Fornecedor> ListByNome(String nome){
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.ListByNome(nome);       
    }

    public boolean remover(int id_fornecedor){
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.remove(id_fornecedor);
    }
    
}
