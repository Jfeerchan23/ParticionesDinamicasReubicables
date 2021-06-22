/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fer_c
 */
public class TAL extends Tabla{
    private int orden;

    public TAL(int no, int tam, int loc, String estado,int orden ) {
        super(no, tam, loc, estado);
        this.orden = orden;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    
    
    
    
    
    @Override
    public String toString() {
        return super.toString() + ", orden=" + orden ;
    }

   

  
    
    
    
}
