/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package billetera;

import Presentacion.Model.billeteraModel;

/**
 *
 * @author Estudiantes
 */
public class Launcher {

    private billeteraModel miApp;
    /**
     * @param args the command line arguments
     */
    
    public Launcher() {
        miApp = new billeteraModel();
        miApp.iniciar();
    }
    
    public static void main(String[] args) {
        new Launcher();
    }
    
}
