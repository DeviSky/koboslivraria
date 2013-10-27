
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.VendaDAOImplements;
import br.com.kobos.model.persistencia.dao.VendasDAO;
import br.com.kobos.modelo.Venda;
import java.util.List;

public class VendaController {
    
    public int salvar(Venda v){
        VendasDAO dao = new VendaDAOImplements();
        return dao.salvar(v);        
    }
    
    public List<Venda> listAll(){
        VendasDAO dao = new VendaDAOImplements();
        return dao.listAll();
    }
    
    public Venda ListById(int id_vendas){
        VendasDAO dao = new VendaDAOImplements();
        return dao.ListById(id_vendas);        
    }
    
    public boolean remover(int id_vendas){
        VendasDAO dao = new VendaDAOImplements();
        return dao.remove(id_vendas);
    }
}
