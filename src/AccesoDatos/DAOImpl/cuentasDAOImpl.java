/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAOImpl;

import AccesoDatos.DAO.IcuentasDAO;
import Helpers.sqliteHelper;
import Logica.VO.categoriasVO;
import Logica.VO.cuentasVO;
import Logica.VO.personasVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class cuentasDAOImpl implements IcuentasDAO{

    @Override
    public int insertCuentas(cuentasVO cuentas) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public cuentasVO getCuentas(int idCuenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<cuentasVO> getAllCuentas() throws Exception {
        String sql = "SELECT id_cuenta, nombre_cuenta FROM cuenta";             
        sqliteHelper sqlite = new sqliteHelper();
        ArrayList<cuentasVO> result = new ArrayList<>();
        cuentasVO cuenta = new cuentasVO();
        personasVO persona = new personasVO();
        try (Connection conn = sqlite.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                persona = new personasVO(1, "John Smith");
                cuenta = new cuentasVO(rs.getInt("id_cuenta"), rs.getString("nombre_cuenta"), persona,0);               
                result.add(cuenta);
            }
        } catch (SQLException e) {
            System.out.println("ERROR BD - " + e.getMessage());
        } 
        return result;
    }

    @Override
    public int deleteCuentas(int idCuenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
