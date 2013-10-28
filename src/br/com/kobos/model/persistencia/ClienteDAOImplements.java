
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.ClienteDAO;
import br.com.kobos.modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAOImplements implements ClienteDAO{
    
    private static final String INSERT = "insert into CLIENTE (nome_cl, telefone_cl, bairro_cl, rg_cl, cidade_cl, endereco_cl, LOJA_id_loja) values (?, ?, ?, ?, ?, ?, ?);";
    private static final String REMOVE = "delete from CLIENTE where id_cliente = ?";
    private static final String UPDATE = "update CLIENTE set nome_cl = ?, telefone_cl = ?, bairro_cl = ?, rg_cl = ?, cidade_cl = ?, endereco_cl = ?, LOJA_id_loja = ? where id_cliente = ?";
    private static final String LIST = "select * CLIENTE";
    private static final String LISTBYID = "select * CLIENTE where id_cliente = ?";
    private static final String LISTBYNOME = "select * from CLIENTE where nome_cl like ?";

    @Override
    public int salvar(Cliente c) {
        if(c.getId_cliente()== 0){
            return inserir(c);
        }else{
            return update(c);
        }
    }
    
    public int inserir(Cliente c){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getTelefone());
            pstm.setString(3, c.getRg());
            pstm.setString(4, c.getEndereco());
            pstm.setString(5, c.getCidade());
            pstm.setString(6, c.getBairro());
            pstm.setInt(7, c.getLOJA_id_loja());
            pstm.execute();
            try(ResultSet rs = pstm.getGeneratedKeys()){
                if(rs.next()){
                    retorno = rs.getInt(1);
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao inserir cliente " + e);
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
    public boolean remove(int id_cliente) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_cliente);
            pstm.execute();
            status = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao remover cadastro " + e);
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
    public List<Cliente> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome_cl"));
                c.setTelefone(rs.getString("telefone_cl"));
                c.setRg(rs.getString("rg_cl"));
                c.setCidade(rs.getString("cidade_cl"));
                c.setBairro(rs.getString("bairro_cl"));
                c.setEndereco(rs.getString("endereco_cl"));
                c.setLOJA_id_loja(rs.getInt("LOJA_id_loja"));
                clientes.add(c);                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar clientes "+ e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco "+ e);
            }
        }
        return clientes;        
    }

    @Override
    public Cliente listById(int id_cliente) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente c = new Cliente();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while(rs.next()){
                c.setNome(rs.getString("nome_cl"));
                c.setTelefone(rs.getString("telefone_cl"));
                c.setRg(rs.getString("rg_cl"));
                c.setCidade(rs.getString("cidade_cl"));
                c.setBairro(rs.getString("bairro_cl"));
                c.setEndereco(rs.getString("endereco_cl"));
                c.setLOJA_id_loja(rs.getInt("LOJA_id_loja"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar clientes por código " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return c;
    }

    @Override
    public List<Cliente> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            rs = pstm.executeQuery();
            while(rs.next()){
                Cliente c = new Cliente();
                c.setNome(rs.getString("nome_cl"));
                c.setTelefone(rs.getString("telefone_cl"));
                c.setRg(rs.getString("rg_cl"));
                c.setCidade(rs.getString("cidade_cl"));
                c.setBairro(rs.getString("bairro_cl"));
                c.setEndereco(rs.getString("endereco_cl"));
                c.setLOJA_id_loja(rs.getInt("LOJA_id_loja"));
                clientes.add(c);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar cliente por nome " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return clientes;
    }
    
    public int update(Cliente c){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getTelefone());
            pstm.setString(3, c.getRg());
            pstm.setString(4, c.getCidade());
            pstm.setString(5, c.getBairro());
            pstm.setString(6, c.getEndereco());
            pstm.setInt(7, c.getLOJA_id_loja());
            pstm.execute();
            retorno = c.getId_cliente();
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