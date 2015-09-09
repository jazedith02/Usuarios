/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sala221
 */
public class Conexion {
    private  String db = "abogados";
    private  String user = "root";
    private  String clave = "";
    private  String url = "jdbc:mysql://localhost/"+db;
    private  String driver = "com.mysql.jdbc.Driver";
    private  Connection conexion = null;
    
     
    public  Conexion(){
       try {
            Class.forName(driver);
            try {
                conexion = DriverManager.getConnection(url, user, clave);
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Error de sql: "+e.getMessage());
            }
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "error en el driver: "+ e.getMessage());
        }
    }
    
        
        public Connection Conectar(){
            return this.conexion;
        }
    }
    
   
    
    
