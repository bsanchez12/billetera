/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAOImpl;

import AccesoDatos.DAO.IcategoriasDAO;
import Helpers.sqliteHelper;
import Logica.VO.categoriasVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Estudiantes
 */
public class categoriasDAOImpl implements IcategoriasDAO {

    @Override
    public int insertCategoria(categoriasVO categoria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public categoriasVO getCategoria(int idCategoria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<categoriasVO> getAllCategorias() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deleteCategoria(int idCategoria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<categoriasVO> getCategoriaByTipo(int tipoCategoria) throws Exception {
        String sql = "SELECT id_categoria, descripcion FROM categoria WHERE id_tipo_categoria = " + String.valueOf(tipoCategoria);             
        sqliteHelper sqlite = new sqliteHelper();
        ArrayList<categoriasVO> result = new ArrayList<>();
        categoriasVO categoria = new categoriasVO();
        try (Connection conn = sqlite.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {                                  
                categoria = new categoriasVO(rs.getInt("id_categoria"), rs.getString("descripcion"), tipoCategoria);               
                result.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("ERROR BD - " + e.getMessage());
        } 
        return result;    
    }
    
}
