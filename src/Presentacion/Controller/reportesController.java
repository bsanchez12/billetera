/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.reportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Briam
 */
public class reportesController implements ActionListener{
    
    private final reportes ventana;
    
    public reportesController(reportes aThis) {
        ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.getModelo().cerrarVentanaReportes();
    }
    
    public void selectItem(){
       ventana.getModelo().abrirVentanaDetalleReporte();
    }
    
}
