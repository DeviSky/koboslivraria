
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
    private static final String INSERT = "insert into LOJA (nome_lj, endereco_lj, telefone_lj, cep_lj) values (?, ?, ?, ?);";
    private static final String REMOVE = "delete from LOJA where id_loja = ?;";
    private static final String UPDATE = "update LOJA set nome_lj = ?, endereco_lj = ?, telefone_lj = ?, cep_lj = ?";
    private static final String LIST = "select * from LOJA ;";
    private static final String LISTBYID = "select * from LOJA where id_loja = ?";
    private static final String LISTBYNOME = "select * from LOJA where nome_lj like ?";

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
            pstm.setString(2, l.getEndereco());
            pstm.setString(3, l.getTelefone());
            pstm.setString(4, l.getCep());
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
                l.setId_loja(rs.getInt("id_loja"));
                l.setNome(rs.getString("nome_lj"));
                l.setEndereco(rs.getString("endereco_lj"));
                l.setTelefone(rs.getString("telefone_lj"));
                l.setCep(rs.getString("cep_lj"));
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
            pstm.setInt(1, id_loja);
            rs = pstm.executeQuery();
            while (rs.next()){
                l.setId_loja(rs.getInt("id_loja"));
                l.setNome(rs.getString("nome_lj"));
                l.setEndereco(rs.getString("endereco_lj"));
                l.setTelefone(rs.getString("telefone_lj"));
                l.setCep(rs.getString("cep_lj"));
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
            pstm.setString(1, "%" + nome + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                Loja l = new Loja();
                l.setId_loja(rs.getInt("id_loja"));
                l.setNome(rs.getString("nome_lj"));
                l.setEndereco(rs.getString("endereco_lj"));
                l.setTelefone(rs.getString("telefone_lj"));
                l.setCep(rs.getString("cep_lj"));
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
