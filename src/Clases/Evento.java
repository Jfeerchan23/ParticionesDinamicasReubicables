/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author fer_c
 */
public class Evento {
    
    private String tipo;
    private String proceso;
    private int tam;

    public Evento(String tipo, String proceso, int tam) {
        this.tipo = tipo;
        this.proceso = proceso;
        this.tam = tam;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    @Override
    public String toString() {
        return "Evento{" + "tipo=" + tipo + ", proceso=" + proceso + ", tam=" + tam + '}';
    }

   
    
    
    
    
}
