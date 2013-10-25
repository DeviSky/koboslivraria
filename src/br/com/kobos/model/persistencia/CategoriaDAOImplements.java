
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.CategoriaDAO;
import br.com.kobos.modelo.Categoria;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CategoriaDAOImplements implements CategoriaDAO{
    
    private static final String INSERT = "Insert into Categoria ()";
    private static final String REMOVE = "delete from CATEGORIA where id_categoria = ?";
    private static final String UPDATE = "update CATEGORIA set nome_ct";
    private static final String LIST = "select * from CATEGORIA";
    private static final String LISTBYID = "select * from CATEGORIA where id_categoria = ?";
    private static final String LISTBYNOME = "select * from CATEGORIA where nome_ct like ?";

    @Override
    public int salvar(Categoria c) {
        if(c.getId_tipo() == 0){
            return inserir(c);
        }else{
            return update(c);
        }
    }
    
    public int inserir(Categoria c){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, c.getDescricao());
            pstm.execute();
            try(ResultSet rs = pstm.getGeneratedKeys()){
                if(rs.next()){
                    retorno = rs.getInt(1);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao inserir uma categoria " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return retorno;
    }

    @Override
    public boolean remover(int id_categoria) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_categoria);
            pstm.execute();
            status = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao remover categoria " + e);
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
    public List<Categoria> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setDescricao(rs.getString("descricao_ct"));
                categorias.add(c);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar categorias " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return categorias;
    }

    @Override
    public Categoria ListById(int id_categoria) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Categoria c = new Categoria();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while(rs.next()){
                c.setDescricao(rs.getString("descricao_ct"));                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar por id" + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco" + e);
            }
        }
        return c;
    }

    @Override
    public List<Categoria> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Categoria> categorias = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            rs = pstm.executeQuery();
            while(rs.next()){
                Categoria c = new Categoria();
                c.setId_tipo(rs.getInt("id_categoria"));
                c.setDescricao(rs.getString("descricao_ct"));
                return categorias;
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar por nome " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco "+ e);
            }
        }
        return categorias;
    }
    
    public int update(Categoria c){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, c.getDescricao());
            pstm.execute();
            retorno = c.getId_tipo();
        }catch(Exception e){
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
