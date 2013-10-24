
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.AutorDAOImplements;
import br.com.kobos.model.persistencia.dao.AutorDAO;
import br.com.kobos.model.persistencia.dao.UsuarioDAO;
import br.com.kobos.modelo.Autor;
import java.util.List;

public class AutorController {
    
    public int salvar(Autor a){
        AutorDAO dao = new AutorDAOImplements();
        return dao.salvar(a);
    }
    
    public List<Autor> listAll(){
        AutorDAO dao = new AutorDAOImplements();
        return dao.listAll();
    }
    
    public Autor ListById(int id_autor){
        AutorDAO dao = new AutorDAOImplements();
        return dao.ListById(id_autor);
    }
    
    public List<Autor> ListByNome(String nome){
        AutorDAO dao = new AutorDAOImplements();
        return dao.ListByNome(nome);       
    }
    
    public List<Autor> ListBySobrenome(String sobrenome){
        AutorDAO dao = new AutorDAOImplements();
        return dao.ListBySobrenome(sobrenome);
    }
    
    public boolean remover(int id_autor){
        AutorDAO dao = new AutorDAOImplements();
        return dao.remove(id_autor);
    }
}
