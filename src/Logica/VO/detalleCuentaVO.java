/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.VO;

/**
 *
 * @author Estudiantes
 */
public class detalleCuentaVO {
    
    private String detalle;
    private Double valor;
    

    public detalleCuentaVO() {
    }

    public detalleCuentaVO(String detalle, Double valor) {
        this.detalle = detalle;
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
