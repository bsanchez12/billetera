/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.addCategoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Briam
 */
public class addCategoriaController implements ActionListener{
    private final addCategoria ventana;  
    
    public addCategoriaController(addCategoria aThis) {
       ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();
        if(value == "Atras"){
          ventana.getModelo().cerrarVentanaAgregarCategorias();   
        }else{
          ventana.getModelo().agregarCategoria();
        }   
    }
}
