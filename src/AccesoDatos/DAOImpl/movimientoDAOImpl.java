/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAOImpl;

import AccesoDatos.DAO.ImovimientosDAO;
import Logica.VO.movimientosVO;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class movimientoDAOImpl implements ImovimientosDAO{

    @Override
    public int insertMovimiento(movimientosVO movimiento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public movimientosVO getMovimientoByIdCuenta(int idCuenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public movimientosVO getMovimientoByidTipoMov(int idtipoMoviento) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<movimientosVO> getAllMovimientos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getSaldoByIdCuenta(int idCuenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
