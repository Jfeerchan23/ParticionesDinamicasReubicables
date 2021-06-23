/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Programa;



import java.util.Scanner;


/**
 * @author fer_c
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here

        int ram = 0, so = 0, modalidad = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nIntroduzca el tamaño total de la memoria\n");
        // memoria=scanner.nextInt();
        System.out.println("\nIntroduzca el tamaño ocupado por el SO\n");
        //  so=scanner.nextInt();
        System.out.println("\nIntroduzca la modalidad: \n");
        System.out.println("\n1.-.Mejor ajuste\n2.-Peor ajuste\n3.-Primer ajuste\n");
        modalidad = scanner.nextInt();
        switch (modalidad) {
            //Tomando como ejemplo estos valores:
            //RAM=1024 
            //SO=128 
            case 1:
               // MejorAjuste.particionesReubicables(ram, so);
               MejorAjuste.particionesReubicables(1024, 128);
                break;
            case 2:
                // PeorAjuste.particionesReubicables(ram, so);
              PeorAjuste.particionesReubicables(1024, 128);
                break;
            case 3:
               // PrimerAjuste.particionesReubicables(ram, so);
              PrimerAjuste.particionesReubicables(1024, 128);
                break;
                
               
        }
        System.out.println("\nPROGRAMA FINALIZADO\n");

    }


}
