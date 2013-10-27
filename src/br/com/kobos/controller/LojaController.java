
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.LojaDAOImplements;
import br.com.kobos.model.persistencia.dao.LojaDAO;
import br.com.kobos.modelo.Loja;
import java.util.List;

public class LojaController {
    
    public int salvar(Loja l){
        LojaDAO dao = new LojaDAOImplements();
        return dao.salvar(l);
    }
    
    public List<Loja> ListAll(){
        LojaDAO dao = new LojaDAOImplements();
        return dao.listAll();
    }
    
    public Loja ListById(int id_loja){
        LojaDAO dao = new LojaDAOImplements();
        return dao.ListById(id_loja);        
    }
    
    public List<Loja> listByNome(String nome){
        LojaDAO dao = new LojaDAOImplements();
        return dao.ListByNome(nome);
    }
    
    public boolean remover(int id_loja){
        LojaDAO dao = new LojaDAOImplements();
        return dao.remove(id_loja);
    }
}
