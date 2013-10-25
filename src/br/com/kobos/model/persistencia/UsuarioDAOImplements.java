
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.UsuarioDAO;
import br.com.kobos.modelo.Funcionario;
import br.com.kobos.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAOImplements implements UsuarioDAO{
    
    private static final String INSERT = "insert into USUARIO (nome_us, usuario_us, senha_us, nivelAcesso_us) values (?, ?, ?, ?)" ;
    private static final String REMOVE = "delete from USUARIO where id_usuario = ?;";
    private static final String LIST = "Select * from USUARIO;";
    private static final String UPDATE = "update USUARIO set nome_us = ?, usuario_us = ?, senha_us = ?, nivelAcesso_us = ? where id_usuario = ?;";
    private static final String LISTBYID = "select * from USUARIO where id_usuario = ?";
    private static final String LISTBYNOME = "select * from USUARIO where nome_us like ?;";
    
    @Override
    public int salvar(Usuario us) {
        if (us.getId_usuario() == 0){
            return inserir(us);            
        }else{
            return update(us);
        }
    }
    
    public int inserir (Usuario us){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, us.getNome_us());
            pstm.setString(2, us.getUsuario_us());
            pstm.setString(3, us.getSenha_us());
            pstm.setString(4, us.getNivelAcesso_us());
            pstm.execute();
            try(ResultSet rs = pstm.getGeneratedKeys()){
                if(rs.next()){
                    retorno = rs.getInt(1);
                }                
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao cadastrar um usuário "+ e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e );
            }
        }
        return -1;
    }

    @Override
    public boolean remove(int id_usuario) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_usuario);
            pstm.execute();
            status = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao excluir usuário " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco "+ e);
            }
        }
        return status;
    }

    @Override
    public List<Usuario> ListAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Usuario u = new Usuario();
                u.setNome_us(rs.getString("nome_us"));
                u.setUsuario_us(rs.getString("usuario_us"));
                u.setSenha_us(rs.getString("senha_us"));
                u.setNivelAcesso_us(rs.getString("nivelAcesso_us"));
                usuarios.add(u);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar usuários " + e);            
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco "+ e);
            }
        }
        return usuarios;
    }

    @Override
    public Usuario ListById(int id_usuario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Usuario u = new Usuario();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while (rs.next()){
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome_us(rs.getString("nome_us"));
                u.setUsuario_us(rs.getString("usuario_us"));
                u.setSenha_us(rs.getString("senha_us"));
                u.setNivelAcesso_us(rs.getString("nivelAcesso_us"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar por código " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconctar com o banco " + e);
            }
        }
        return u;
    }

    @Override
    public List<Usuario> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            rs = pstm.executeQuery();
            while (rs.next()){
                Usuario u = new Usuario();
                u.setId_usuario(rs.getInt("id_usuario"));
                u.setNome_us(rs.getString("nome_us"));
                u.setUsuario_us(rs.getString("usuario_us"));
                u.setSenha_us(rs.getString("senha_us"));
                u.setNivelAcesso_us(rs.getString("nivelAcesso_us"));
                usuarios.add(u);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar usuários por nome " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return usuarios;
    }
    
    public int update(Usuario u){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, u.getNome_us());
            pstm.setString(2, u.getUsuario_us());
            pstm.setString(3, u.getSenha_us());
            pstm.setString(4, u.getNivelAcesso_us());
            pstm.execute();
            retorno = u.getId_usuario();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar usuário " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco "+ e);
            }
        }
        return retorno;
    }
       
}
