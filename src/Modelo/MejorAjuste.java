package Modelo;

import java.util.Arrays;

public class MejorAjuste {

    public static void mejorAdjuste(int[] tamBloque, int[] tamProceso) {
        int[] asignacion = new int[tamProceso.length];

        Arrays.fill(asignacion, -1);

        for (int i = 0; i < tamProceso.length; i++) {
            int mejorIdx = -1;
            for (int j = 0; j < tamBloque.length; j++) {
                if (tamBloque[j] >= tamProceso[i]) {
                    if (mejorIdx == -1)
                        mejorIdx = j;
                    else if (tamBloque[mejorIdx] > tamBloque[j])
                        mejorIdx = j;
                }
            }

            if (mejorIdx != -1) {
                asignacion[i] = mejorIdx;

                tamBloque[mejorIdx] -= tamProceso[i];
            }
        }

        System.out.println("\nNo. de proceso\tTamaño proceso\tNo. de bloque");
        for (int i = 0; i < tamProceso.length; i++) {
            System.out.print((i + 1) + "\t\t" + tamProceso[i] + "\t\t");
            if (asignacion[i] != -1)
                System.out.print(asignacion[i] + 1);
            else
                System.out.print("No asignado");
        }
    }

}
