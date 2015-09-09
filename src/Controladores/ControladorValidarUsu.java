/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Modelos.ValidarUsuario;
import Vistas.FormularioUsuarios;
import Vistas.FrmIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ControladorValidarUsu implements ActionListener, MouseListener{
    
    FrmIngreso ventanas;
    ValidarUsuario modelos = new ValidarUsuario();
    
    public enum AccionUsu{
        _INGRESAR_
    }
    
    public ControladorValidarUsu (FrmIngreso vista){
       this.ventanas = vista;
    }
//    public Image getIconImage(){
//        Image retValue= Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/Colombia_ícono.ico"));
//        
//        return retValue;
//    }
    public void iniciar(){
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows." + "WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(ventanas);
            ventanas.setVisible(true);
//        } catch (UnsupportedLookAndFeelException ex) {}
//            catch (ClassNotFoundException ex) {}
//            catch (InstantiationException ex) {}
//            catch (IllegalAccessException ex) {}
 
             
              this.ventanas.jButtonIngreso.setActionCommand("_INGRESAR_");
              this.ventanas.jButtonIngreso.addActionListener(this);
             


    }
    
    
    
    public void mouseClicked(MouseEvent e){}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionUsu.valueOf(e.getActionCommand())){
            
            case _INGRESAR_: {
                if(this.modelos.ValidarUsuario(this.ventanas.jTextUsu.getText(), leerClave())){                 
                       this.ventanas.dispose();
                       
    //                this.modelo.ValidarEntrada(this.ventana.jTexUsuario.getText(), leerClave()))
                }else{
                    JOptionPane.showMessageDialog(ventanas,"Usuario  o clave incorrecta Aqui" );
                    this.ventanas.jTextUsu.requestFocus();
                    this.ventanas.jTextUsu.selectAll();
                }
                break;
            }
        }
  
    }
    private String leerClave(){
   
        String pass = "";
    char[] clave = this.ventanas.jPasswordContr.getPassword();
    
    for (int i = 0; i < clave.length; i++){
        pass += clave[i];
       
    }
    return pass;
     
    
    }
}
    
    
