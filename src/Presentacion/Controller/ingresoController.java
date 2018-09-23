/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.ingreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Briam
 */
public class ingresoController implements ActionListener{
    
    private final ingreso ventana;

    public ingresoController(ingreso aThis) {
       ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e);
        String value = e.getActionCommand();
        if(value == "Agregar"){
            ventana.getModelo().abrirVentanaAgregarIngreso();
        }else{
            ventana.getModelo().cerrarVentanaIngresos();
        }
    }
    
    public void selectItem(){
        ventana.getModelo().selectedMovimiento(1);
    }
}
