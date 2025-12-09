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
import model.bean.GameJam;


public class GameJamDAO {
    
    public void create(GameJam gj) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "INSERT INTO gamejam(nomeGJ, temaGJ, duraGJ, premioGJ, descGJ, dataInicioGJ, dataFimGJ) VALUES(?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setString(1, gj.getNomeGJ());
            stmt.setString(2, gj.getTemaGJ());
            stmt.setString(3, gj.getDuraGJ());
            stmt.setString(4, gj.getPremioGJ());
            stmt.setString(5, gj.getDescGJ());
            stmt.setString(6, gj.getDataInGJ());
            stmt.setString(7, gj.getDataFimGJ());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Game Jam cadastrada com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Game Jam. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public ArrayList<GameJam> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<GameJam> listaGJ = new ArrayList();
        
        try {
            String query = "SELECT * FROM gamejam";
            stmt = con.prepareStatement(query);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                GameJam gj = new GameJam();
                gj.setIdGJ(rs.getInt("idGJ"));
                gj.setNomeGJ(rs.getString("nomeGJ"));
                gj.setTemaGJ(rs.getString("temaGJ"));
                gj.setDuraGJ(rs.getString("duraGJ"));
                gj.setPremioGJ(rs.getString("premioGJ"));
                gj.setDescGJ(rs.getString("descGJ"));
                gj.setDataInGJ(rs.getString("dataInicioGJ"));
                gj.setDataFimGJ(rs.getString("dataFimGJ"));
                
                listaGJ.add(gj);
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Game Jams. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return listaGJ;
    }
    
    public GameJam read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM gamejam WHERE idGJ = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                GameJam gj = new GameJam();
                gj.setIdGJ(rs.getInt("idGJ"));
                gj.setNomeGJ(rs.getString("nomeGJ"));          
                gj.setTemaGJ(rs.getString("temaGJ"));          
                gj.setDuraGJ(rs.getString("duraGJ"));          
                gj.setPremioGJ(rs.getString("premioGJ"));          
                gj.setDescGJ(rs.getString("descGJ"));          
                gj.setDataInGJ(rs.getString("dataInicioGJ"));          
                gj.setDataFimGJ(rs.getString("dataFimGJ"));          
                return gj;
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Game Jam. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return null;
    }
    
    public void update(GameJam gj) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "UPDATE gamejam SET nomeGJ = ?, temaGJ = ?, duraGJ = ?, premioGJ = ?, descGJ = ?, dataInicioGJ = ?, dataFimGJ = ? WHERE idGJ = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, gj.getNomeGJ());
            stmt.setString(2, gj.getTemaGJ());
            stmt.setString(3, gj.getDuraGJ());
            stmt.setString(4, gj.getPremioGJ());
            stmt.setString(5, gj.getDescGJ());
            stmt.setString(6, gj.getDataInGJ());
            stmt.setString(7, gj.getDataFimGJ());
            stmt.setInt(8, gj.getIdGJ());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Game Jam atualizada com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Game Jam. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void destroy(GameJam gj) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "DELETE FROM gamejam WHERE idGJ = ?";
            stmt = con.prepareStatement(query);            
            stmt.setInt(1, gj.getIdGJ());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Game Jam excluída com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Game Jam. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

}
