package Controladores;

import Modelos.UsuarioModelo;
import Vistas.FormularioUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ControladorFormUsua implements ActionListener, MouseListener{
    
    FormularioUsuarios vtnUsuarios;
    UsuarioModelo modelo = new UsuarioModelo();
    
    public enum AccionUsu{
        _VER_USUARIO,
        _AGREGAR_USUARIO,
        _ELIMINAR_USUARIO,
        _ADICIONAR_USUARIO,
        _CONSULTAR_USUARIO,
        _ASIGNAR_ROL_
      
    }
    
    public ControladorFormUsua (FormularioUsuarios vista){
       this.vtnUsuarios = vista;

    }
    
    
    
    public void iniciar(){
//        try {
//            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows." + "WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vtnUsuarios);
            vtnUsuarios.setVisible(true);
//        } catch (UnsupportedLookAndFeelException ex) {}
//            catch (ClassNotFoundException ex) {}
//            catch (InstantiationException ex) {}
//            catch (IllegalAccessException ex) {}
            
            this.vtnUsuarios.jBtVer.setActionCommand("_VER_USUARIO");
            this.vtnUsuarios.jBtVer.addActionListener(this);
            
//            this.vtnUsuarios.jBtAdicionar.setActionCommand("_ADICIONAR_USUARIO");
//             this.vtnUsuarios.jBtAdicionar.addActionListener(this);
             
             this.vtnUsuarios.jBtCrear.setActionCommand("_AGREGAR_USUARIO");
             this.vtnUsuarios.jBtCrear.addActionListener(this);
             
//            this.vtnUsuarios.jBtEliminar.setActionCommand("_ELIMINAR_USUARIO");
//            this.vtnUsuarios.jBtEliminar.addActionListener(this);
            
            this.vtnUsuarios.jBtConsulta.setActionCommand("_CONSULTAR_USUARIO");
            this.vtnUsuarios.jBtConsulta.addActionListener(this);
            
    
            this.vtnUsuarios.jTableUsuario.addMouseListener(this);
            this.vtnUsuarios.jTableUsuario.setModel(new DefaultTableModel());
            


    }
    
    
    @Override
    public void mouseClicked(MouseEvent e){
    if(e.getButton()== 1 )//Boton Izquierdo
    {
        int fila = this.vtnUsuarios.jTableUsuario.rowAtPoint(e.getPoint());
        if(fila > -1){
            this.vtnUsuarios.jTextDocumento.setText(String.valueOf(
                this.vtnUsuarios.jTableUsuario.getValueAt(fila, 0)));
            this.vtnUsuarios.jDateChooserAsign.setDateFormatString(String.valueOf(
                this.vtnUsuarios.jTableUsuario.getValueAt(fila, 1)));
           this.vtnUsuarios.jDateChooserRevo.setDateFormatString(String.valueOf(
                this.vtnUsuarios.jTableUsuario.getValueAt(fila, 2)));
           this.vtnUsuarios.jComEstado.getSelectedItem().toString().valueOf(
                this.vtnUsuarios.jTableUsuario.getValueAt(fila, 3));
           
           this.vtnUsuarios.jTextDocumento.setEditable(false);
           this.vtnUsuarios.jTextNomUsu.setEditable(false);
           this.vtnUsuarios.jDateChooserAsign.setEnabled(false);
           this.vtnUsuarios.jComEstado.setEditable(false);
         
        }
    }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (AccionUsu.valueOf(e.getActionCommand())){
            case _VER_USUARIO: {
                this.vtnUsuarios.jTableUsuario.setModel(this.modelo.getjtablausuario());
                this.vtnUsuarios.jTextDocumento.requestFocus();
                break;
            }
            case _CONSULTAR_USUARIO: {
                  
               if(this.modelo.ConsultarTercero(this.vtnUsuarios.jTextDocumento.getText())) {
                    JOptionPane.showMessageDialog(vtnUsuarios, "Usuario ya existe!.");  
                   this.vtnUsuarios.jTextNomUsu.setText(this.modelo.mostrar(this.vtnUsuarios.jTextDocumento.getText()));
                   
                }
                else
                    JOptionPane.showMessageDialog(vtnUsuarios, "Usuario No existe !.");
                break;
            }
              
              
              
            
               
            case _ADICIONAR_USUARIO: {
                this.vtnUsuarios.jTextDocumento.setEnabled(true);
                this.vtnUsuarios.jTextNomUsu.setEnabled(true);
                this.vtnUsuarios.jDateChooserAsign.setEnabled(true);
                this.vtnUsuarios.jDateChooserRevo.setEnabled(true);
                this.vtnUsuarios.jComEstado.requestFocus();

                
                
                this.vtnUsuarios.jTextDocumento.setEditable(true);
                this.vtnUsuarios.jTextNomUsu.setEditable(true);
                this.vtnUsuarios.jDateChooserAsign.setEnabled(true);
                this.vtnUsuarios.jComEstado.setEditable(true);
                break;
            }
            case _AGREGAR_USUARIO: {
                
                if(this.modelo.NuevoUsuario(
                    this.vtnUsuarios.jTextDocumento.getText(),
                    this.vtnUsuarios.jTextNomUsu.getText(),                   
                    this.vtnUsuarios.jComEstado.getSelectedItem().toString()
//                    this.vtnUsuarios.jDateChooserAsign.getDate(), )) 
                )){
                    this.vtnUsuarios.jTableUsuario.setModel(this.modelo.getjtablausuario());
                    JOptionPane.showMessageDialog(vtnUsuarios, "Usuario Creado!.");

                  
                    this.vtnUsuarios.jComEstado.getSelectedItem().toString();
                    
                    //////////////////////////////////////////////
                    String roles[]= new String[7];
                    int i=0;
                    if (this.vtnUsuarios.j1.isSelected()==true) {
                        roles[0]="01";
                    }
                    if (this.vtnUsuarios.j2.isSelected()==true) {
                        
                        roles[1]="02";
                    }
                    if (this.vtnUsuarios.j3.isSelected()==true) {
                        roles[2]="03";
                    }
                    if (this.vtnUsuarios.j4.isSelected()==true) {
                        roles[3]="04";
                    }
                    if (this.vtnUsuarios.j5.isSelected()==true) {
                        roles[4]="05";
                    }
                    if (this.vtnUsuarios.j6.isSelected()==true) {
                        roles[5]="06";
                    }
                    if (this.vtnUsuarios.j7.isSelected()==true) {
                        roles[6]="07";
                    }
                    String Docu= this.vtnUsuarios.jTextDocumento.getText();
                    Date fecha= this.vtnUsuarios.jDateChooserAsign.getDate();
                    JOptionPane.showMessageDialog(vtnUsuarios, Docu);
                     this.modelo.AsignarRolUsuario(Docu, roles, fecha);
                     //////////////////////////////////
                }
                else
                    JOptionPane.showMessageDialog(vtnUsuarios, "Datos Incorrectos!.");
                break;
            }
//            case _ASIGNAR_ROL_: {
//                    int roles[]= new int[7];
//                    int i=0;
//                    if (this.vtnUsuarios.j1.isSelected()==true) {
//                        roles[i]=1;
//                    }
//                    if (this.vtnUsuarios.j2.isSelected()==true) {
//                        roles[i]=2;
//                    }
//                    if (this.vtnUsuarios.j3.isSelected()==true) {
//                        roles[i]=3;
//                    }
//                    if (this.vtnUsuarios.j4.isSelected()==true) {
//                        roles[i]=4;
//                    }
//                    if (this.vtnUsuarios.j5.isSelected()==true) {
//                        roles[i]=5;
//                    }
//                    if (this.vtnUsuarios.j6.isSelected()==true) {
//                        roles[i]=6;
//                    }
//                    if (this.vtnUsuarios.j7.isSelected()==true) {
//                        roles[i]=7;
//                    }
//                    String docu= this.vtnUsuarios.jTextDocumento.getText();
//                    Date fecha= this.vtnUsuarios.jDateChooserAsign.getDate();
////                     this.modelo.AsignarRolUsuario(docu, roles[i], fecha);
//                }
                
             
            }
                
         }
}


  
    