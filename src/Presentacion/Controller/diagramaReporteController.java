/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.diagramaReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiantes
 */
public class diagramaReporteController implements ActionListener{
    private final diagramaReportes ventana;
    
    public diagramaReporteController(diagramaReportes aThis) {
        ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ventana.getModelo().cerrarVentanaDiagramaReporte();
    }
}
