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
public class Tabla {
    private int no;
    private int tam;
    private int loc;
    private String estado;

    public Tabla(int no, int tam, int loc, String estado) {
        this.no = no;
        this.tam = tam;
        this.loc = loc;
        this.estado = estado;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getLoc() {
        return loc;
    }

    public void setLoc(int loc) {
        this.loc = loc;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }



    @Override
    public String toString() {
        return "no=" + no + ", tam=" + tam + ", loc=" + loc + ", estado=" + estado ;
    }
    
}
