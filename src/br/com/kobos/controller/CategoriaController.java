
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.CategoriaDAOImplements;
import br.com.kobos.model.persistencia.dao.CategoriaDAO;
import br.com.kobos.modelo.Categoria;
import java.util.List;

public class CategoriaController {
    
    public int salvar(Categoria c){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.salvar(c);
    }
    
    public List<Categoria> listAll(){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.listAll();
    }
    
    public Categoria ListById(int id_categoria){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.ListById(id_categoria);
    }
    
    public List<Categoria> ListByNome(String nome){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.ListByNome(nome);
    }
    
    public boolean remover(int id_categoria){
        CategoriaDAO dao = new CategoriaDAOImplements();
        return dao.remover(id_categoria);
    }
    
}
