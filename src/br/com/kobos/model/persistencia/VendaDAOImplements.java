
package br.com.kobos.model.persistencia;
 
import br.com.kobos.model.persistencia.dao.VendasDAO;
import br.com.kobos.modelo.Venda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VendaDAOImplements implements VendasDAO{
    private static final String INSERT = "insert into FORNECEDOR (nome_us, sobrenome_us, email_us) values (?, ?, ?);";
    private static final String REMOVE = "delete from FORNECEDOR where id_funcionario = ?;";
    private static final String UPDATE = "update FORNECEDOR set nome_us = ?, sobrenome_us = ?, email_us = ?";
    private static final String LIST = "select * from FORNECEDOR;";
    private static final String LISTBYID = "select * from FORNECEDOR where id_funcionario = ?";
    private static final String LISTBYNOME = "select * from FORNECEDOR where nome_au like ?";
    private static final String LISTBYSOBRENOME = "select * from FORNECEDOR where sobrenome_au like ?";

    @Override
    public int salvar(Venda v) {
        if (v.getId_vendas()== 0){
            return inserir(v);
        }else{
            return update(v);
        }
    }
    
    public int inserir(Venda v){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, v.getQuantidade());
            pstm.setDate(2, v.getDtVenda());
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
    public boolean remove(int id_vendas) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_vendas);
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
    public List<Venda> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Venda> vendas = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Venda v = new Venda();
                v.setQuantidade(rs.getInt("nome_fn"));
                v.setDtVenda(rs.getDate("telefone_fn"));
                vendas.add(v);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar vendas " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return vendas;
    }

    @Override
    public Venda ListById(int id_fornecedor) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Venda v = new Venda();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while (rs.next()){
                v.setQuantidade(rs.getInt("nome_fn"));
                v.setDtVenda(rs.getDate("telefone_fn"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar vendas " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return v;
    }
   
    
    public int update(Venda v){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setInt(1, v.getQuantidade());
            pstm.setDate(2, v.getDtVenda());
            pstm.execute();
            retorno = v.getId_vendas();
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
