/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos.DAOImpl;

import AccesoDatos.DAO.ImovimientosDAO;
import Helpers.sqliteHelper;
import Logica.VO.categoriasVO;
import Logica.VO.cuentasVO;
import Logica.VO.movimientosVO;
import Logica.VO.personasVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Estudiantes
 */
public class movimientoDAOImpl implements ImovimientosDAO{

    @Override
    public int insertMovimiento(movimientosVO movimiento) throws Exception {
        String sql = "INSERT INTO movimiento(fecha,valor,detalle,id_cuenta,id_categoria,id_tipo_movimiento) VALUES(?,?,?,?,?,?)";
        sqliteHelper sqlite = new sqliteHelper();
        int result = 0;
        cuentasVO cuenta = movimiento.getCuentas();
        categoriasVO categoria = movimiento.getCategoria(); 
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        java.sql.Date sqlDate = new java.sql.Date(movimiento.getFecha().getTime());
        System.out.println(sqlDate.toLocalDate());
        try (Connection conn = sqlite.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, sqlDate);
            pstmt.setDouble(2, movimiento.getValor());
            pstmt.setString(3, movimiento.getDetalle());
            pstmt.setInt(4, cuenta.getIdCuenta());
            pstmt.setInt(5, categoria.getIdCategoria());
            pstmt.setInt(6, movimiento.getTipoMovimiento());
            pstmt.executeUpdate();
            result = 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    @Override
    public movimientosVO getMovimientoByIdCuenta(int idCuenta) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<movimientosVO> getMovimientoByidTipoMov(int idtipoMoviento) throws Exception {
       String sql = "SELECT m.id_movimiento, m.valor, m.fecha, m.detalle, cu.id_cuenta, cu.nombre_cuenta ," +
               " c.id_categoria ,c.descripcion FROM movimiento m inner join " +
               "categoria c on m.id_categoria = c.id_categoria " +
               "inner join cuenta cu on m.id_cuenta = cu.id_cuenta where m.id_tipo_movimiento = " + String.valueOf(idtipoMoviento);
        sqliteHelper sqlite = new sqliteHelper();
        ArrayList<movimientosVO> result = new ArrayList();
        movimientosVO movement = new movimientosVO();
        cuentasVO cuenta = new cuentasVO();
        categoriasVO categoria = new categoriasVO();
        personasVO persona = new personasVO(1, "John Smith");
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        try (Connection conn = sqlite.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {  
                System.out.println(rs.getString("fecha"));                
                Date fecha = format.parse(rs.getString("fecha"));                
                cuenta = new cuentasVO(rs.getInt("id_cuenta"), rs.getString("nombre_cuenta"), persona, 0);
                categoria = new categoriasVO(rs.getInt("id_categoria"), rs.getString("descripcion"), idtipoMoviento);
                movement = new movimientosVO(rs.getInt("id_movimiento"), fecha, rs.getDouble("valor")
                           , rs.getString("detalle"), cuenta, categoria, idtipoMoviento);
                
                result.add(movement);
            }
        } catch (SQLException e) {
            System.out.println("ERROR BD - " + e.getMessage());
        } 
        return result;        
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
