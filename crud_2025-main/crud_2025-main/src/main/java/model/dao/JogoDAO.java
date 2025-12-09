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
import model.bean.Jogo;
import model.bean.Equipe;
import model.bean.GameJam;

public class JogoDAO {
    public void create(Jogo jg) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "INSERT INTO jogo(nomeJogo, generoJogo, descJogo, idEquipeJogo, idGJJogo) VALUES(?,?,?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, jg.getNomeJogo());
            stmt.setString(2, jg.getGeneroJogo());
            stmt.setString(3, jg.getDescJogo());
            stmt.setInt(4, jg.getEquipe().getIdEquipe());
            stmt.setInt(5, jg.getGamejam().getIdGJ());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Jogo cadastrado com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Jogo. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public ArrayList<Jogo> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Jogo> listaJogos = new ArrayList();
        
        try {
            String query = "SELECT * FROM jogo";
            stmt = con.prepareStatement(query);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Jogo jg = new Jogo();
                jg.setIdJogo(rs.getInt("idJogo"));
                jg.setNomeJogo(rs.getString("nomeJogo"));
                jg.setGeneroJogo(rs.getString("generoJogo"));
                jg.setDescJogo(rs.getString("descJogo"));
                Equipe eqp = new EquipeDAO().read(rs.getInt("idEquipeJogo"));
                jg.setEquipe(eqp);
                GameJam gj = new GameJamDAO().read(rs.getInt("idGJJogo"));
                jg.setGamejam(gj);
                listaJogos.add(jg);
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Jogos. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return listaJogos;
    }
    
    public Jogo read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM jogo WHERE idJogo = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                Jogo jg = new Jogo();
                jg.setIdJogo(rs.getInt("idJogo"));
                jg.setNomeJogo(rs.getString("nomeJogo"));          
                jg.setGeneroJogo(rs.getString("generoJogo"));          
                jg.setDescJogo(rs.getString("descJogo"));          
                Equipe eqp = new EquipeDAO().read(rs.getInt("idEquipeJogo"));
                jg.setEquipe(eqp);
                GameJam gj = new GameJamDAO().read(rs.getInt("idGJJogo"));
                jg.setGamejam(gj);
                return jg;
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Jogos. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return null;
    }

    public void update(Jogo jg) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "UPDATE jogo SET nomeJogo = ?, generoJogo = ?, descJogo = ?, idEquipeJogo = ?, idGJJogo = ? WHERE idJogo = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, jg.getNomeJogo());
            stmt.setString(2, jg.getGeneroJogo());
            stmt.setString(3, jg.getDescJogo());
            stmt.setInt(4, jg.getEquipe().getIdEquipe());
            stmt.setInt(5, jg.getGamejam().getIdGJ());
            stmt.setInt(6, jg.getIdJogo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Jogo atualizado com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Jogo. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void destroy(Jogo jg) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "DELETE FROM jogo WHERE idJogo = ?";
            stmt = con.prepareStatement(query);            
            stmt.setInt(1, jg.getIdJogo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Jogo excluído com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Jogo. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
}
