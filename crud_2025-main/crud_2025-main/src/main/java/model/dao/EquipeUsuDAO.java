/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.bean.Equipe;

public class EquipeUsuDAO {

    public void adicionarUsuarioAEquipe(int idEquipe, int idUsuario) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "INSERT INTO equipe_usuario(idEquipe, idUsuario) VALUES (?, ?)";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idEquipe);
            stmt.setInt(2, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar usuário à equipe: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }

    public void removerUsuarioDaEquipe(int idEquipe, int idUsuario) {
        Connection con = Conexao.getConexao();
        PreparedStatement stmt = null;
        try {
            String query = "DELETE FROM equipe_usuario WHERE idEquipe = ? AND idUsuario = ?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, idEquipe);
            stmt.setInt(2, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao remover usuário da equipe: " + ex.getMessage());
        } finally {
            Conexao.fecharConexao(con, stmt);
        }
    }
}
