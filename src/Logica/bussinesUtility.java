/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import AccesoDatos.DAOImpl.categoriasDAOImpl;
import AccesoDatos.DAOImpl.cuentasDAOImpl;
import AccesoDatos.DAOImpl.movimientoDAOImpl;
import Logica.VO.categoriasVO;
import Logica.VO.cuentasVO;
import Logica.VO.detalleCuentaVO;
import Logica.VO.movimientosVO;
import Logica.VO.resumenCuentasVO;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class bussinesUtility {
    
    public ArrayList<cuentasVO> resumenCuentas(){
      ArrayList<cuentasVO> cuentas=new ArrayList();
      try {
            cuentasDAOImpl cuentasList = new cuentasDAOImpl();
            cuentas = cuentasList.getAllCuentas();
      }catch (Exception e) {
         System.out.println(e.getMessage()); 
      }
      return cuentas;
    }
    
    public ArrayList<resumenCuentasVO> resumenSaldoCuentas (){
        ArrayList<resumenCuentasVO> resumencuentas= new ArrayList();
        
        try {
                movimientoDAOImpl movimientoList = new movimientoDAOImpl();
                resumencuentas=movimientoList.getResumenCuentas();
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
        
        return resumencuentas;
    }
    
    
    public ArrayList<movimientosVO> resumenTipoMovimiento(int idTipoMovimiento){
       ArrayList<movimientosVO> movimientoByTipo = new ArrayList();
       
       try{
          movimientoDAOImpl movimientoList = new movimientoDAOImpl();
          movimientoByTipo = movimientoList.getMovimientoByidTipoMov(idTipoMovimiento);
       }catch (Exception e) {
          System.out.println(e.getMessage()); 
       }
       
       return movimientoByTipo;
    }
    
    public int insertarMovimiento(movimientosVO movimiento){
       int result = 0;
        
       try{
          movimientoDAOImpl movimientoList = new movimientoDAOImpl();
          result = movimientoList.insertMovimiento(movimiento);
       }catch (Exception e) {
          System.out.println(e.getMessage()); 
       }
       
       return result;
    }
 
    public int insertarCategoria(categoriasVO categoria){
       int result = 0;
        
       try{
          categoriasDAOImpl categoriaInsert = new categoriasDAOImpl();
          result = categoriaInsert.insertCategoria(categoria);
       }catch (Exception e) {
          System.out.println(e.getMessage()); 
       }
       
       return result;
    }
     
    public ArrayList<categoriasVO> getCategoriasByTipo(int tipoCategoria){
      ArrayList<categoriasVO> result = new ArrayList<>();
       try{
          categoriasDAOImpl categoriaList = new categoriasDAOImpl();
          result = categoriaList.getCategoriaByTipo(tipoCategoria);
       }catch (Exception e) {
          System.out.println(e.getMessage()); 
       }
        return result;
    }
    
    public ArrayList<cuentasVO> getCuentas(){
        ArrayList<cuentasVO> result = new ArrayList<>();
         try{
          cuentasDAOImpl cuentaList = new cuentasDAOImpl();
          result = cuentaList.getAllCuentas();
       }catch (Exception e) {
          System.out.println(e.getMessage()); 
       }
        return result;
    }
    
    public ArrayList<cuentasVO> getCuentasInicial(){
        ArrayList<cuentasVO> result = new ArrayList<>();
         try{
          cuentasDAOImpl cuentaList = new cuentasDAOImpl();
          result = cuentaList.getAllCuentasInitial();
       }catch (Exception e) {
          System.out.println(e.getMessage()); 
       }
        return result;
    }
    
    public movimientosVO getMovimientoById(int idMovimiento){
        movimientosVO result = new movimientosVO();
         try{
          movimientoDAOImpl movimiento = new movimientoDAOImpl();
          result = movimiento.getMovimientoById(idMovimiento);
       }catch (Exception e) {
          System.out.println(e.getMessage()); 
       }
        return result;
    }
    
    public ArrayList<cuentasVO> getAllCuentas(){
        cuentasDAOImpl cuentas=new cuentasDAOImpl();
        ArrayList<cuentasVO> lisCuentas=new ArrayList();
        try {
            lisCuentas=cuentas.getAllCuentas();
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
        return lisCuentas;
        
    }
    
    public ArrayList<detalleCuentaVO> getDetailCount(int idCuenta)
    {
        ArrayList<detalleCuentaVO> detailCount=new ArrayList();
         movimientoDAOImpl movimiento = new movimientoDAOImpl();
         try {
            detailCount=movimiento.getMovimientoByIdCuenta(idCuenta);
        } catch (Exception e) {
            System.out.println(e.getMessage()); 
        }
         return detailCount;
    }
}
