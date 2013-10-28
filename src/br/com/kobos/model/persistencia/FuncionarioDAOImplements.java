
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.FuncionarioDAO;
import br.com.kobos.modelo.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAOImplements implements FuncionarioDAO{
    private static final String INSERT = "insert into FORNECEDOR (nome_fn, telefone_fn, bairro_fn, rg_fn, cidade_fn, endereco_fn, cpf_fn, salario_fn, funcao_fn, ctps_fn, LOJA_id_loja, USUARIO_id_usuario) values ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String REMOVE = "delete from FORNECEDOR where id_funcionario = ?;";
    private static final String UPDATE = "update FORNECEDOR set nome_fn = ?, telefone_fn = ?, bairro_fn = ?, rg_fn = ?, cidade_fn = ?, endereco_fn = ?, cpf_fn = ?, salario_fn = ?, funcao_fn = ?, ctps_fn = ?, LOJA_id_loja = ?, USUARIO_id_usuario = ? where id_funcionario = ?";
    private static final String LIST = "select * from FORNECEDOR;";
    private static final String LISTBYID = "select * from FORNECEDOR where id_funcionario = ?";
    private static final String LISTBYNOME = "select * from FORNECEDOR where nome_fn like ?";

    @Override
    public int salvar(Funcionario f) {
        if (f.getId_funcionario() == 0){
            return inserir(f);
        }else{
            return update(f);
        }
    }
    
    public int inserir(Funcionario f){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getTelefone());
            pstm.setString(3, f.getBairro());
            pstm.setString(4, f.getRg());
            pstm.setString(5, f.getCidade());
            pstm.setString(6, f.getEndereco());
            pstm.setString(7, f.getCpf());
            pstm.setDouble(8, f.getSalario());
            pstm.setString(9, f.getFuncao());
            pstm.setString(10, f.getCtps());
            pstm.setInt(11, f.getLOJA_id_loja());
            pstm.setInt(12, f.getUSUARIO_id_usuario());
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
    public List<Funcionario> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome_fn"));
                f.setTelefone(rs.getString("telefone_fn"));
                f.setBairro(rs.getString("bairro_fn"));
                f.setRg(rs.getString("rg_fn"));
                f.setCidade(rs.getString("cidade_fn"));
                f.setEndereco(rs.getString("endereco_fn"));
                f.setCpf(rs.getString("cpf_fn"));
                f.setSalario(rs.getDouble("salario_fn"));
                f.setLOJA_id_loja(rs.getInt("LOJA_id_loja"));
                f.setUSUARIO_id_usuario(rs.getInt("USUARIO_id_usuario"));
                funcionarios.add(f);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar funcionarios " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return funcionarios;
    }

    @Override
    public Funcionario ListById(int id_funcionario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Funcionario f = new Funcionario();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while (rs.next()){
                f.setNome(rs.getString("nome_fn"));
                f.setTelefone(rs.getString("telefone_fn"));
                f.setBairro(rs.getString("bairro_fn"));
                f.setRg(rs.getString("rg_fn"));
                f.setCidade(rs.getString("cidade_fn"));
                f.setEndereco(rs.getString("endereco_fn"));
                f.setCpf(rs.getString("cpf_fn"));
                f.setSalario(rs.getDouble("salario_fn"));
                f.setLOJA_id_loja(rs.getInt("LOJA_id_loja"));
                f.setUSUARIO_id_usuario(rs.getInt("USUARIO_id_usuario"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar funcionarios " + e);
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
    public List<Funcionario> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            rs = pstm.executeQuery();
            while(rs.next()){
                Funcionario f = new Funcionario();
                f.setNome(rs.getString("nome_fn"));
                f.setTelefone(rs.getString("telefone_fn"));
                f.setBairro(rs.getString("bairro_fn"));
                f.setRg(rs.getString("rg_fn"));
                f.setCidade(rs.getString("cidade_fn"));
                f.setEndereco(rs.getString("endereco_fn"));
                f.setCpf(rs.getString("cpf_fn"));
                f.setSalario(rs.getDouble("salario_fn"));
                f.setLOJA_id_loja(rs.getInt("LOJA_id_loja"));
                f.setUSUARIO_id_usuario(rs.getInt("USUARIO_id_usuario"));
                funcionarios.add(f);
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
        return funcionarios;
    }
    
    
    public int update(Funcionario f){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getTelefone());
            pstm.setString(3, f.getBairro());
            pstm.setString(4, f.getRg());
            pstm.setString(5, f.getCidade());
            pstm.setString(6, f.getEndereco());
            pstm.setString(7, f.getCpf());
            pstm.setDouble(8, f.getSalario());
            pstm.setString(9, f.getFuncao());
            pstm.setString(10, f.getCtps());
            pstm.setInt(11, f.getLOJA_id_loja());
            pstm.setInt(12, f.getUSUARIO_id_usuario());
            pstm.execute();
            retorno = f.getId_funcionario();
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
