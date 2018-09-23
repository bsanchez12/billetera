/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.View;

import Presentacion.Controller.confCategoriasController;
import Presentacion.Model.billeteraModel;
import javax.swing.JList;

/**
 *
 * @author Briam
 */
public class confCategorias extends javax.swing.JFrame {

    private final billeteraModel modelo;
    
    private confCategoriasController control;
    
    /**
     * Creates new form confCategorias
     */
    public confCategorias(billeteraModel b) {
        modelo = b;
        initComponents();      
        capturarEventos();
    }
    
    public billeteraModel getModelo() {
        return modelo;
        
    }
    
    public confCategoriasController getControl() {
         if(control == null){
            control = new confCategoriasController(this);
        }
        return control;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConfiguracion = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstConfiguracion = new javax.swing.JList<>();
        btnAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblConfiguracion.setText("Configuración");

        lblDescripcion.setText("Selecciona un item:");

        lstConfiguracion.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "1-Categorías de Ingresos", "2-Categorías de Gastos", " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstConfiguracion.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstConfiguracion.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstConfiguracionValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstConfiguracion);

        btnAtras.setText("Atras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAtras)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblDescripcion)
                        .addComponent(lblConfiguracion)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblConfiguracion)
                .addGap(18, 18, 18)
                .addComponent(lblDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAtras)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstConfiguracionValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstConfiguracionValueChanged
        getControl().selectItem();
    }//GEN-LAST:event_lstConfiguracionValueChanged

    public JList<String> getLstConfiguracion() {
        return lstConfiguracion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtras;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblConfiguracion;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JList<String> lstConfiguracion;
    // End of variables declaration//GEN-END:variables

    private void capturarEventos() {
        btnAtras.addActionListener(getControl());
    }
       
}
