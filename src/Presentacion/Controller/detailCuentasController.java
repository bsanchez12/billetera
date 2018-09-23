/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.detailCount;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiantes
 */
public class detailCuentasController implements ActionListener{
    
        private final detailCount ventana;

    public detailCuentasController(detailCount aThis) {
       ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        String value = e.getActionCommand();
        if(value == "Agregar"){
            //ventana.getModelo().abrirVentanaAgregarIngreso();
        }else{
            ventana.getModelo().cerrarVentanaDetailCuenta();
        }
    }
    
    
       public void selectItem(){
           System.out.println("controlador");
        ventana.getModelo().selectCuenta();
    }


    
}
