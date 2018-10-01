/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAO;

import Logica.VO.detalleCuentaVO;
import Logica.VO.movimientosVO;
import Logica.VO.reporteVO;
import Logica.VO.resumenCuentasVO;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public interface ImovimientosDAO {    
    public int insertMovimiento(movimientosVO movimiento) throws Exception;
    public ArrayList<detalleCuentaVO> getMovimientoByIdCuenta (int idCuenta) throws Exception;
    public double getSaldoByIdCuenta (int idCuenta) throws Exception;
    public ArrayList<movimientosVO> getMovimientoByidTipoMov (int idtipoMoviento) throws Exception;
    public ArrayList<resumenCuentasVO> getResumenCuentas () throws Exception;
    public ArrayList<movimientosVO> getAllMovimientos () throws Exception;
    public movimientosVO getMovimientoById (int idMovimiento) throws Exception;
    public ArrayList<reporteVO> getReporteCategoria () throws Exception;
}
