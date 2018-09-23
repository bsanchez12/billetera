/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.gasto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Administrador
 */
public class gastoController implements ActionListener{
    
    private final gasto ventana;

    public gastoController(gasto aThis) {
       ventana = aThis;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);    
        String value = e.getActionCommand();
        if(value == "Agregar"){
            ventana.getModelo().abrirVentanaAgregarGasto();
        }else{
            ventana.getModelo().cerrarVentanaGastos();
        }
    }
    
    public void selectItem(){
        ventana.getModelo().selectedMovimiento(2);
    }
}
