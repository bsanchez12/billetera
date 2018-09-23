/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.confCategorias;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Briam
 */
public class confCategoriasController implements ActionListener{
    
    private final confCategorias ventana;
     
    public confCategoriasController(confCategorias aThis) {
       ventana = aThis;
    }
    
    public void selectItem(){       
       ventana.getModelo().selectConfiguracion();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       ventana.getModelo().cerrarVentanaConfiguracion();
    }
}
