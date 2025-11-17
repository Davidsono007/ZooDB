/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Connection.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author ALUNO
 */
public class MainTeste {
    public static void main(String args[]) {
        
        Connection teste = new ConnectionFactory().getConnection();
        System.out.println("Deu certo");
        
    }
}
