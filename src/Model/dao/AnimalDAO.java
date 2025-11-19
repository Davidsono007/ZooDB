/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.dao;

import Connection.ConnectionFactory;
import Model.bean.Animal;
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
public class AnimalDAO {
    
    // Função de criar dado
    public void createAnimal(Animal a) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("INSERT INTO Animal (nm_animal, ds_sexo, id_especie, id_cercado) VALUES (?, ?, ?, ?)");
            stmt.setString(1, a.getNm_animal());
            stmt.setString(2, a.getDs_sexo());
            stmt.setString(3, String.valueOf(a.getId_especie()));
            stmt.setString(4, String.valueOf(a.getId_cercado()));
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Salvar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }
    
    // Função de SELECT * FROM
    public List<Animal> readAnimal() throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Animal> animais = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Animal");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Animal animal = new Animal();
            
            animal.setId_animal(rs.getInt("id_animal"));
            animal.setNm_animal(rs.getString("nm_animal"));
            animal.setDs_sexo(rs.getString("ds_sexo"));
            animal.setId_especie(rs.getInt("id_especie"));
            animal.setId_cercado(rs.getInt("id_cercado"));
            animais.add(animal);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animais;
        
    }
    
    // Função de SELECT de id_animal
    public List<Animal> searchAnimalId(String id) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Animal> animais = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Animal WHERE id_animal = ?");
            stmt.setString(1, id);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Animal animal = new Animal();
            
            animal.setId_animal(rs.getInt("id_animal"));
            animal.setNm_animal(rs.getString("nm_animal"));
            animal.setDs_sexo(rs.getString("ds_sexo"));
            animal.setId_especie(rs.getInt("id_especie"));
            animal.setId_cercado(rs.getInt("id_cercado"));
            animais.add(animal);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animais;
        
    }
    
    // Função de SELECT de nm_animal
    public List<Animal> searchAnimalNome(String nome) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Animal> animais = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Animal WHERE nm_animal LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Animal animal = new Animal();
            
            animal.setId_animal(rs.getInt("id_animal"));
            animal.setNm_animal(rs.getString("nm_animal"));
            animal.setDs_sexo(rs.getString("ds_sexo"));
            animal.setId_especie(rs.getInt("id_especie"));
            animal.setId_cercado(rs.getInt("id_cercado"));
            animais.add(animal);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animais;
        
    }

    // Função de SELECT de ds_sexo
    public List<Animal> searchAnimalSexo(String sexo) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Animal> animais = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Animal WHERE ds_sexo LIKE ?");
            stmt.setString(1, "%"+sexo+"%");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Animal animal = new Animal();
            
            animal.setId_animal(rs.getInt("id_animal"));
            animal.setNm_animal(rs.getString("nm_animal"));
            animal.setDs_sexo(rs.getString("ds_sexo"));
            animal.setId_especie(rs.getInt("id_especie"));
            animal.setId_cercado(rs.getInt("id_cercado"));
            animais.add(animal);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animais;
        
    }
    
    // Função de SELECT de id_especie
    public List<Animal> searchAnimalEspecie(String especie) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Animal> animais = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Animal WHERE id_especie = ?");
            stmt.setString(1, especie);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Animal animal = new Animal();
            
            animal.setId_animal(rs.getInt("id_animal"));
            animal.setNm_animal(rs.getString("nm_animal"));
            animal.setDs_sexo(rs.getString("ds_sexo"));
            animal.setId_especie(rs.getInt("id_especie"));
            animal.setId_cercado(rs.getInt("id_cercado"));
            animais.add(animal);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animais;
        
    }
    
    // Função de SELECT de id_cercado
    public List<Animal> searchAnimalCercado(String cercado) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Animal> animais = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Animal WHERE id_cercado = ?");
            stmt.setString(1, cercado);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
            
            Animal animal = new Animal();
            
            animal.setId_animal(rs.getInt("id_animal"));
            animal.setNm_animal(rs.getString("nm_animal"));
            animal.setDs_sexo(rs.getString("ds_sexo"));
            animal.setId_especie(rs.getInt("id_especie"));
            animal.setId_cercado(rs.getInt("id_cercado"));
            animais.add(animal);
            
        }
            
        } catch (SQLException ex) {
            Logger.getLogger(AnimalDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return animais;
        
    }
    
    // Função de atualizar um dado
    public void updateAnimal(Animal a) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("UPDATE Animal SET nm_animal = ?, ds_sexo = ?, id_especie = ?, id_cercado = ? WHERE id_animal = ?");
            stmt.setString(1, a.getNm_animal());
            stmt.setString(2, a.getDs_sexo());
            stmt.setString(3, String.valueOf(a.getId_especie()));
            stmt.setString(4, String.valueOf(a.getId_cercado()));
            stmt.setInt(5, a.getId_animal());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }
    
    // Funçao de deletar um dado
     public void deleteAnimal(Animal a) {
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = (PreparedStatement) con.prepareStatement("DELETE FROM Animal WHERE id_animal = ?");
            stmt.setInt(1, a.getId_animal());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Dados Excluídos com Sucesso!!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
           
    }
    
}
