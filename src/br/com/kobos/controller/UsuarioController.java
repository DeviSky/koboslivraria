package br.com.kobos.controller;

import br.com.kobos.model.persistencia.UsuarioDAOImplements;
import br.com.kobos.model.persistencia.dao.UsuarioDAO;
import br.com.kobos.modelo.Usuario;
import java.util.List;

public class UsuarioController {
    
    public int salvar(Usuario u){
        UsuarioDAO dao = new UsuarioDAOImplements();
        return dao.salvar(u);
    }
    
    public List<Usuario> listAll(){
        UsuarioDAO dao = new UsuarioDAOImplements();
        return dao.ListAll();
    }
    
    public Usuario ListById(int id_usuario){
        UsuarioDAO dao = new UsuarioDAOImplements();
        return dao.ListById(id_usuario);
    }
    
    public List<Usuario> ListByNome(String nome){
        UsuarioDAO dao = new UsuarioDAOImplements();
        return dao.ListByNome(nome);
    }
    
    public boolean remover(int id_usuario){
        UsuarioDAO dao = new UsuarioDAOImplements();
        return dao.remove(id_usuario);
    }
    
    public boolean ValidaUsuario(String usuario, String senha){
        UsuarioDAO dao = new UsuarioDAOImplements();
        return dao.validaUsuario(usuario, senha);
    }
    
}
