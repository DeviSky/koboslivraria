
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.LivroDAOImplements;
import br.com.kobos.model.persistencia.dao.LivroDAO;
import br.com.kobos.modelo.Livro;
import java.util.List;

public class LivroController {
    
    public int salvar(Livro l){
        LivroDAO dao = new LivroDAOImplements();
        return dao.salvar(l);
    }
    
    public List<Livro> listAll(){
        LivroDAO dao = new LivroDAOImplements();
        return dao.listAll();
    }
    
    public List<Livro> ListByNome(String nome){
        LivroDAO dao = new LivroDAOImplements();
        return dao.ListByNome(nome);
    }
    
    public Livro ListByID(int id_livro){
        LivroDAO dao = new LivroDAOImplements();
        return dao.ListById(id_livro);        
    }
    
    public boolean remover(int id_livro){
        LivroDAO dao = new LivroDAOImplements();
        return dao.remove(id_livro);
    }
}
