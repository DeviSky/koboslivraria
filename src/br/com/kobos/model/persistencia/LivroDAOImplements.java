
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.LivroDAO;
import br.com.kobos.modelo.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LivroDAOImplements implements LivroDAO{
    private static final String INSERT = "insert into FORNECEDOR (nome_us, sobrenome_us, email_us) values (?, ?, ?);";
    private static final String REMOVE = "delete from FORNECEDOR where id_funcionario = ?;";
    private static final String UPDATE = "update FORNECEDOR set nome_us = ?, sobrenome_us = ?, email_us = ?";
    private static final String LIST = "select * from FORNECEDOR;";
    private static final String LISTBYID = "select * from FORNECEDOR where id_funcionario = ?";
    private static final String LISTBYNOME = "select * from FORNECEDOR where nome_au like ?";
    private static final String LISTBYSOBRENOME = "select * from FORNECEDOR where sobrenome_au like ?";

    @Override
    public int salvar(Livro f) {
        if (f.getId_livro() == 0){
            return inserir(f);
        }else{
            return update(f);
        }
    }
    
    public int inserir(Livro l){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, l.getTitulo());
            pstm.setString(2, l.getSubtitulo());
            pstm.setString(3, l.getTema());            
            pstm.setString(4, l.getPalavrasChave());
            pstm.setString(5, l.getEdicao());
            pstm.setInt(6, l.getIsbn());
            pstm.setDouble(7, l.getPreco());
            pstm.setInt(3, l.getQtEstoque());
            pstm.setDouble(3, l.getVolume());
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
    public boolean remove(int id_livro) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_livro);
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
    public List<Livro> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Livro> livros = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Livro l = new Livro();
                l.setTitulo(rs.getString("nome_fn"));
                l.setSubtitulo(rs.getString("telefone_fn"));
                l.setTema(rs.getString("endereco_fn"));
                l.setResumo(rs.getString("endereco_fn"));
                l.setPalavrasChave(rs.getString("endereco_fn"));
                l.setEdicao(rs.getString("endereco_fn"));
                l.setVolume(rs.getDouble("endereco_fn"));
                l.setPreco(rs.getDouble("endereco_fn"));
                l.setQtEstoque(rs.getInt("endereco_fn"));
                l.setIsbn(rs.getInt("endereco_fn"));
                
                livros.add(l);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar livros " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return livros;
    }

    @Override
    public Livro ListById(int id_livro) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Livro l = new Livro();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            rs = pstm.executeQuery();
            while (rs.next()){
                l.setTitulo(rs.getString("nome_fn"));
                l.setSubtitulo(rs.getString("telefone_fn"));
                l.setTema(rs.getString("endereco_fn"));
                l.setResumo(rs.getString("endereco_fn"));
                l.setPalavrasChave(rs.getString("endereco_fn"));
                l.setEdicao(rs.getString("endereco_fn"));
                l.setVolume(rs.getDouble("endereco_fn"));
                l.setPreco(rs.getDouble("endereco_fn"));
                l.setQtEstoque(rs.getInt("endereco_fn"));
                l.setIsbn(rs.getInt("endereco_fn"));                
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar livros " + e);
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
    public List<Livro> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Livro> livros = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            rs = pstm.executeQuery();
            while(rs.next()){
                Livro l = new Livro();
                l.setTitulo(rs.getString("nome_fn"));
                l.setSubtitulo(rs.getString("telefone_fn"));
                l.setTema(rs.getString("endereco_fn"));
                l.setResumo(rs.getString("endereco_fn"));
                l.setPalavrasChave(rs.getString("endereco_fn"));
                l.setEdicao(rs.getString("endereco_fn"));
                l.setVolume(rs.getDouble("endereco_fn"));
                l.setPreco(rs.getDouble("endereco_fn"));
                l.setQtEstoque(rs.getInt("endereco_fn"));
                l.setIsbn(rs.getInt("endereco_fn"));
                livros.add(l);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar livro por titulo " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return livros;
    }
    
    
    public int update(Livro f){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, f.getTitulo());
            pstm.setString(2, f.getSubtitulo());
            pstm.setString(3, f.getTema());            
            pstm.setString(4, f.getPalavrasChave());
            pstm.setString(5, f.getEdicao());
            pstm.setInt(6, f.getIsbn());
            pstm.setDouble(7, f.getPreco());
            pstm.setInt(3, f.getQtEstoque());
            pstm.setDouble(3, f.getVolume());
            pstm.execute();
            retorno = f.getId_livro();
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
