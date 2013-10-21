
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.UsuarioDAO;
import br.com.kobos.modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAOImplements implements UsuarioDAO{
    
    private static final String INSERT = "insert into USUARIO (nome_us, usuario_us, senha_us, nivelAcesso_us, id_funcionario, id_loja) values (?, ?, ?, ?, ?, ?)" ;
    private static final String REMOVE = "delete from USUARIO where id_usuario = ?;";
    private static final String LIST = "Select * from USUARIO;";
    private static final String UPDATE = "update USUARIO set nome_us = ?, usuario_us = ?, senha_us = ?, nivelAcesso_us = ?, id_funcionario = ?, id_loja = ? where id_usuario = ?;";
    private static final String LISTBYID = "select * from USUARIO where id_usuario = ?";
    private static final String LISTBYNOME = "select * from USUARIO where nome_us like ?;";
    
    @Override
    public int salvar(Usuario us) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            pstm.setInt(5, us.getId_funcionario().getId_funcionario());
            pstm.setInt(6, us.getId_loja().getId_loja());
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
            status = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao excluir usuário " + e);
        }finally{
            try{
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco "+ e);
            }
        }
        return status;
    }

    @Override
    public List<Usuario> ListAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario ListById(int id_usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> ListByNome(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}