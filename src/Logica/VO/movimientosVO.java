/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.VO;

import java.util.Date;

/**
 *
 * @author Estudiantes
 */
public class movimientosVO {
    
    private int idMovimiento;
    private Date fecha;
    private double valor;
    private String detalle;
    private cuentasVO cuentas;
    private categoriasVO categoria;
    private int tipoMovimiento;

    public movimientosVO(int idMovimiento, Date fecha, double valor, String detalle, cuentasVO cuentas, categoriasVO categoria, int tipoMovimiento) {
        this.idMovimiento = idMovimiento;
        this.fecha = fecha;
        this.valor = valor;
        this.detalle = detalle;
        this.cuentas = cuentas;
        this.categoria = categoria;
        this.tipoMovimiento = tipoMovimiento;
    }

    public movimientosVO() {
    }

    public int getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(int idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public cuentasVO getCuentas() {
        return cuentas;
    }

    public void setCuentas(cuentasVO cuentas) {
        this.cuentas = cuentas;
    }

    public categoriasVO getCategoria() {
        return categoria;
    }

    public void setCategoria(categoriasVO categoria) {
        this.categoria = categoria;
    }

    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
    
}
