
package br.com.kobos.model.persistencia;

import br.com.kobos.model.persistencia.dao.AutorDAO;
import br.com.kobos.modelo.Autor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AutorDAOImplements implements AutorDAO{
    
    private static final String INSERT = "insert into AUTOR (nome_au, sobrenome_au, email_au) values (?, ?, ?);";
    private static final String REMOVE = "delete from AUTOR where id_autor = ?;";
    private static final String UPDATE = "update AUTOR set nome_au = ?, sobrenome_au = ?, email_au = ? where id_autor = ?";
    private static final String LIST = "select * from AUTOR;";
    private static final String LISTBYID = "select * from AUTOR where id_autor = ?";
    private static final String LISTBYNOME = "select * from AUTOR where nome_au like ?";
    private static final String LISTBYSOBRENOME = "select * from AUTOR where sobrenome_au like ?";

    @Override
    public int salvar(Autor a) {
        if (a.getId_autor() == 0){
            return inserir(a);
        }else{
            return update(a);
        }
    }
    
    public int inserir(Autor a){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getSobrenome());
            pstm.setString(3, a.getEmail());
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
    public boolean remove(int id_autor) {
        boolean status = false;
        Connection conn = null;
        PreparedStatement pstm = null;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(REMOVE);
            pstm.setInt(1, id_autor);
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
    public List<Autor> listAll() {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Autor> autores = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()){
                Autor a = new Autor();
                a.setId_autor(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome_au"));
                a.setSobrenome(rs.getString("sobrenome_au"));
                a.setEmail(rs.getString("email_au"));
                autores.add(a);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar autores " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return autores;
    }

    @Override
    public Autor ListById(int id_autor) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Autor a = new Autor();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYID);
            pstm.setInt(1, id_autor);
            rs = pstm.executeQuery();
            while (rs.next()){
                a.setId_autor(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome_au"));
                a.setSobrenome(rs.getString("sobrenome_au"));
                a.setEmail(rs.getString("email_us"));
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar autores " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar com o banco " + e);
            }
        }
        return a;
    }

    @Override
    public List<Autor> ListByNome(String nome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Autor> autores = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYNOME);
            pstm.setString(1,"%" + nome + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                Autor a = new Autor();
                a.setId_autor(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome_au"));
                a.setSobrenome(rs.getString("sobrenome_au"));
                a.setEmail(rs.getString("email_au"));
                autores.add(a);
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
        return autores;
    }
    
    
    public int update(Autor a){
        Connection conn = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(UPDATE);
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getSobrenome());
            pstm.setString(3, a.getEmail());
            pstm.execute();
            retorno = a.getId_autor();
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
    public List<Autor> ListBySobrenome(String Sobrenome) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Autor> autores = new ArrayList<>();
        try{
            conn = ConnectionFactory.getConnection();
            pstm = conn.prepareStatement(LISTBYSOBRENOME);
            pstm.setString(1, "%" + Sobrenome + "%");
            rs = pstm.executeQuery();
            while(rs.next()){
                Autor a = new Autor();
                a.setId_autor(rs.getInt("id_autor"));
                a.setNome(rs.getString("nome_au"));
                a.setSobrenome(rs.getString("sobrenome_au"));
                a.setEmail(rs.getString("email_au"));
                autores.add(a);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Erro ao listar autores por sobrenome " + e);
        }finally{
            try{
                ConnectionFactory.closeConnection(conn, pstm, rs);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"Erro ao desconectar do banco " + e);
            }
        }
        return autores;
    }
}
