/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

/**
 *
 * @author OKS
 */

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Avaliacao;
import model.bean.Jogo;
import model.bean.Usuario;

public class AvaliacaoDAO {
    public void create(Avaliacao avl) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "INSERT INTO avaliação(notaAval, comentAval, idJogoAval, idUsuAval)VALUES(?,?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, avl.getNotaAval());
            stmt.setString(2, avl.getComentAval());
            stmt.setInt(3, avl.getJogo().getIdJogo());
            stmt.setInt(4, avl.getUsuario().getId());
         
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Avaliação cadastrada com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Avaliação. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public ArrayList<Avaliacao> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Avaliacao> listaAvl = new ArrayList();
        
        try {
            String query = "SELECT * FROM avaliação";
            stmt = con.prepareStatement(query);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Avaliacao avl = new Avaliacao();
                avl.setIdAval(rs.getInt("idAval"));
                avl.setNotaAval(rs.getString("notaAval"));
                avl.setComentAval(rs.getString("comentAval"));
                Jogo jg = new JogoDAO().read(rs.getInt("idJogoAval"));
                avl.setJogo(jg);
                Usuario usu = new UsuarioDAO().read(rs.getInt("idUsuAval"));
                avl.setUsuario(usu);
                listaAvl.add(avl);
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Avaliação. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return listaAvl;
    }
    
    public Avaliacao read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM avaliação WHERE idAval = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                Avaliacao avl = new Avaliacao();
                avl.setIdAval(rs.getInt("idAval"));
                avl.setNotaAval(rs.getString("notaAval"));          
                avl.setComentAval(rs.getString("comentAval"));          
                Jogo jg = new JogoDAO().read(rs.getInt("idJogoAval"));
                avl.setJogo(jg);
                Usuario usu = new UsuarioDAO().read(rs.getInt("idUsuAval"));
                avl.setUsuario(usu);
                return avl;
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Avaliação. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return null;
    }
    
    public void update(Avaliacao avl) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "UPDATE Avaliação SET notaAval = ?, comentAval = ?,idJogoAval = ?, idUsuAval = ? WHERE idAval = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, avl.getNotaAval());
            stmt.setString(2, avl.getComentAval());
            stmt.setInt(3, avl.getJogo().getIdJogo());
            stmt.setInt(4, avl.getUsuario().getId());
            stmt.setInt(5, avl.getIdAval());
 
         
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Avaliação atualizada com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Avaliação. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void destroy(Avaliacao avl) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "DELETE FROM avaliação WHERE idAval = ?";
            stmt = con.prepareStatement(query);            
            stmt.setInt(1, avl.getIdAval());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Avaliação excluída com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Avaliação. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}

