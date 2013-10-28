
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.ClienteDAOImplements;
import br.com.kobos.model.persistencia.dao.ClienteDAO;
import br.com.kobos.modelo.Cliente;
import java.util.List;

public class ClienteController {
    
    public int salvar(Cliente c){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.salvar(c);
    }
    
    public List<Cliente> listAll(){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.listAll();
    }
    
    public Cliente listById(int id_cliente){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.listById(id_cliente);
    }
    
    public List<Cliente> ListByNome(String nome_cl){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.ListByNome(nome_cl);
    }
    
    public boolean remove(int id_cliente){
        ClienteDAO dao = new ClienteDAOImplements();
        return dao.remove(id_cliente);
    }
}
