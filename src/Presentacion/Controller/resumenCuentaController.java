/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.resumenCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiantes
 */
public class resumenCuentaController implements ActionListener {
    
    private final resumenCuenta ventana; 
   
    public resumenCuentaController(resumenCuenta aThis) {
       ventana = aThis;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);  
        ventana.getModelo().cerrarResumenCuenta();
    }
    
    
}
