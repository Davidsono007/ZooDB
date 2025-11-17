/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Connection.ConnectionFactory;
import Model.bean.Especie;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ALUNO
 */
public class EspecieDAO {
    
    // Função de criar dado
    public void createEspecie(Especie e) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Especie (nm_especie, ds_dieta) VALUES (?, ?)");
            stmt.setString(1, e.getNm_especie());
            stmt.setString(2, e.getDs_dieta());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }
    
    // Função de SELECT * FROM
    public List<Especie> readEspecie() throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Especie> especies = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Especie");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Especie especie = new Especie();
            
            especie.setId_especie(rs.getInt("id_especie"));
            especie.setNm_especie(rs.getString("nm_especie"));
            especie.setDs_dieta(rs.getString("ds_dieta"));
            especies.add(especie);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return especies;
        
    }
    
    // Função de SELECT de id_especie
    public List<Especie> searchEspecieId(String id) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Especie> especies = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Especie WHERE id_especie = ?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Especie especie = new Especie();
            
            especie.setId_especie(rs.getInt("id_especie"));
            especie.setNm_especie(rs.getString("nm_especie"));
            especie.setDs_dieta(rs.getString("ds_dieta"));
            especies.add(especie);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return especies;
        
    }
    
    // Função de SELECT de nm_especie
    public List<Especie> searchEspecieNome(String nome) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Especie> especies = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Especie WHERE nm_especie LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Especie especie = new Especie();
            
            especie.setId_especie(rs.getInt("id_especie"));
            especie.setNm_especie(rs.getString("nm_especie"));
            especie.setDs_dieta(rs.getString("ds_dieta"));
            especies.add(especie);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return especies;
        
    }
    
    // Função de SELECT de ds_dieta
    public List<Especie> searchEspecieDieta(String dieta) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Especie> especies = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Especie WHERE ds_dieta LIKE ?");
            stmt.setString(1, "%"+dieta+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Especie especie = new Especie();
            
            especie.setId_especie(rs.getInt("id_especie"));
            especie.setNm_especie(rs.getString("nm_especie"));
            especie.setDs_dieta(rs.getString("ds_dieta"));
            especies.add(especie);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return especies;
        
    }
    
    
    // Função de atualizar um dado
     public void updateEspecie(Especie e) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Especie SET nm_especie = ?, ds_dieta = ? WHERE id_especie = ?");
            stmt.setString(1, e.getNm_especie());
            stmt.setString(2, e.getDs_dieta());
            stmt.setInt(3, e.getId_especie());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }
        
     // Funçao de deletar um dado
     public void deleteEspecie(Especie e) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Especie WHERE id_especie = ?");
            stmt.setInt(1, e.getId_especie());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Excluídos com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }
    
}
