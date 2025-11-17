/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Model.bean.Cercado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author SAMSUNG
 */
public class CercadoDAO {
    
    // Função de criar dado
    public void createCercado(Cercado c) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Cercado (nm_cercado, ds_tipo) VALUES (?, ?)");
            stmt.setString(1, c.getNm_cercado());
            stmt.setString(2, c.getDs_tipo());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }
    
    // Função de SELECT * FROM
    public List<Cercado> readCercado() throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cercado> cercados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Cercado");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Cercado cercado = new Cercado();
            
            cercado.setId_cercado(rs.getInt("id_cercado"));
            cercado.setNm_cercado(rs.getString("nm_cercado"));
            cercado.setDs_tipo(rs.getString("ds_tipo"));
            cercados.add(cercado);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cercados;
        
    }
    
    // Função de SELECT de id_cercado
    public List<Cercado> searchCercadoID(String id) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cercado> cercados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Cercado WHERE id_cercado = ?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Cercado cercado = new Cercado();
            
            cercado.setId_cercado(rs.getInt("id_cercado"));
            cercado.setNm_cercado(rs.getString("nm_cercado"));
            cercado.setDs_tipo(rs.getString("ds_tipo"));
            cercados.add(cercado);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cercados;
        
    }
    
    // Função de SELECT de nm_cercado
    public List<Cercado> searchCercadoNome(String nome) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cercado> cercados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Cercado WHERE nm_cercado LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Cercado cercado = new Cercado();
            
            cercado.setId_cercado(rs.getInt("id_cercado"));
            cercado.setNm_cercado(rs.getString("nm_cercado"));
            cercado.setDs_tipo(rs.getString("ds_tipo"));
            cercados.add(cercado);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cercados;
        
    }
    
    // Função de SELECT de ds_tipo
    public List<Cercado> searchCercadoTipo(String tipo) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cercado> cercados = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Cercado WHERE ds_tipo LIKE ?");
            stmt.setString(1, "%"+tipo+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Cercado cercado = new Cercado();
            
            cercado.setId_cercado(rs.getInt("id_cercado"));
            cercado.setNm_cercado(rs.getString("nm_cercado"));
            cercado.setDs_tipo(rs.getString("ds_tipo"));
            cercados.add(cercado);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(EspecieDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return cercados;
        
    }
    
    // Função de atualizar um dado
     public void updateCercado(Cercado c) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Cercado SET nm_cercado = ?, ds_tipo = ? WHERE id_cercado = ?");
            stmt.setString(1, c.getNm_cercado());
            stmt.setString(2, c.getDs_tipo());
            stmt.setInt(3, c.getId_cercado());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }
     
    // Funçao de deletar um dado
     public void deleteCercado(Cercado c) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Cercado WHERE id_cercado = ?");
            stmt.setInt(1, c.getId_cercado());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Excluídos com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }    
}
