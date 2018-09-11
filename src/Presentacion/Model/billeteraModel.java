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
import Presentacion.View.addGasto;
import Presentacion.View.addIngreso;
import Presentacion.View.detailGasto;
import Presentacion.View.detailIngreso;
import Presentacion.View.gasto;
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

/**
 *
 * @author Estudiantes
 */
public class billeteraModel {
    
    private bussinesUtility sistema;
    
    private principal ventanaPrincipal;
    
    private ingreso ventanaIngreso;
    
    private gasto ventanaGasto;
    
    private addIngreso ventanaAgregarIngreso;
    
    private addGasto ventanaAgregarGasto;
    
    private detailIngreso ventanaDetalleIngreso;
    
    private detailGasto ventanaDetalleGasto;

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
    
     public gasto getVentanaGasto() {
        if(ventanaGasto == null){
            ventanaGasto = new gasto(this);
        }
        return ventanaGasto;
    }
    
    public addIngreso getVentanaAgregarIngreso() {
        if(ventanaAgregarIngreso == null){
            ventanaAgregarIngreso = new addIngreso(this);
        }
        return ventanaAgregarIngreso;
    }
    
    public addGasto getVentanaAgregarGasto() {
        if(ventanaAgregarGasto == null){
            ventanaAgregarGasto = new addGasto(this);
        }
        return ventanaAgregarGasto;
    }
    
    public detailIngreso getventanaDetalleIngreso() {
        if(ventanaDetalleIngreso == null){
            ventanaDetalleIngreso = new detailIngreso(this);
        }
        return ventanaDetalleIngreso;
    }
     
    public detailGasto getventanaDetalleGasto() {
        if(ventanaDetalleGasto == null){
            ventanaDetalleGasto = new detailGasto(this);
        }
        return ventanaDetalleGasto;
    }

     public void iniciar() {
        //getVentanaPrincipal().setSize(400, 400);
        //getVentanaPrincipal().setVisible(true);
        //getVentanaIngreso().setSize(400, 400);
        //getVentanaIngreso().setVisible(true);
        //FuncionalidadListarIngresos(1);
        getVentanaGasto().setSize(400, 400);
        getVentanaGasto().setVisible(true);
        FuncionalidadListarGastos(2);
    }
     
    public void FuncionalidadListarGastos(int idTipoMovimiento){
        int tipoMovimiento = idTipoMovimiento;
        boolean error = false;
        try{            
           ArrayList<movimientosVO> movimientos = getSistema().resumenTipoMovimiento(idTipoMovimiento);           
           DefaultListModel listModel = new DefaultListModel();
           categoriasVO categoria = new categoriasVO();
           for(Iterator<movimientosVO> i = movimientos.iterator(); i.hasNext();){
               movimientosVO item = i.next();
               categoria = item.getCategoria();               
               listModel.addElement(item.getIdMovimiento() + "-" +  categoria.getDesCategoria() + "  $" + String.valueOf(item.getValor()));
           }
           
            getVentanaGasto().getLstgastos().setModel(listModel);           
        }catch(Exception e){
            error = true;
        }
        
        if(error){
            getVentanaIngreso().getLblError().setText("Error en la entrada de datos");
        }
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
               listModel.addElement(item.getIdMovimiento() + "-" +  categoria.getDesCategoria() + "  $" + String.valueOf(item.getValor()));
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
       FuncionalidadCargarDataInicial(1);
    }

    public void abrirVentanaAgregarGasto(){
       getVentanaAgregarGasto().setSize(400, 400);
       getVentanaAgregarGasto().setVisible(true);
       FuncionalidadCargarDataInicial(2);
    }
    
