
package br.com.kobos.controller;

import br.com.kobos.model.persistencia.EditorDAOImplements;
import br.com.kobos.model.persistencia.dao.EditorDAO;
import br.com.kobos.modelo.Editor;
import java.util.List;

public class EditorController {
    public int salvar(Editor ed){
        EditorDAO dao = new EditorDAOImplements();
        return dao.salvar(ed);
    }
    
    public List<Editor> listAll(){
        EditorDAO dao = new EditorDAOImplements();
        return dao.listAll();
    }
    
    public Editor ListById(int id_editor){
        EditorDAO dao = new EditorDAOImplements();
        return dao.ListById(id_editor);
    }
    
    public List<Editor> ListByNome(String nome){
        EditorDAO dao = new EditorDAOImplements();
        return dao.ListByNome(nome);       
    }    
    
    public boolean remover(int id_editor){
        EditorDAO dao = new EditorDAOImplements();
        return dao.remove(id_editor);
    }
}
