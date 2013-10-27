
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.LojaDAO;
import br.com.kobos.modelo.Loja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LojaDAOImplements implements LojaDAO{
    private static final String INSERT = "insert into FORNECEDOR (nome_us, sobrenome_us, email_us) values (?, ?, ?);";
    private static final String REMOVE = "delete from FORNECEDOR where id_funcionario = ?;";
    private static final String UPDATE = "update FORNECEDOR set nome_us = ?, sobrenome_us = ?, email_us = ?";
    private static final String LIST = "select * from FORNECEDOR;";
    private static final String LISTBYID = "select * from FORNECEDOR where id_funcionario = ?";
    private static final String LISTBYNOME = "select * from FORNECEDOR where nome_au like ?";
    private static final String LISTBYSOBRENOME = "select * from FORNECEDOR where sobrenome_au like ?";

    @Override
    public int salvar(Loja l) {
        if (l.getId_loja() == 0){
            return inserir(l);
        }else{
            return update(l);
        }
    }
    
    public int inserir(Loja l){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, l.getNome());
            pstm.setString(2, l.getTelefone());
            pstm.setString(3, l.getEndereco());
            pstm.execute();
            try(ResultSet rs = pstm.getGeneratedKeys()){
                if(rs.next()){
                    retorno = rs.getInt(1);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao adicionar um cadastro "+ e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm);
            }catch (Exception e){
               JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return retorno;
    }

    @Override
    public boolean remove(int id_loja) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_loja);
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
    public List<Loja> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Loja> lojas = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Loja l = new Loja();
                l.setNome(rs.getString("nome_fn"));
                l.setTelefone(rs.getString("telefone_fn"));
                l.setEndereco(rs.getString("endereco_fn"));
                lojas.add(l);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar lojas " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return lojas;
    }

    @Override
    public Loja ListById(int id_loja) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Loja l = new Loja();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while (rs.next()){
                l.setNome(rs.getString("nome_lj"));
                l.setTelefone(rs.getString("telefone_lj"));
                l.setEndereco(rs.getString("endereco_lj"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar lojas " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return l;
    }

    @Override
    public List<Loja> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Loja> lojas = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            rs = pstm.executeQuery();
            while(rs.next()){
                Loja l = new Loja();
                l.setNome(rs.getString("nome_fn"));
                l.setTelefone(rs.getString("telefone_fn"));
                l.setEndereco(rs.getString("endereco_fn"));
                lojas.add(l);
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
        return lojas;
    }
    
    
    public int update(Loja l){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, l.getNome());
            pstm.setString(2, l.getTelefone());
            pstm.setString(3, l.getEndereco());
            pstm.execute();
            retorno = l.getId_loja();
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
