/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAO;

import Logica.VO.categoriasVO;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public interface IcategoriasDAO {
    
    public int insertCategoria(categoriasVO categoria) throws Exception;
    public categoriasVO getCategoria (int idCategoria) throws Exception;
    public ArrayList<categoriasVO> getAllCategorias() throws Exception;
    public int deleteCategoria(int idCategoria)throws Exception;
    public ArrayList<categoriasVO> getCategoriaByTipo (int tipoCategoria) throws Exception;
}
