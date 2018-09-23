/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAO;


import Logica.VO.personasVO;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public interface IpersonasDAO {
    
    public int insertPersona(personasVO persona) throws Exception;
    public personasVO getPersona (int cedula) throws Exception;
    
}
