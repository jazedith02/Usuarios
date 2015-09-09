/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jazmin & Katherin & James
 */


public class UsuarioModelo extends Conexion {
    
    public DefaultTableModel  getjtablausuario(){
        DefaultTableModel tablamodelo = new DefaultTableModel();
        int numregistros = 0;
         int numregistros2 = 0;
        String[] NombreColumnas = {"Documento", "Nombre", "Estado","Fecha Revocacion","Fecha Asignacion"  };
        
        try {
            String sql = "SELECT count(*) as Total FROM usuarios;";
            PreparedStatement sentencia = this.Conectar().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            resultado.next();
            numregistros = resultado.getInt("Total");
            resultado.close();
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
        Object[][] datos = new String[numregistros][3];
        try {
            String sql = "Select * from usuarios;";
            PreparedStatement sentencia = this.Conectar().prepareStatement(sql);
            try (ResultSet resultado = sentencia.executeQuery()) {
                int i = 0;
                while(resultado.next()){
                    datos[i][0] = resultado.getString("NumeDocu");
                    datos[i][1] = resultado.getString("NombUsua");
                    
                    datos[i][2] = resultado.getString("EstaUsua");
                    i++;
                }
            }
            
            tablamodelo.setDataVector(datos, NombreColumnas);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
     
       return tablamodelo;             
    }

    
    public boolean ConsultarTercero(String NumeDocu){
//    String[] con = new String[1];'"+FechRevo+"'
        String con[]= new String[1];
        boolean bande = false;
           String Sql = "Select NumeDocu from terceros where NumeDocu = '"+NumeDocu+"';";
           try{
               PreparedStatement sentencia = this.Conectar().prepareStatement(Sql);               
               ResultSet resultado = sentencia.executeQuery();
               int i = 0;
               while(resultado.next()){
                   con[i] = resultado.getString("NumeDocu");
                   
                   i++;
               };
               if (NumeDocu.equals(con[0])) {
                   bande = true;
               }
                
               resultado.close();
           }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
           }
        return bande;
           
       }
    public String mostrar(String NumeDocu){
        String con[]= new String[2];        
        String usuario = "";      
        
       String Sql = "Select concat(PrimNomb,\".\",PrimApell) as usuario from terceros where NumeDocu = '"+NumeDocu+"';";

       try{
           PreparedStatement sentencia = this.Conectar().prepareStatement(Sql);               
           ResultSet resultado = sentencia.executeQuery();
           int i = 0;               

           while(resultado.next()){
               usuario = resultado.getString("usuario");               
               i++;
           }
           resultado.close();
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
       }
        return usuario;
       }
    
  
    
    public boolean NuevoUsuario(String NumeDocu, String NombUsua,String EstaUsua ){

        if (Valida_datos(NumeDocu, NombUsua, EstaUsua)){
            String sql = "Insert into usuarios "
                    +"values('"+NumeDocu+"','"+NombUsua+"',+SHA1('"+NumeDocu+"'),'"+EstaUsua+"');";           
            
            try {
                PreparedStatement sentencia = this.Conectar().prepareStatement(sql);
                sentencia.execute();
                sentencia.close();
                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "El Usuario Ya existe!");
            }
            return false;
        }else
            return false;
    
    }
    
 public void AsignarRolUsuario(String docu, String[] roles, Date FechAsig ){
        String NumeDocu=docu;
        for (int r = 0; r < roles.length; r++) {
             if (roles[r]!=null) {
              String sql = "Insert into rolesxusuario values('"+docu+"','"+roles[r]+"','2015-09-01','2015-09-01');";
              JOptionPane.showMessageDialog(null, sql);
              try {
                PreparedStatement sentencia = this.Conectar().prepareStatement(sql);
                sentencia.execute();
                sentencia.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se puede insertar rol!");
            }    
    
             }
     
//     private boolean Valida_datosrol(String CodiRol, String FechAsig, String FechRevo){
//        if (CodiRol.equals(" - ")) 
//            return false;
//        else if (CodiRol.length() > 0 && CodiRol.length() > 0 && FechAsig.length()
//               > 0 && FechRevo.length() > 0){
//        return true;
//        }else 
//            return false;
//    }
//     
    
        }
 }
    public boolean EliminarUsuario(String id){
        boolean bandera = false;
        
        String sql = "Delete from usuarios where NumeDocu = '"+id+"';" ;
        try {
            PreparedStatement sentencia = this.Conectar().prepareStatement(sql);
            sentencia.execute();
            sentencia.close();
            bandera = true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return bandera;
    }

    private boolean Valida_datos(String NumeDocu, String NombUsua,
            String EstaUsua){
        if (NumeDocu.equals(" - ")) 
            return false;
        else if (NumeDocu.length() > 0 && NombUsua.length() > 0 && EstaUsua.length()
               > 0){
        return true;
        }else 
            return false;
    }
   
    public String CodigoDpto(String dpto){
        String codigoDpto="";
        String sql = "select Codi_Dpto from departamentos where Nomb_Dpto = '"+dpto+"';";
        try {
            PreparedStatement sentencia = this.Conectar().prepareStatement(sql);
            ResultSet resultado = sentencia.executeQuery();
            while (resultado.next()) {
                codigoDpto = resultado.getString("codi_Dpto");
                JOptionPane.showMessageDialog(null, codigoDpto);
                 
            }
            resultado.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return codigoDpto;
}
}
