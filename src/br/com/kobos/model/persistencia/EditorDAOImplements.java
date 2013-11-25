
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.EditorDAO;
import br.com.kobos.modelo.Editor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EditorDAOImplements implements EditorDAO{
    
    private static final String INSERT = "Insert into EDITORA (nome_ed, email_ed, url_ed, endereco_ed, cidade_ed) values (?, ?, ?, ?, ?)";
    private static final String REMOVE = "delete from EDITORA where id_editora = ?";
    private static final String UPDATE = "update EDITORA set nome_ed = ?, email_ed = ?, url_ed = ?, endereco_ed = ?, cidade_ed = ? where id_editora = ?";
    private static final String LIST = "select * EDITORA";
    private static final String LISTBYID = "select * EDITORA where id_editora = ?";
    private static final String LISTBYNOME = "select * from EDITORA where nome_ed like ?";

    @Override
    public int salvar(Editor e) {
        if (e.getId_editor() == 0){
            return inserir(e);
        }else{
            return update(e);
        }
    }
    
    public int inserir(Editor e){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, e.getNome());
            pstm.setString(3, e.getEmail());
            pstm.setString(4, e.getUrl());
            pstm.setString(5, e.getCidade());
            pstm.setString(6, e.getEndereco());
            pstm.execute();
            try(ResultSet rs = pstm.getGeneratedKeys()){
                if(rs.next()){
                    retorno = rs.getInt(1);
                }
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Erro ao adicionar um cadastro "+ e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm);
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Erro ao desconetar ao banco " + ex);
            }
        }
        return retorno;
    }

    @Override
    public boolean remove(int id_editora) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_editora);
            pstm.execute();
            status = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao deletar registro " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return status;
    }

    @Override
    public List<Editor> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Editor> editores = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Editor ed = new Editor();
                ed.setId_editor(rs.getInt("id_editora"));
                ed.setNome(rs.getString("nome_ed"));
                ed.setEmail(rs.getString("email_ed"));
                ed.setUrl(rs.getString("url_ed"));
                ed.setCidade(rs.getString("cidade_ed"));
                ed.setEndereco(rs.getString("endereco_ed"));
                editores.add(ed);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar editores " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return editores;
    }

    @Override
    public Editor ListById(int id_editor) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Editor ed = new Editor();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id_editor);
            rs = pstm.executeQuery();
            while (rs.next()){
                ed.setId_editor(rs.getInt("id_editora"));
                ed.setNome(rs.getString("nome_ed"));
                ed.setEmail(rs.getString("email_ed"));
                ed.setUrl(rs.getString("url_ed"));
                ed.setCidade(rs.getString("cidade_ed"));
                ed.setEndereco(rs.getString("endereco_ed"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar editores " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return ed;
    }

    @Override
    public List<Editor> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Editor> editores = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                Editor ed = new Editor();
                ed.setId_editor(rs.getInt("id_editora"));
                ed.setNome(rs.getString("nome_ed"));
                ed.setEmail(rs.getString("email_ed"));
                ed.setUrl(rs.getString("url_ed"));
                ed.setCidade(rs.getString("cidade_ed"));
                ed.setEndereco(rs.getString("endereco_ed"));
                editores.add(ed);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar autor por nome " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return editores;
    }
    
    public int update(Editor ed){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, ed.getNome());
            pstm.setString(3, ed.getEmail());
            pstm.setString(4, ed.getUrl());
            pstm.setString(5, ed.getCidade());
            pstm.setString(6, ed.getEndereco());
            pstm.execute();
            retorno = ed.getId_editor();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao atualizar cadastro " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return retorno;
    }
}
