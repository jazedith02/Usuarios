/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import Vistas.FrmIngreso;
import java.sql.*;
import javax.swing.JOptionPane;

public class ValidarUsuario extends Conexion {
    Connection conexion = null;
    Conexion miConexion = new Conexion();
    FrmIngreso vtnUsuario = new FrmIngreso();
    
    public boolean ValidarUsuario(String usuario, String clave){
        boolean bandera = false;
        
        
        if (Valida_datos(usuario, clave)) {
            
            try {
                String sql = "Select * from usuarios "
                + "where NombUsua = '"+usuario+"' and ClavUsua = SHA1('"+clave+"')";
             PreparedStatement sentencia = this.Conectar().prepareStatement(sql);
             ResultSet resultado = sentencia.executeQuery();
        
             
             int i = 0;
             while(resultado.next()){
//                 Nuevo(usuario);
//                 String sql1 = "Insert into ultimoingreso "
//               +"values('+usuario+',now(),null,'1');";
//                 JOptionPane.showMessageDialog(null, sql1);
//                 Insert into ultimoingreso values(‘+usuario+’,now(),null,’1’);
//       try {
//           PreparedStatement sentencia1 = this.Conectar().prepareStatement(sql);
//           sentencia1.execute();
//           sentencia1.close();
//            
//           return true;
//           
//       } 
//       catch (SQLException e) {
//       
//       }
                 
                 bandera = true;
             }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            }else{
                    JOptionPane.showMessageDialog(null,"Todos los campos son obligatorios" );
               }
            return bandera;
            }

   private boolean Valida_datos(String usuario,
            String clave){
   
      if (usuario.length() > 0 && clave.length() > 0){
              
        return true;
        }else 
            return false;
    }
   
//   public boolean Nuevo(String usuario){
//       
//       String sql = "Insert into ultimoingreso "
//               +"values('"+usuario+"',now(),'null','1');";
//       
//       
//       try {
//           PreparedStatement sentencia = this.Conectar().prepareStatement(sql);
//           sentencia.execute();
//           sentencia.close();
//            
//           return true;
//           
//       } catch (SQLException e) {
//       
//       }
//        return false;
//               
//    }
}
    
