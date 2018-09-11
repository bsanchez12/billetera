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
        getVentanaPrincipal().setSize(400, 400);
        getVentanaPrincipal().setVisible(true);
        getVentanaPrincipal().cargarSaldos();
        //getVentanaIngreso().setSize(400, 400);
        //getVentanaIngreso().setVisible(true);
        //FuncionalidadListarIngresos(1);
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
       FuncionalidadCargarDataInicial(1);
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
           getVentanaAgregarIngreso().getDdlcuenta().setModel(listModelCuenta);
           //cargue de informacion de categorias
           ArrayList<categoriasVO> movimientos = getSistema().getCategoriasByTipo(tipoCategoria);           
           DefaultComboBoxModel listModel = new DefaultComboBoxModel ();                     
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
           getSistema().insertarMovimiento(movimiento);
        }catch(NumberFormatException e){
            error = true;
        }
    }
    
    public void CerrarVentanaAgregarIngreso(){
        getVentanaAgregarIngreso().setVisible(false);
    }
                
    //Logica pantalla inicial
    
    public void funcionalidadCargaTotalCuentas(){
        
       ArrayList<cuentasVO> cuentas = getSistema().getCuentas();  
           for(Iterator<cuentasVO> i = cuentas.iterator(); i.hasNext();){
               cuentasVO item = i.next();  
              
           }
        
    }
    
}
