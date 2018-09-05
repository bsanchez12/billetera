/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAO;

import Logica.VO.cuentasVO;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public interface IcuentasDAO {
    
    public int insertCuentas(cuentasVO cuentas) throws Exception;
    public cuentasVO getCuentas (int idCuenta) throws Exception;
    public ArrayList<cuentasVO> getAllCuentas() throws Exception;
    public int deleteCuentas(int idCuenta)throws Exception;
    
}
