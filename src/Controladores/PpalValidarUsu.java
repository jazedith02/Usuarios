/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controladores;

import Modelos.ValidarUsuario;
import Vistas.FrmIngreso;


/**
 *
 * @author Sala221
 */
public class PpalValidarUsu {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new ControladorValidarUsu(new FrmIngreso()).iniciar();
    }
    
}
