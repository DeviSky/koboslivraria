
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.LivroDAO;
import br.com.kobos.modelo.Editor;
import br.com.kobos.modelo.Livro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class LivroDAOImplements implements LivroDAO{
    private static final String INSERT = "insert into LIVRO (titulo_lv, subtitulo_lv, palavraChave_lv, preco_lv, royalty_lv, resumo_lv, nEdi_lv, volume_lv, qtEstoque_lv, isbn, LIVROA_id_editora, LOJA_id_loja, id_autor) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String REMOVE = "delete from LIVRO where id_funcionario = ?;";
    private static final String UPDATE = "update LIVRO set titulo_lv = ?, subtitulo_lv = ?, palavraChave_lv = ?, preco_lv = ?, royalty_lv = ?, resumo_lv = ?, nEdi_lv = ?, volume_lv = ?, qtEstoque_lv = ?, isbn = ?, LIVROA_id_editora = ?, LOJA_id_loja = ?, id_autor = ? where id_livro = ?";
    private static final String LIST = "select * from LIVRO, EDITORA, LOJA where livro.EDITORA_id_editora = EDITORA.id_editora"
            + "and livro.LOJA_id_loja = LOJA.id_loja;";
    private static final String LISTBYID = "select * from LIVRO, EDITORA, LOJA where livro.EDITORA_id_editora = EDITORA.id_editora"
            + "and livro.LOJA_id_loja = LOJA.id_loja;"
            + "where livro.id_livro = ?";
    private static final String LISTBYNOME = "select * from LIVRO, EDITORA, LOJA where livro.EDITORA_id_editora = EDITORA.id_editora"
            + "and livro.LOJA_id_loja = LOJA.id_loja;"
            + "where livro.titulo_lv like ?";
    private static final String LISTBYAUTOR = "select * from LIVRO, EDITORA, LOJA, AUTOR where livro.EDITORA_id_editora = EDITORA.id_editora"
            + "and livro.LOJA_id_loja = LOJA.id_loja and livro.id_autor = AUTOR.id_autor;"
            + "where AUTOR.id_autor = ?";

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
            pstm.setString(3, l.getPalavrasChave());
            pstm.setDouble(4, l.getPreco());
            pstm.setDouble(5, l.getRoyalty());
            pstm.setString(6, l.getResumo());
            pstm.setInt(7, l.getEdicao());                       
            pstm.setDouble(8, l.getVolume());
            pstm.setInt(9, l.getQtEstoque());
            pstm.setInt(10, l.getIsbn());
            pstm.setInt(11, l.getEditor().getId_editor());
            pstm.setInt(12, l.getLoja().getId_loja());
            pstm.setInt(13, l.getAutor().getId_autor());
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
                //titulo_lv, subtitulo_lv, palavraChave_lv, preco_lv, royalty_lv, 
                //resumo_lv, nEdi_lv, volume_lv, qtEstoque_lv, isbn, LIVROA_id_editora, LOJA_id_loja, id_autor
                l.setTitulo(rs.getString("titulo_lv"));
                l.setSubtitulo(rs.getString("subtituli_lv"));
                l.setPalavrasChave(rs.getString("palavraChave_lv"));
                l.setPreco(rs.getDouble("preco_lv"));
                l.setRoyalty(rs.getDouble("royalty_lv"));
                l.setResumo(rs.getString("resumo_lv"));
                l.setEdicao(rs.getInt("nEdi_lv"));
                l.setVolume(rs.getDouble("volume_lv"));
                l.setIsbn(rs.getInt("endereco_fn"));
                Editor ed = new Editor();
                //ed.setId_editor(l.setEditor(rs.getInt("LIVROA_id_editora")));
                //l.setEditor(rs.getInt("LIVROA_id_editora"));
                //l.setLoja(rs.getInt("LOJA_id_loja"));
                //l.setAutor(rs.getInt("id_autor"));
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
               // l.setTema(rs.getString("endereco_fn"));
                l.setResumo(rs.getString("endereco_fn"));
                l.setPalavrasChave(rs.getString("endereco_fn"));
                //l.setEdicao(rs.getString("endereco_fn"));
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
               // l.setTema(rs.getString("endereco_fn"));
                l.setResumo(rs.getString("endereco_fn"));
                l.setPalavrasChave(rs.getString("endereco_fn"));
               // l.setEdicao(rs.getString("endereco_fn"));
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
    
    
    public int update(Livro l){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, l.getTitulo());
            pstm.setString(2, l.getSubtitulo());                        
            pstm.setString(3, l.getPalavrasChave());
            pstm.setDouble(4, l.getPreco());
            pstm.setDouble(5, l.getRoyalty());
            pstm.setString(6, l.getResumo());
            pstm.setInt(7, l.getEdicao());                       
            pstm.setDouble(8, l.getVolume());
            pstm.setInt(9, l.getQtEstoque());
            pstm.setInt(10, l.getIsbn());
            pstm.setInt(11, l.getEditor().getId_editor());
            pstm.setInt(12, l.getLoja().getId_loja());
            pstm.setInt(13, l.getAutor().getId_autor());
            pstm.execute();
            retorno = l.getId_livro();
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

    @Override
    public List<Livro> ListByAutor(int id_autor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
