/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Model;

import Logica.VO.categoriasVO;
import Logica.VO.cuentasVO;
import Logica.VO.detalleCuentaVO;
import Logica.VO.movimientosVO;
import Logica.VO.resumenCuentasVO;
import Logica.bussinesUtility;
import Presentacion.View.addGasto;
import Presentacion.View.addIngreso;
import Presentacion.View.detailCount;
import Presentacion.View.addCuentas;
import Presentacion.View.detailGasto;
import Presentacion.View.detailIngreso;
import Presentacion.View.gasto;
import Presentacion.View.ingreso;
import Presentacion.View.principal;
import Presentacion.View.resumenCuenta;
import Presentacion.View.traslados;
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
    
    private detailCount ventanaDatelleCuenta;
    
    private resumenCuenta ventanaResumenCuenta;
    
    private traslados ventanaTraslados;

    public traslados getVentanaTraslados() {
        if(ventanaTraslados==null)
        {
            ventanaTraslados= new traslados(this);
        }
        return ventanaTraslados;
    }

    public resumenCuenta getVentanaResumenCuenta() {
        
        if(ventanaResumenCuenta==null)
        {
            ventanaResumenCuenta= new resumenCuenta(this);
        }
        return ventanaResumenCuenta;
    }

    public detailCount getVentanaDatelleCuenta() {
        
        if(ventanaDatelleCuenta==null)
        {
            ventanaDatelleCuenta= new detailCount(this);
        }
        return ventanaDatelleCuenta;
    }

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



    //Logica para carga inicial de pantalla
    public void iniciar() {
       getVentanaPrincipal().setSize(400, 400);
       getVentanaPrincipal().setVisible(true);
       funcionalidadCargaTotalCuentas();
        //getVentanaIngreso().setSize(400, 400);
        //getVentanaIngreso().setVisible(true);
        //FuncionalidadListarIngresos(1);
    }
     
    //Genera listado de gastos
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
     
    //Genera Listado de ingresos
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
    
    public void abrirVentanaIngresos(){
        getVentanaIngreso().setSize(400, 400);
        getVentanaIngreso().setVisible(true);
        FuncionalidadListarIngresos(1);
    }
    
    public void abrirVentanaGastos(){
        getVentanaGasto().setSize(400, 400);
        getVentanaGasto().setVisible(true);
        FuncionalidadListarGastos(2);
    }
    
    //Cierra ventana de agregar Ingreso
    public void abrirVentanaAgregarIngreso(){
       getVentanaAgregarIngreso().setSize(400, 400);
       getVentanaAgregarIngreso().setVisible(true);
       FuncionalidadCargarDataInicial(1);
    }

    //Cierra ventana de agregar Gasto
    public void abrirVentanaAgregarGasto(){
       getVentanaAgregarGasto().setSize(400, 400);
       getVentanaAgregarGasto().setVisible(true);
       FuncionalidadCargarDataInicial(2);
    }
    
    //Carga de data inicial para las dos pantallas ingresos o gastos
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
    
    //Insertar ingreso en BD
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
           funcionalidadCargaTotalCuentas();
        }catch(NumberFormatException e){
            error = true;
        }
        
        if(error){
            getVentanaAgregarIngreso().getLblerror().setText("Error en la entrada de datos");
        }
    }
    
    //Insertar gasto en BD
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
           funcionalidadCargaTotalCuentas();
           
        }catch(NumberFormatException e){
            error = true;
        }
        
        if(error){
            getVentanaAgregarGasto().getLblerror().setText("Error en la entrada de datos");
        }
    }
    
    //cerra ventana de agregar ingreso
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
        funcionalidadCargaTotalCuentas();
    }
       
    public void selectedMovimiento(int idTipoMovimiento){                     
       if(idTipoMovimiento == 1){
            int idMovimiento = Integer.parseInt(getVentanaIngreso().getLstIngresos().getSelectedValue().split("-")[0].trim());       
            movimientosVO movimiento = getSistema().getMovimientoById(idMovimiento); 
            getventanaDetalleIngreso().setSize(400, 400);
            getventanaDetalleIngreso().setVisible(true);
            System.out.println(movimiento.getFecha());
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
    
    public void selectCuenta()
    {
         
        System.out.println("antes");
         int idMovimiento = Integer.parseInt(getVentanaDatelleCuenta().getLstCuentas().getSelectedValue().split("-")[0].trim()); 
        System.out.println(getVentanaDatelleCuenta().getLstCuentas().getSelectedValue().split("-")[0].trim());
         ArrayList<detalleCuentaVO> detalleCuenta=getSistema().getDetailCount(idMovimiento);
         DefaultListModel listModel = new DefaultListModel();
         detalleCuentaVO detalle=new detalleCuentaVO();
        for(Iterator<detalleCuentaVO> i =detalleCuenta.iterator();i.hasNext(); )
        {
            detalle  = i.next();
            
            listModel.addElement(detalle.getDetalle() + "  "+detalle.getValor().toString() );
        }
      
        
           getVentanaResumenCuenta().getLstDetallecuenta().setModel(listModel);
           getVentanaResumenCuenta().setSize(400, 400);
           getVentanaResumenCuenta().setVisible(true);
    }
    
    public void cerrarResumenCuenta(){
         getVentanaResumenCuenta().setVisible(false);
    }
    public void cerrarDetalleIngreso(){
       getventanaDetalleIngreso().setVisible(false);
       getventanaDetalleIngreso().getLbldetallemostrar().setText("");
       getventanaDetalleIngreso().getLblfechamostrar().setText("");
       getventanaDetalleIngreso().getLblvalormostrar().setText("");
       getventanaDetalleIngreso().getLblcuentamostrar().setText("");
       getventanaDetalleIngreso().getLblcategoriamostrar().setText("");
        funcionalidadCargaTotalCuentas();
       
    }
    
    public void cerrarDetalleGasto(){
       getventanaDetalleGasto().setVisible(false);
       getventanaDetalleGasto().getLbldetallemostrar().setText("");
       getventanaDetalleGasto().getLblfechamostrar().setText("");
       getventanaDetalleGasto().getLblvalormostrar().setText("");
       getventanaDetalleGasto().getLblcuentamostrar().setText("");
       getventanaDetalleGasto().getLblcategoriamostrar().setText("");
         funcionalidadCargaTotalCuentas();
       
    }
    
    public void cerrarVentanaIngresos(){
        getVentanaIngreso().setVisible(false);
        funcionalidadCargaTotalCuentas();
    }
    
    public void cerrarVentanaDetailCuenta(){
        getVentanaDatelleCuenta().setVisible(false);        
    }
    
     public void cerrarVentanaGastos(){
        getVentanaGasto().setVisible(false);
        funcionalidadCargaTotalCuentas();
    }
               
    //Logica pantalla inicial    
    public void funcionalidadCargaTotalCuentas(){
        //resumenSaldoCuentas
       ArrayList<resumenCuentasVO> resumenCuentas = getSistema().resumenSaldoCuentas(); 
       DefaultListModel listModel = new DefaultListModel();
       resumenCuentasVO saldoCuentas=new resumenCuentasVO();
       Double ingresos,gastos,totalCuentas;
       ingresos=0.0;
       gastos=0.0;
      totalCuentas=0.0;
      
       for(Iterator<resumenCuentasVO> i = resumenCuentas.iterator(); i.hasNext();){
               resumenCuentasVO item = i.next();
               if(1==item.getTipoMovimiento())
               {
                    ingresos=item.getSaldoMovimiento();
               }else if(2==item.getTipoMovimiento())
               {
                   gastos=item.getSaldoMovimiento();
               }
               //listModel.addElement(item.getDesMovimiento() + "  $" + String.valueOf(item.getSaldoMovimiento()));
         }
         totalCuentas=ingresos-gastos;
        

        getVentanaPrincipal().cargarSaldos(ingresos,gastos,totalCuentas);

    }
    
    public void funcionalidadCargarCuentas(){
    
        ArrayList<cuentasVO> listCuentas=getSistema().getAllCuentas();
        DefaultListModel listModel = new DefaultListModel();
        cuentasVO cuentas=new cuentasVO();
        
        for(Iterator<cuentasVO> i =listCuentas.iterator();i.hasNext(); )
        {
            cuentas  = i.next();
            
            listModel.addElement(cuentas.getIdCuenta() + "-" + cuentas.getNombreCuenta() + "-" + cuentas.getSaldo() );
        }
        
        getVentanaDatelleCuenta().getLstCuentas().setModel(listModel);
        
    }
    
    public void abriVentanaCuentas(){
    
        getVentanaDatelleCuenta().setVisible(true);
        getVentanaDatelleCuenta().setSize(400, 400);
        funcionalidadCargarCuentas();
        
    }

    public void abrirVentanaTraslados() {
        getVentanaTraslados().setSize(400, 400);
        getVentanaTraslados().setVisible(true);
    }
    

}
