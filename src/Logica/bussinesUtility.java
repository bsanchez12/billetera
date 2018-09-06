/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import AccesoDatos.DAOImpl.cuentasDAOImpl;
import Helpers.sqliteHelper;
import Logica.VO.cuentasVO;
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
    
    public void connectDB(){
        sqliteHelper sql = new sqliteHelper();
        sql.connect();
    }
    
    
}
