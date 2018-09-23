/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.VO;

/**
 *
 * @author luisguerrero
 */
public class resumenCuentasVO {
    
    private int tipoMovimiento;
    private String desMovimiento;
    private Double saldoMovimiento;

    public resumenCuentasVO() {
    }

    public resumenCuentasVO(int tipoMovimiento, String desMovimiento, Double saldoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
        this.desMovimiento = desMovimiento;
        this.saldoMovimiento = saldoMovimiento;
    }

    
    
    
    public int getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(int tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getDesMovimiento() {
        return desMovimiento;
    }

    public void setDesMovimiento(String desMovimiento) {
        this.desMovimiento = desMovimiento;
    }

    public Double getSaldoMovimiento() {
        return saldoMovimiento;
    }

    public void setSaldoMovimiento(Double saldoMovimiento) {
        this.saldoMovimiento = saldoMovimiento;
    }
    
    
    
}
