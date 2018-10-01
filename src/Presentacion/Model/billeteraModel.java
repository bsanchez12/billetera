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
import Logica.VO.reporteVO;
import Logica.VO.resumenCuentasVO;
import Logica.bussinesUtility;
import Presentacion.View.addCategoria;
import Presentacion.View.addGasto;
import Presentacion.View.addIngreso;
import Presentacion.View.detailCount;
import Presentacion.View.addCuentas;
import Presentacion.View.confCategorias;
import Presentacion.View.detailGasto;
import Presentacion.View.detailIngreso;
import Presentacion.View.diagramaReportes;
import Presentacion.View.gasto;
import Presentacion.View.ingreso;
import Presentacion.View.listCategorias;
import Presentacion.View.principal;
import Presentacion.View.reportes;
import Presentacion.View.resumenCuenta;
import Presentacion.View.traslados;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author Estudiantes
 */
public class billeteraModel {
    
    //Variables para graficos
    private double topeMaximo;
    private double topeMedio;
    private Map <String,String> listaValores; 

    public double getTopeMaximo() {
        return topeMaximo;
    }

    public void setTopeMaximo(double topeMaximo) {
        this.topeMaximo = topeMaximo;
    }

    public double getTopeMedio() {
        return topeMedio;
    }

    public void setTopeMedio(double topeMedio) {
        this.topeMedio = topeMedio;
    }

    public Map<String, String> getListaValores() {
        return listaValores;
    }

    public void setListaValores(Map<String, String> listaValores) {
        this.listaValores = listaValores;
    }
            
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
    
    private confCategorias ventanaConfiguracion;
    
    private listCategorias ventanaListaConfiguracion;
    
    private addCategoria ventanaAgregarConfiguracion;
    
    private reportes ventanaReportes;
    
    private diagramaReportes ventanaDiagramaReportes;
    
    private BufferedImage dobleBuffer;
    
    public billeteraModel(){
        dobleBuffer = new BufferedImage(getVentanaDiagramaReportes().getCvnReporte().getWidth(), getVentanaDiagramaReportes().getCvnReporte().getHeight(), BufferedImage.TYPE_INT_ARGB);
    }
        
    public diagramaReportes getVentanaDiagramaReportes() {
        if(ventanaDiagramaReportes==null)
        {
            ventanaDiagramaReportes= new diagramaReportes(this);
        }
        return ventanaDiagramaReportes;
    }
    
    public reportes getVentanaReportes() {
        if(ventanaReportes==null)
        {
            ventanaReportes= new reportes(this);
        }
        return ventanaReportes;
    }
    
    
    public addCategoria getventanaAgregarConfiguracion() {
        if(ventanaAgregarConfiguracion==null)
        {
            ventanaAgregarConfiguracion= new addCategoria(this);
        }
        return ventanaAgregarConfiguracion;
    }
    
    public listCategorias getventanaListaConfiguracion() {
        if(ventanaListaConfiguracion==null)
        {
            ventanaListaConfiguracion= new listCategorias(this);
        }
        return ventanaListaConfiguracion;
    }
    
