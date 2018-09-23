/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.detailGasto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Administrador
 */
public class detailGastoController implements ActionListener{
     private final detailGasto ventana; 
   
    public detailGastoController(detailGasto aThis) {
       ventana = aThis;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);  
        ventana.getModelo().cerrarDetalleGasto();
    }
}
