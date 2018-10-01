/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.VO;

/**
 *
 * @author Administrador
 */
public class reporteVO {
    private String leyenda;
    
    private Double saldoLeyenda;
    
    public reporteVO() {
        
    }

    public reporteVO(String leyenda, Double saldoLeyenda) {        
        this.leyenda = leyenda;
        this.saldoLeyenda = saldoLeyenda;
    }  

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public Double getSaldoLeyenda() {
        return saldoLeyenda;
    }

    public void setSaldoLeyenda(Double saldoLeyenda) {
        this.saldoLeyenda = saldoLeyenda;
    }
    
}
