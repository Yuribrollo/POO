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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Equipe;
import model.bean.Usuario;

public class EquipeDAO {
    public void create(Equipe eqp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "INSERT INTO equipe(nomeEquipe)VALUES(?)";
            stmt = con.prepareStatement("INSERT INTO equipe(nomeEquipe) VALUES(?)",
                                           Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, eqp.getNomeEquipe());
         
            stmt.executeUpdate();
            
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                eqp.setIdEquipe(rs.getInt(1));
            }
            
            if (!eqp.getUsuarios().isEmpty()) {
                String queryRel = "INSERT INTO equipe_usuario(idEquipe, idUsu) VALUES(?,?)";
                PreparedStatement stmtRel = con.prepareStatement(queryRel);
                for (Usuario u : eqp.getUsuarios()) {
                    
                    stmtRel.setInt(1, eqp.getIdEquipe());
                    stmtRel.setInt(2, u.getId());
                    stmtRel.executeUpdate();
                    
                }
                stmtRel.close();
            }
            
            JOptionPane.showMessageDialog(null, "Equipe cadastrada com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar Equipe. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public ArrayList<Equipe> read() {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Equipe> listaEqp = new ArrayList();
        
        try {
            String query = "SELECT * FROM equipe";
            stmt = con.prepareStatement(query);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Equipe eqp = new Equipe();
                eqp.setIdEquipe(rs.getInt("idEquipe"));
                eqp.setNomeEquipe(rs.getString("nomeEquipe"));
                String queryUsuarios = "SELECT u.* FROM usuarios u "
                        + "JOIN equipe_usuario eu ON u.idUsu = eu.idUsu "
                        + "WHERE eu.idEquipe = ?";
                PreparedStatement stmtUsuarios = con.prepareStatement(queryUsuarios);
                stmtUsuarios.setInt(1, eqp.getIdEquipe());
                ResultSet rsUsuarios = stmtUsuarios.executeQuery();
                listaEqp.add(eqp);
                
                while (rsUsuarios.next()) {
                    Usuario u = new Usuario();
                    u.setId(rsUsuarios.getInt("idUsu"));
                    u.setNomeUsu(rsUsuarios.getString("nomeUsu"));
                    u.setEmailUsu(rsUsuarios.getString("emailUsu"));
                    u.setTipoUsu(rsUsuarios.getString("tipoUsu"));
                    eqp.getUsuarios().add(u);
                }

                rsUsuarios.close();
                stmtUsuarios.close();

                listaEqp.add(eqp);
            }

            }
        
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao consultar Equipe. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return listaEqp;
    }
    
        public Equipe read(int id) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            String query = "SELECT * FROM equipe WHERE idEquipe = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if(rs.next()) {
                Equipe eqp = new Equipe();
                eqp.setIdEquipe(rs.getInt("idEquipe"));
                eqp.setNomeEquipe(rs.getString("nomeEquipe"));          
                
                String queryUsuarios = "SELECT u.* FROM usuarios u "
                        + "JOIN equipe_usuario eu ON u.idUsu = eu.idUsu "
                        + "WHERE eu.idEquipe = ?";
                PreparedStatement stmtUsuarios = con.prepareStatement(queryUsuarios);
                stmtUsuarios.setInt(1, eqp.getIdEquipe());
                ResultSet rsUsuarios = stmtUsuarios.executeQuery();

                while (rsUsuarios.next()) {
                    Usuario u = new Usuario();
                    u.setId(rsUsuarios.getInt("idUsu"));
                    u.setNomeUsu(rsUsuarios.getString("nomeUsu"));
                    u.setEmailUsu(rsUsuarios.getString("emailUsu"));
                    u.setTipoUsu(rsUsuarios.getString("tipoUsu"));
                    eqp.getUsuarios().add(u);
                }

                rsUsuarios.close();
                stmtUsuarios.close();
                
                return eqp;
            }
        }
        catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao buscar Equipe. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt, rs);
        }
        
        return null;
    }
        
    public void update(Equipe eqp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "UPDATE equipe SET nomeEquipe = ? WHERE idEquipe = ?";
            stmt = con.prepareStatement(query);
            stmt.setString(1, eqp.getNomeEquipe());
            stmt.setInt(2, eqp.getIdEquipe());
            stmt.executeUpdate();
            
            stmt.close();

            // Remover relações antigas
            String queryDel = "DELETE FROM equipe_usuario WHERE idEquipe = ?";
            PreparedStatement stmtDel = con.prepareStatement(queryDel);
            stmtDel.setInt(1, eqp.getIdEquipe());
            stmtDel.executeUpdate();
            stmtDel.close();

            // Inserir novos usuários
            if (!eqp.getUsuarios().isEmpty()) {
                for (Usuario u : eqp.getUsuarios()) {
                    String queryRel = "INSERT INTO equipe_usuario(idEquipe, idUsu) VALUES(?,?)";
                    PreparedStatement stmtRel = con.prepareStatement(queryRel);
                    stmtRel.setInt(1, eqp.getIdEquipe());
                    stmtRel.setInt(2, u.getId());
                    stmtRel.executeUpdate();
                    stmtRel.close();
                }
            }
            
            JOptionPane.showMessageDialog(null, "Equipe atualizada com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao atualizar Equipe. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    
    public void destroy(Equipe eqp) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        
        try {
            String query = "DELETE FROM equipe WHERE idEquipe = ?";
            stmt = con.prepareStatement(query);            
            stmt.setInt(1, eqp.getIdEquipe());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Equipe excluída com sucesso!");
        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao excluir Equipe. Erro: " + ex.getMessage());
        }
        finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
    public List<String[]> readWithUsuarios() {
        List<String[]> lista = new ArrayList<>();
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Consulta que traz equipe e os usuários concatenados
            String query = "SELECT e.idEquipe, e.nomeEquipe, GROUP_CONCAT(u.nomeUsu SEPARATOR ', ') AS participantes " +
                           "FROM equipe e " +
                           "LEFT JOIN equipe_usuario eu ON e.idEquipe = eu.idEquipe " +
                           "LEFT JOIN usuarios u ON eu.idUsu = u.idUsu " +
                           "GROUP BY e.idEquipe, e.nomeEquipe";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("idEquipe"));
                String nomeEquipe = rs.getString("nomeEquipe");
                String participantes = rs.getString("participantes");
                lista.add(new String[]{id, nomeEquipe, participantes});
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar equipes: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt, rs);
        }

        return lista;
    }
}
