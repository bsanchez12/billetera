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
public class categoriasVO {
    
    private int idCategoria;
    private String desCategoria;
    private int tipoCategoria;

    public categoriasVO(){
    }
    
    public categoriasVO(int idCategoria,String desCategoria,int tipoCategoria){
        this.idCategoria=idCategoria;
        this.desCategoria=desCategoria;
        this.tipoCategoria=tipoCategoria;
    }
    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDesCategoria() {
        return desCategoria;
    }

    public void setDesCategoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }

    public int getTipoCategoria() {
        return tipoCategoria;
    }

    public void setTipoCategoria(int tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }
    
    
}
