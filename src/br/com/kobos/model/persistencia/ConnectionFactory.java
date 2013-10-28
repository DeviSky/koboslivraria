
package br.com.kobos.model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE = "kobosdb";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    public static Connection getConnection() throws SQLException{
        try{
            return DriverManager.getConnection(STR_CONEXAO + DATABASE, USER, PASSWORD);
        }catch (Exception e){
            throw new SQLException(e.getMessage());
        }
    }
    
    public static void closeConnection(Connection conn) throws SQLException{
        if (conn != null){
            conn.close();
        }
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pstm)throws SQLException{
        if (pstm!= null){
            pstm.close();
        }
        closeConnection(conn);
    }
    
    public static void closeConnection(Connection conn, PreparedStatement pstm, ResultSet rs)throws SQLException{
        if (rs != null){
            rs.close();
        }
        closeConnection(conn, pstm);
    }
}
