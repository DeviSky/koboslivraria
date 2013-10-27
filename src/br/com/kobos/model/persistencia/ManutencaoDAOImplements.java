
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.ManutencaoDAO;
import br.com.kobos.modelo.Manutencao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ManutencaoDAOImplements implements ManutencaoDAO{
    private static final String INSERT = "insert into FORNECEDOR (nome_us, sobrenome_us, email_us) values (?, ?, ?);";
    private static final String REMOVE = "delete from FORNECEDOR where id_funcionario = ?;";
    private static final String UPDATE = "update FORNECEDOR set nome_us = ?, sobrenome_us = ?, email_us = ?";
    private static final String LIST = "select * from FORNECEDOR;";
    private static final String LISTBYID = "select * from FORNECEDOR where id_funcionario = ?";
    private static final String LISTBYNOME = "select * from FORNECEDOR where nome_au like ?";
    private static final String LISTBYSOBRENOME = "select * from FORNECEDOR where sobrenome_au like ?";

    @Override
    public int salvar(Manutencao m) {
        if (m.getId_manutencao() == 0){
            return inserir(m);
        }else{
            return update(m);
        }
    }
    
    public int inserir(Manutencao m){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, m.getMotivo());
            pstm.setString(2, m.getTipo());
            pstm.setDate(3, m.getData());
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
    public boolean remove(int id_manutencao) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_manutencao);
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
    public List<Manutencao> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Manutencao> manutencoes = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Manutencao m = new Manutencao();
                m.setMotivo(rs.getString("nome_fn"));
                m.setTipo(rs.getString("telefone_fn"));
                m.setData(rs.getDate("endereco_fn"));
                manutencoes.add(m);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar manutencoes " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return manutencoes;
    }

    @Override
    public Manutencao listById(int id_manutencao) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Manutencao m = new Manutencao();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while (rs.next()){
                m.setMotivo(rs.getString("nome_fn"));
                m.setTipo(rs.getString("telefone_fn"));
                m.setData(rs.getDate("endereco_fn"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar manutencoes " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return m;
    }

    @Override
    public List<Manutencao> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Manutencao> manutencoes = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            rs = pstm.executeQuery();
            while(rs.next()){
                Manutencao m = new Manutencao();
                m.setMotivo(rs.getString("nome_fn"));
                m.setTipo(rs.getString("telefone_fn"));
                m.setData(rs.getDate("endereco_fn"));
                manutencoes.add(m);
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
        return manutencoes;
    }
    
    
    public int update(Manutencao m){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, m.getMotivo());
            pstm.setString(2, m.getTipo());
            pstm.setDate(3, m.getData());
            pstm.execute();
            retorno = m.getId_manutencao();
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
