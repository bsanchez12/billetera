/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAO;

import Logica.VO.movimientosVO;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public interface ImovimientosDAO {
    
    public int insertMovimiento(movimientosVO movimiento) throws Exception;
    public movimientosVO getMovimientoByIdCuenta (int idCuenta) throws Exception;
    public double getSaldoByIdCuenta (int idCuenta) throws Exception;
    public ArrayList<movimientosVO> getMovimientoByidTipoMov (int idtipoMoviento) throws Exception;
    public ArrayList<movimientosVO> getAllMovimientos () throws Exception;
    public movimientosVO getMovimientoById (int idMovimiento) throws Exception;
}
