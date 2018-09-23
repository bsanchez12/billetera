/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.View;

import Presentacion.Controller.reportesController;
import Presentacion.Model.billeteraModel;
import javax.swing.JList;

/**
 *
 * @author Briam
 */
public class reportes extends javax.swing.JFrame {

    private final billeteraModel modelo;
    
    private reportesController control;
    
    /**
     * Creates new form reportes
     */
    public reportes(billeteraModel b) {
        modelo = b;
        initComponents(); 
        capturarEventos();
    }
    
    public billeteraModel getModelo() {
        return modelo;
        
    }
    
    public reportesController getControl() {
         if(control == null){
            control = new reportesController(this);
        }
        return control;
    }

    public JList<String> getLstReporte() {
        return lstReporte;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbltiporeporte = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstReporte = new javax.swing.JList<>();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbltiporeporte.setText("Seleccione el tipo de reporte:");

        lstReporte.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1-Gestos Mensual", "2-Ingresos Mensual" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstReporte.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstReporte.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstReporteValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstReporte);

        btnAtras.setText("Atras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtras)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbltiporeporte)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lbltiporeporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtras)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstReporteValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstReporteValueChanged
        getControl().selectItem();
    }//GEN-LAST:event_lstReporteValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbltiporeporte;
    private javax.swing.JList<String> lstReporte;
    // End of variables declaration//GEN-END:variables

    private void capturarEventos() {
        btnAtras.addActionListener(getControl());
    }
}
