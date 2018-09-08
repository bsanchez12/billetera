/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import AccesoDatos.DAOImpl.cuentasDAOImpl;
import AccesoDatos.DAOImpl.movimientoDAOImpl;
import Logica.VO.cuentasVO;
import Logica.VO.movimientosVO;
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
            
      }
      return cuentas;
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
 
}
