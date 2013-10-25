
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.FornecedorDAO;
import br.com.kobos.modelo.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAOImplements implements FornecedorDAO{
    private static final String INSERT = "insert into FORNECEDOR (nome_us, sobrenome_us, email_us) values (?, ?, ?);";
    private static final String REMOVE = "delete from FORNECEDOR where id_funcionario = ?;";
    private static final String UPDATE = "update FORNECEDOR set nome_us = ?, sobrenome_us = ?, email_us = ?";
    private static final String LIST = "select * from FORNECEDOR;";
    private static final String LISTBYID = "select * from FORNECEDOR where id_funcionario = ?";
    private static final String LISTBYNOME = "select * from FORNECEDOR where nome_au like ?";
    private static final String LISTBYSOBRENOME = "select * from FORNECEDOR where sobrenome_au like ?";

    @Override
    public int salvar(Fornecedor f) {
        if (f.getId_fornecedor() == 0){
            return inserir(f);
        }else{
            return update(f);
        }
    }
    
    public int inserir(Fornecedor f){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getTelefone());
            pstm.setString(3, f.getEndereco());
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
    public boolean remove(int id_funcionario) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_funcionario);
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
    public List<Fornecedor> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("nome_fn"));
                f.setTelefone(rs.getString("telefone_fn"));
                f.setEndereco(rs.getString("endereco_fn"));
                fornecedores.add(f);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar fornecedores " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return fornecedores;
    }

    @Override
    public Fornecedor ListById(int id_fornecedor) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Fornecedor f = new Fornecedor();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while (rs.next()){
                f.setNome(rs.getString("nome_fn"));
                f.setTelefone(rs.getString("telefone_fn"));
                f.setEndereco(rs.getString("endereco_fn"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar fornecedores " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return f;
    }

    @Override
    public List<Fornecedor> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedores = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            rs = pstm.executeQuery();
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                f.setNome(rs.getString("nome_fn"));
                f.setTelefone(rs.getString("telefone_fn"));
                f.setEndereco(rs.getString("endereco_fn"));
                fornecedores.add(f);
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
        return fornecedores;
    }
    
    
    public int update(Fornecedor f){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getTelefone());
            pstm.setString(3, f.getEndereco());
            pstm.execute();
            retorno = f.getId_fornecedor();
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