    public void FuncionalidadCargarDataInicial(int tipoCategoria){
        boolean error = false;
        try{   
           Date fecha = new Date();
           DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
           //cargue de informacion de cuentas
           ArrayList<cuentasVO> cuentas = getSistema().getCuentas();  
           DefaultComboBoxModel listModelCuenta = new DefaultComboBoxModel ();                     
           for(Iterator<cuentasVO> i = cuentas.iterator(); i.hasNext();){
               cuentasVO item = i.next();  
               listModelCuenta.addElement(String.valueOf(item.getIdCuenta()) + " - " + item.getNombreCuenta());               
           }
                     
           //cargue de informacion de categorias
           ArrayList<categoriasVO> movimientos = getSistema().getCategoriasByTipo(tipoCategoria);           
           DefaultComboBoxModel listModel = new DefaultComboBoxModel ();                     
           for(Iterator<categoriasVO> i = movimientos.iterator(); i.hasNext();){
               categoriasVO item = i.next();  
               listModel.addElement(String.valueOf(item.getIdCategoria()) + " - " + item.getDesCategoria());
           }
           
           if(tipoCategoria == 1){
              getVentanaAgregarIngreso().getDdlcuenta().setModel(listModelCuenta);
              getVentanaAgregarIngreso().getDdlcategoria().setModel(listModel);
              getVentanaAgregarIngreso().getLblfechamostrar().setText(String.valueOf(format.format(fecha)));
           }else{
              getVentanaAgregarGasto().getDdlcuenta().setModel(listModelCuenta);
              getVentanaAgregarGasto().getDdlcategoria().setModel(listModel);
              getVentanaAgregarGasto().getLblfechamostrar().setText(String.valueOf(format.format(fecha)));
           }
           
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
           categoriasVO categoria = new categoriasVO();
           String categoriaSelected = (String) getVentanaAgregarIngreso().getDdlcategoria().getSelectedItem().toString().split("-")[0].trim();                                
           String cuentaSelected = (String) getVentanaAgregarIngreso().getDdlcuenta().getSelectedItem().toString().split("-")[0].trim();                                
           cuenta.setIdCuenta(Integer.parseInt(cuentaSelected));
           categoria.setIdCategoria(Integer.parseInt(categoriaSelected));
           detalle = getVentanaAgregarIngreso().getjTextArea1().getText();
           valor = Double.parseDouble(getVentanaAgregarIngreso().getTxtvalor().getText());
           movimiento.setDetalle(detalle);
           movimiento.setFecha(fecha);
           movimiento.setCategoria(categoria);
           movimiento.setCuentas(cuenta);
           movimiento.setTipoMovimiento(1);
           movimiento.setValor(valor);
           getSistema().insertarMovimiento(movimiento);
           getVentanaAgregarIngreso().setVisible(false);
           FuncionalidadListarIngresos(1);
        }catch(NumberFormatException e){
            error = true;
        }
        
        if(error){
            getVentanaAgregarIngreso().getLblerror().setText("Error en la entrada de datos");
        }
    }
    
    public void FuncionalidadAgregarGasto(){
        double valor = 0;
        String detalle = "";
        boolean error = false;        
        Date fecha = new Date();
        
        try{
           movimientosVO movimiento = new movimientosVO();
           cuentasVO cuenta = new cuentasVO();
           categoriasVO categoria = new categoriasVO();
           String categoriaSelected = (String) getVentanaAgregarGasto().getDdlcategoria().getSelectedItem().toString().split("-")[0].trim();                                
           String cuentaSelected = (String) getVentanaAgregarGasto().getDdlcuenta().getSelectedItem().toString().split("-")[0].trim();                                
           cuenta.setIdCuenta(Integer.parseInt(cuentaSelected));
           categoria.setIdCategoria(Integer.parseInt(categoriaSelected));
           detalle = getVentanaAgregarGasto().getTxadetalle().getText();
           valor = Double.parseDouble(getVentanaAgregarGasto().getTxtvalor().getText());
           movimiento.setDetalle(detalle);
           movimiento.setFecha(fecha);
           movimiento.setCategoria(categoria);
           movimiento.setCuentas(cuenta);
           movimiento.setTipoMovimiento(2);
           movimiento.setValor(valor);
           getSistema().insertarMovimiento(movimiento);
           getVentanaAgregarGasto().setVisible(false);
           FuncionalidadListarGastos(2);
        }catch(NumberFormatException e){
            error = true;
        }
        
        if(error){
            getVentanaAgregarGasto().getLblerror().setText("Error en la entrada de datos");
        }
    }
    
