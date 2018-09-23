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
public class cuentasVO {
    
    private int idCuenta;
    private String nombreCuenta;
    private personasVO persona;
    private double saldo;


    public cuentasVO(){
    
    }
    
    public cuentasVO (int idCuenta,String nombreCuenta,personasVO persona,double saldo)
    {
        this.idCuenta=idCuenta;
        this.nombreCuenta=nombreCuenta;
        this.persona=persona;
        this.saldo=saldo;
    }

    public cuentasVO(int idCuenta, String nombreCuenta, double saldo) {
        this.idCuenta = idCuenta;
        this.nombreCuenta = nombreCuenta;
        this.saldo = saldo;
    }
    
    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public void setNombreCuenta(String nombreCuenta) {
        this.nombreCuenta = nombreCuenta;
    }

    public personasVO getPersona() {
        return persona;
    }

    public void setPersona(personasVO persona) {
        this.persona = persona;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    
}
