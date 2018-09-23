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
import Logica.VO.detalleCuentaVO;
import Logica.VO.movimientosVO;
import Logica.VO.personasVO;
import Logica.VO.resumenCuentasVO;
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
    public ArrayList<detalleCuentaVO> getMovimientoByIdCuenta(int idCuenta) throws Exception {
        System.out.println("datos");
        String sql="select c.descripcion,sum(m.valor)as valor from movimiento m  "+
                   "inner join categoria c on m.id_categoria=c.id_categoria " + 
                   "where id_cuenta = "+String.valueOf(idCuenta) +" group by c.descripcion";
        sqliteHelper sqlite = new sqliteHelper();
        ArrayList<detalleCuentaVO> detalleCuenta=new ArrayList();
        detalleCuentaVO cuentaVO=new detalleCuentaVO();
        
        try {
             Connection conn = sqlite.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql);
             
                       // loop through the result set
            while (rs.next()) {                                 
                       
                cuentaVO = new detalleCuentaVO(rs.getString("descripcion"), rs.getDouble("valor"));
               
                
                detalleCuenta.add(cuentaVO);
            }
            
            
        } catch (Exception e) {
            
             System.out.println("ERROR BD - " + e.getMessage());
        }
        
        return detalleCuenta;

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
                Date fecha = rs.getDate("fecha");                
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

    @Override
    public ArrayList<resumenCuentasVO> getResumenCuentas() throws Exception {
        
        ArrayList<resumenCuentasVO> resumenCuentas=new ArrayList();
        String consulta="select m.id_tipo_movimiento,tm.detalle, sum(m.valor)as Ingresos " +
                        "from movimiento m inner join tipomovimiento tm on m.id_tipo_movimiento=tm.id_tipo_movimiento " +
                        "group by m.id_tipo_movimiento";
        sqliteHelper sqlite = new sqliteHelper();
        resumenCuentasVO resultVO=new resumenCuentasVO(); 
        
        try {
            
             Connection conn = sqlite.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(consulta);
             
             while (rs.next()) {  
              
                resultVO=new resumenCuentasVO(rs.getInt("id_tipo_movimiento"),rs.getString("detalle"),rs.getDouble("Ingresos"));
                resumenCuentas.add(resultVO);

              }
        } catch (SQLException e) {
             System.out.println("ERROR BD - " + e.getMessage());    
                
        }
        
        return resumenCuentas;
        
    }

    @Override
    public movimientosVO getMovimientoById(int idMovimiento) throws Exception {
         String sql = "SELECT m.id_movimiento, m.valor, m.fecha, m.detalle, cu.id_cuenta, cu.nombre_cuenta ," +
               " c.id_categoria ,c.descripcion, m.id_tipo_movimiento FROM movimiento m inner join " +
               "categoria c on m.id_categoria = c.id_categoria " +
               "inner join cuenta cu on m.id_cuenta = cu.id_cuenta where m.id_movimiento = " + String.valueOf(idMovimiento);
        sqliteHelper sqlite = new sqliteHelper();
        movimientosVO result = new movimientosVO();        
        cuentasVO cuenta = new cuentasVO();
        categoriasVO categoria = new categoriasVO();
        personasVO persona = new personasVO(1, "John Smith");        
        try (Connection conn = sqlite.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {   
                System.out.println(rs.getDate("fecha"));
                Date fecha = rs.getDate("fecha");                
                cuenta = new cuentasVO(rs.getInt("id_cuenta"), rs.getString("nombre_cuenta"), persona, 0);
                categoria = new categoriasVO(rs.getInt("id_categoria"), rs.getString("descripcion"), rs.getInt("id_tipo_movimiento"));
                result = new movimientosVO(rs.getInt("id_movimiento"), fecha, rs.getDouble("valor")
                           , rs.getString("detalle"), cuenta, categoria, rs.getInt("id_tipo_movimiento"));                                
            }
        } catch (SQLException e) {
            System.out.println("ERROR BD - " + e.getMessage());
        } 
        return result; 
    }
    
}
