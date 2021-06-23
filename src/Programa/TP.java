/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;

/**
 *
 * @author fer_c
 */
public class TP extends Tabla{

    private String asign;

    public TP(int no, int tam, int loc, String estado, String asign ) {
        super(no, tam, loc, estado);
        this.asign = asign;
    }

    public String getAsign() {
        return asign;
    }

    public void setAsign(String asign) {
        this.asign = asign;
    }

    @Override
    public String toString() {
        return super.toString()+", asign=" + asign ;
    }
    
    

    

    
}
