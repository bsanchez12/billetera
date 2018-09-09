/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Model;

import Logica.VO.categoriasVO;
import Logica.VO.cuentasVO;
import Logica.VO.movimientosVO;
import Logica.bussinesUtility;
import Presentacion.View.addIngreso;
import Presentacion.View.ingreso;
import Presentacion.View.principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
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
    
    private addIngreso ventanaAgregarIngreso;

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
    
    public addIngreso getVentanaAgregarIngreso() {
        if(ventanaAgregarIngreso == null){
            ventanaAgregarIngreso = new addIngreso(this);
        }
        return ventanaAgregarIngreso;
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
               listModel.addElement(categoria.getDesCategoria() + "  $" + String.valueOf(item.getValor()));
           }
           
           getVentanaIngreso().getLstIngresos().setModel(listModel);           
        }catch(Exception e){
            error = true;
        }
        
        if(error){
            getVentanaIngreso().getLblError().setText("Error en la entrada de datos");
        }
    }
    
    public void abrirVentanaAgregarIngreso(){
       getVentanaAgregarIngreso().setSize(400, 400);
       getVentanaAgregarIngreso().setVisible(true);
       FuncionalidadTraerCategoriasByTipo(1);
    }
    
    public void FuncionalidadTraerCategoriasByTipo(int tipoCategoria){
        boolean error = false;
        try{            
           ArrayList<categoriasVO> movimientos = getSistema().getCategoriasByTipo(tipoCategoria);           
           DefaultComboBoxModel listModel = new DefaultComboBoxModel ();
           categoriasVO categoria = new categoriasVO();
           Date fecha = new Date();
           DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
           for(Iterator<categoriasVO> i = movimientos.iterator(); i.hasNext();){
               categoriasVO item = i.next();  
               listModel.addElement(String.valueOf(item.getIdCategoria()) + " - " + item.getDesCategoria());
           }
           getVentanaAgregarIngreso().getDdlcategoria().setModel(listModel);
           getVentanaAgregarIngreso().getLblfechamostrar().setText(String.valueOf(format.format(fecha)));
        }catch(Exception e){
            error = true;
        }
    }
    
    public void FuncionalidadAgregarIngreso(){
        double valor = 0;
        String detalle = "";
        boolean error = false;        
        Date fecha = new Date();
        
        try{
           movimientosVO movimiento = new movimientosVO();
           cuentasVO cuenta = new cuentasVO();
           System.out.println(getVentanaAgregarIngreso().getDdlcategoria().getSelectedItem());
           cuenta.setIdCuenta(0);
           detalle = getVentanaAgregarIngreso().getjTextArea1().getText();
           valor = Double.parseDouble(getVentanaAgregarIngreso().getTxtvalor().getText());
           movimiento.setDetalle(detalle);
           movimiento.setFecha(fecha);
           movimiento.setTipoMovimiento(1);
           //getSistema().insertarMovimiento(movimiento);
        }catch(NumberFormatException e){
            error = true;
        }
    }
    
    public void CerrarVentanaAgregarIngreso(){
        getVentanaAgregarIngreso().setVisible(false);
    }
                
}