    public void CerrarVentanaAgregarIngreso(){
        getVentanaAgregarIngreso().setVisible(false);
        FuncionalidadListarIngresos(1);
        getVentanaAgregarIngreso().getjTextArea1().setText("");
        getVentanaAgregarIngreso().getTxtvalor().setText("");
    }
    
    public void CerrarVentanaAgregarGasto(){
        getVentanaAgregarGasto().setVisible(false);
        FuncionalidadListarGastos(2);
        getVentanaAgregarGasto().getTxadetalle().setText("");
        getVentanaAgregarGasto().getTxtvalor().setText("");
    }
       
    public void selectedMovimiento(int idTipoMovimiento){                     
       if(idTipoMovimiento == 1){
            int idMovimiento = Integer.parseInt(getVentanaIngreso().getLstIngresos().getSelectedValue().split("-")[0].trim());       
            movimientosVO movimiento = getSistema().getMovimientoById(idMovimiento); 
            getventanaDetalleIngreso().setSize(400, 400);
            getventanaDetalleIngreso().setVisible(true);
            getventanaDetalleIngreso().getLbldetallemostrar().setText(movimiento.getDetalle());
            getventanaDetalleIngreso().getLblfechamostrar().setText(movimiento.getFecha().toGMTString());
            getventanaDetalleIngreso().getLblvalormostrar().setText(String.valueOf(movimiento.getValor()));
            getventanaDetalleIngreso().getLblcuentamostrar().setText(movimiento.getCuentas().getNombreCuenta());
            getventanaDetalleIngreso().getLblcategoriamostrar().setText(movimiento.getCategoria().getDesCategoria());
       }else{
            int idMovimiento = Integer.parseInt(getVentanaGasto().getLstgastos().getSelectedValue().split("-")[0].trim());       
            movimientosVO movimiento = getSistema().getMovimientoById(idMovimiento); 
            getventanaDetalleGasto().setSize(400, 400);
            getventanaDetalleGasto().setVisible(true);
            getventanaDetalleGasto().getLbldetallemostrar().setText(movimiento.getDetalle());
            getventanaDetalleGasto().getLblfechamostrar().setText(movimiento.getFecha().toGMTString());
            getventanaDetalleGasto().getLblvalormostrar().setText(String.valueOf(movimiento.getValor()));
            getventanaDetalleGasto().getLblcuentamostrar().setText(movimiento.getCuentas().getNombreCuenta());
            getventanaDetalleGasto().getLblcategoriamostrar().setText(movimiento.getCategoria().getDesCategoria());
       }      
    }        
    
    public void cerrarDetalleIngreso(){
       getventanaDetalleIngreso().setVisible(false);
       getventanaDetalleIngreso().getLbldetallemostrar().setText("");
       getventanaDetalleIngreso().getLblfechamostrar().setText("");
       getventanaDetalleIngreso().getLblvalormostrar().setText("");
       getventanaDetalleIngreso().getLblcuentamostrar().setText("");
       getventanaDetalleIngreso().getLblcategoriamostrar().setText("");
    }
    
    public void cerrarDetalleGasto(){
       getventanaDetalleGasto().setVisible(false);
       getventanaDetalleGasto().getLbldetallemostrar().setText("");
       getventanaDetalleGasto().getLblfechamostrar().setText("");
       getventanaDetalleGasto().getLblvalormostrar().setText("");
       getventanaDetalleGasto().getLblcuentamostrar().setText("");
       getventanaDetalleGasto().getLblcategoriamostrar().setText("");
    }
    
    public void cerrarVentanaIngresos(){
        getVentanaIngreso().setVisible(false);
    }
    
     public void cerrarVentanaGastos(){
        getVentanaGasto().setVisible(false);
    }
}
