/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Model;

import Logica.bussinesUtility;
import Presentacion.View.principal;

/**
 *
 * @author Estudiantes
 */
public class billeteraModel {
    
    private bussinesUtility sistema;
    
    private principal ventanaPrincipal;

    public bussinesUtility getSistema() {
        if(sistema == null){
            sistema = new bussinesUtility();
        }
        return sistema;
    }

    public principal getVentanaPrincipal() {
        if(ventanaPrincipal == null){
            ventanaPrincipal = new principal(this);
        }
        return ventanaPrincipal;
    }

     public void iniciar() {
        getVentanaPrincipal().setSize(400, 400);
        getVentanaPrincipal().setVisible(true);
    }
    
}
