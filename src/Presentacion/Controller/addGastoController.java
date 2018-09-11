/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.addGasto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Administrador
 */
public class addGastoController implements ActionListener{
     private final addGasto ventana;

    public addGastoController(addGasto aThis) {
       ventana = aThis;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        String value = e.getActionCommand();
        if(value == "Cancelar"){
          ventana.getModelo().CerrarVentanaAgregarGasto();
        }else{
          ventana.getModelo().FuncionalidadAgregarGasto();   
        }        
    }
}
