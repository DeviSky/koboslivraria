
package br.com.kobos.model.persistencia.dao;

import br.com.kobos.modelo.Usuario;
import java.util.List;

public interface UsuarioDAO {
    int salvar(Usuario us);
    boolean remove(int id_usuario);
    List<Usuario> ListAll();
    Usuario ListById(int id_usuario);
    List<Usuario> ListByNome(String nome);
    boolean validaUsuario(String usuario, String senha);
    
}
