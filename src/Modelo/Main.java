/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.PrimerAjuste.*;

import java.util.Scanner;

import static Modelo.PrimerAjuste.dinamicaPrimerAjuste;

/**
 * @author fer_c
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here

        int memoria = 0, so = 0, modalidad = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIntroduzca el tamaño total de la memoria\n");
        // memoria=scanner.nextInt();
        System.out.println("\nIntroduzca el tamaño ocupado por el SO\n");
        //  so=scanner.nextInt();
        System.out.println("\nIntroduzca la modalidad: \n");
        System.out.println("\n1.-.Mejor ajuste\n2.-Peor ajuste\n3.-Primer ajuste\n");
        modalidad = scanner.nextInt();
        switch (modalidad) {
            case 1:
                //Implementar mejor ajuste  YAO
                int[] tamBloque = {100, 500, 200, 300, 600};
                int[] tamProceso = {212, 417, 112, 426};
                MejorAjuste.mejorAdjuste(tamBloque, tamProceso);
                break;
            case 2:
                //Implementar peor ajuste DANIEL
                break;
            case 3:
                //Implementar primer ajuste FERNANDO
                dinamicaPrimerAjuste(600, 128);


                break;
        }


    }


}
