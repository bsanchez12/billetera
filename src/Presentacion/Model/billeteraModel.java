/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Model;

import Logica.VO.categoriasVO;
import Logica.VO.movimientosVO;
import Logica.bussinesUtility;
import Presentacion.View.ingreso;
import Presentacion.View.principal;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * @author Estudiantes
 */
public class billeteraModel {
    
    private bussinesUtility sistema;
    
    private principal ventanaPrincipal;
    
    private ingreso ventanaIngreso;

    public bussinesUtility getSistema() {
        if(sistema == null){
            sistema = new bussinesUtility();
        }
        return sistema;
    }

    public principal getVentanaPrincipal() {
        if(ventanaPrincipal == null){
            ventanaPrincipal = new principal(this);
        }
        return ventanaPrincipal;
    }
    
      public ingreso getVentanaIngreso() {
        if(ventanaIngreso == null){
            ventanaIngreso = new ingreso(this);
        }
        return ventanaIngreso;
    }

     public void iniciar() {
        //getVentanaPrincipal().setSize(400, 400);
        //getVentanaPrincipal().setVisible(true);
        getVentanaIngreso().setSize(400, 400);
        getVentanaIngreso().setVisible(true);
        FuncionalidadListarIngresos(1);
    }
     
    public void FuncionalidadListarIngresos(int idTipoMovimiento){
        int tipoMovimiento = idTipoMovimiento;
        boolean error = false;
        try{            
           ArrayList<movimientosVO> movimientos = getSistema().resumenTipoMovimiento(idTipoMovimiento);           
           DefaultListModel listModel = new DefaultListModel();
           categoriasVO categoria = new categoriasVO();
           for(Iterator<movimientosVO> i = movimientos.iterator(); i.hasNext();){
               movimientosVO item = i.next();
               categoria = item.getCategoria();               
               listModel.addElement(categoria.getDesCategoria() + "-" + String.valueOf(item.getValor()));
           }
           
           getVentanaIngreso().getLstIngresos().setModel(listModel);
           System.out.println(listModel);
        }catch(Exception e){
            error = true;
        }
        
        if(error){
            getVentanaIngreso().getLblError().setText("Error en la entrada de datos");
        }
    }
                
}
