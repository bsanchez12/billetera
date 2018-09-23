/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Controller;

import Presentacion.View.principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Estudiantes
 */
public class principlaController implements ActionListener {
    
    private final principal ventana;

    public principlaController(principal aThis) {
        ventana = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value = e.getActionCommand();
        System.out.println(e);    
    }
    
    public void ingresos(){
        ventana.getModelo().abrirVentanaIngresos();
    }
    
    public void gastos(){
        ventana.getModelo().abrirVentanaGastos();
    }
    
    public void getIngresos()
    {
        ventana.getModelo().abrirVentanaAgregarIngreso();
    }
    
       public void getGastos()
    {
        ventana.getModelo().abrirVentanaAgregarGasto();
    }
       
    public void allCuentas()
    {
        ventana.getModelo().abriVentanaCuentas();
    }

    public void getTraslados()
    {
        ventana.getModelo().abrirVentanaTraslados();
    }

    public void getConfiguracion() {
        ventana.getModelo().abrirVentanaConfiguracion();
    }

    public void getReportes() {
        ventana.getModelo().abrirVentanaReportes();
    }
}