    public confCategorias getVentanaConfiguracion() {
        if(ventanaConfiguracion==null)
        {
            ventanaConfiguracion= new confCategorias(this);
        }
        return ventanaConfiguracion;
    }

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
           ArrayList<cuentasVO> cuentas = getSistema().getCuentasInicial();  
           DefaultComboBoxModel listModelCuenta = new DefaultComboBoxModel ();                     
           for(Iterator<cuentasVO> i = cuentas.iterator(); i.hasNext();){               
               cuentasVO item = i.next();  
               System.out.println(String.valueOf(item.getIdCuenta()));
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

    public void abrirVentanaConfiguracion() {
        getVentanaConfiguracion().setSize(400, 400);
        getVentanaConfiguracion().setVisible(true);
    }

    public void cerrarVentanaConfiguracion() {
        getVentanaConfiguracion().setVisible(false);
    }

    public void selectConfiguracion() {
        int idTipoConfiuracion = Integer.parseInt(getVentanaConfiguracion().getLstConfiguracion().getSelectedValue().split("-")[0].trim());                   
        
        cargarConfiguracion(idTipoConfiuracion);
                
        getventanaListaConfiguracion().setSize(400, 400);
        getventanaListaConfiguracion().setVisible(true);
    }
    
    public void cargarConfiguracion(int tipoConfiguracion){        
        DefaultComboBoxModel listModelCategoria = new DefaultComboBoxModel ();
        
        if(tipoConfiguracion == 1){
            getventanaListaConfiguracion().getLblTituloConfiguracion().setText("Categorias Ingresos:");
        }else{
            getventanaListaConfiguracion().getLblTituloConfiguracion().setText("Categorias Gastos:");
        }
        
        ArrayList<categoriasVO> listCategorias = getSistema().getCategoriasByTipo(tipoConfiguracion);        
        for(Iterator<categoriasVO> i = listCategorias.iterator(); i.hasNext();){
            categoriasVO item = i.next();
            listModelCategoria.addElement(String.valueOf(item.getIdCategoria()) + " - " + item.getDesCategoria());
        }        
        
        getventanaListaConfiguracion().getLstCategorias().setModel(listModelCategoria);
    }

    public void cerrarVentanaListaCategorias() {
        getventanaListaConfiguracion().setVisible(false);
    }

    public void cerrarVentanaAgregarCategorias() {        
        getventanaAgregarConfiguracion().setVisible(false);
    }

    public void abrirVentanaAgregarCategorias() {
        
        if(getventanaListaConfiguracion().getLblTituloConfiguracion().getText() == "Categorias Ingresos:")
        {
           getventanaAgregarConfiguracion().getLblCategoria().setText("Ingresos");
        }else{
           getventanaAgregarConfiguracion().getLblCategoria().setText("Gastos"); 
        }
        
        getventanaAgregarConfiguracion().setSize(400,400);
        getventanaAgregarConfiguracion().setVisible(true);
    }

    public void agregarCategoria() {
        categoriasVO categoria = new categoriasVO();
        int tipoCategoria = 0;
        categoria.setDesCategoria(getventanaAgregarConfiguracion().getTxtCategoria().getText());
        if(getventanaAgregarConfiguracion().getLblCategoria().getText() == "Ingresos")
        {
          tipoCategoria = 1;
        }else{
          tipoCategoria = 2;
        }
        categoria.setTipoCategoria(tipoCategoria);
        getSistema().insertarCategoria(categoria);
        cargarConfiguracion(tipoCategoria);
        getventanaAgregarConfiguracion().getTxtCategoria().setText("");
        getventanaAgregarConfiguracion().setVisible(false);
    }

    public void abrirVentanaReportes() {
        getVentanaReportes().setSize(400,400);
        getVentanaReportes().setVisible(true);
    }

    public void cerrarVentanaReportes() {
        getVentanaReportes().setVisible(false);
    }

    public void abrirVentanaDetalleReporte() {
        int tiporeporte = Integer.parseInt(getVentanaReportes().getLstReporte().getSelectedValue().split("-")[0].trim());
        getVentanaDiagramaReportes().setSize(700,700);
        getVentanaDiagramaReportes().setVisible(true);
        verReporte(tiporeporte);
    }

    public void verReporte(int tipoReporte) {        
        Canvas lienzo = getVentanaDiagramaReportes().getCvnReporte();
        Graphics lapiz = dobleBuffer.getGraphics();
        int x = 0;
        int y = 0;
        int z = 0;
        int a = 0;
        int color = 1000; 
        int lineaInferiro = 230;

        lapiz.setColor(Color.GRAY);
        lapiz.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
        //Lineas base
        lapiz.setColor(Color.BLUE);
        lapiz.fillRect(20, 40, 2, 330);       
        //Linea mitad
        lapiz.fillRect(20, 205, 350, 1);
        //Leyendas Valores           
        
        if(tipoReporte == 1){
            reporteIngresoGastos();                                          
        }else if(tipoReporte == 2){
            reporteCategoria(1);
        }else if(tipoReporte == 3){
            reporteCategoria(2);
        }  
        
        lapiz.drawString(Double.toString(topeMaximo), 22, 40);
        lapiz.drawString(Double.toString(topeMedio), 22, 204);
        lapiz.drawString("0", 22, 369);         

        if(topeMaximo > 0)
        {
            topeMedio = topeMaximo/2;
        } 
        
        Map <String,String> reporte = getListaValores(); 

        if(reporte!=null)
        {
             for (Map.Entry<String , String> entry : reporte.entrySet()) { 
                a=((Integer.parseInt(entry.getValue())*330)/(int)topeMaximo);
                y=370-a;
                x=x+50;
                lapiz.setColor(Color.getColor("default",color));                      
                lapiz.fillRect(x, y, 70, a);
                String[] arrayLeyenda = entry.getKey().split("-");                
                lapiz.drawString(arrayLeyenda[0], x+10 , 390);
                lapiz.drawString(arrayLeyenda[1], x+10 , 410);
                x=x+50;
                color=color+5000;

                lapiz.setColor(Color.RED);
                lapiz.fillRect(20, 370, lineaInferiro, 2);
                lineaInferiro=lineaInferiro+60;
            }
        }
   
        Graphics pincel = lienzo.getGraphics();
        pincel.drawImage(dobleBuffer, 0, 0, lienzo);
    }
    
    public void reporteIngresoGastos()
    {
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
       }
      
      listaValores=new HashMap<String,String>();
      
      if(ingresos>gastos)
      {
        topeMaximo = ingresos;
      }else
      {
        topeMaximo = gastos;
      }
      
      listaValores.put("Ingresos-" + Integer.toString(ingresos.intValue()), Integer.toString(ingresos.intValue()));
      listaValores.put("Gastos-" + Integer.toString(gastos.intValue()) , Integer.toString(gastos.intValue()));            
    }
    
    public void reporteCategoria(int idTipoMovimiento)
    {              
        ArrayList<reporteVO> reporteCategoria = getSistema().getReporteCategoria(idTipoMovimiento); 
        
        listaValores = new HashMap<String,String>();
        Double numeromayor = reporteCategoria.get(0).getSaldoLeyenda();
        for(Iterator<reporteVO> i = reporteCategoria.iterator(); i.hasNext();){
            reporteVO item = i.next();
            if(item.getSaldoLeyenda() > numeromayor)
            {
               numeromayor = item.getSaldoLeyenda();
            }       
            listaValores.put(item.getLeyenda() + "-" + Integer.toString(item.getSaldoLeyenda().intValue()), Integer.toString(item.getSaldoLeyenda().intValue()));
        }
        topeMaximo = numeromayor;       
    }

    public void cerrarVentanaDiagramaReporte() {
        getVentanaDiagramaReportes().setVisible(false);
    }
}
