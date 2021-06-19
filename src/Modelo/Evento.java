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
public class Evento {
    
    private String nom;
    private String proceso;
    private int tam;

    public Evento(String nom, String proceso, int tam) {
        this.nom = nom;
        this.proceso = proceso;
        this.tam = tam;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        return "Evento{" + "nom=" + nom + ", proceso=" + proceso + ", tam=" + tam + '}';
    }
    
    
    
    
}
