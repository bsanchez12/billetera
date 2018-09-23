/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.addIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Briam
 */
public class addIngresoController implements ActionListener{
    private final addIngreso ventana;

    public addIngresoController(addIngreso aThis) {
       ventana = aThis;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String value = e.getActionCommand();
        if(value == "Cancelar"){
          ventana.getModelo().CerrarVentanaAgregarIngreso();
        }else{
          ventana.getModelo().FuncionalidadAgregarIngreso();   
        }        
    }
}
