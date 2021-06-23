
package Programa;

import java.util.Collections;
import java.util.Comparator;



public class MejorAjuste extends Ajuste {
     private static void ordenarTAL(){
           Collections.sort(Libre, new Comparator<TAL>() {

            public int compare(TAL p1, TAL p2) {
                return new Integer(p1.getLoc()).compareTo(new Integer(p2.getLoc()));
            }
        });
           
           for(int i=0;i<Libre.size()-1;i++){
               if((Libre.get(i).getTam()+Libre.get(i).getLoc())==Libre.get(i+1).getLoc()){
                   Libre.get(i+1).setTam(Libre.get(i).getTam()+Libre.get(i+1).getTam());
                   Libre.get(i+1).setLoc(Libre.get(i).getLoc());
                   Libre.get(i+1).setNo(Libre.get(i).getNo());
                   Libre.remove(i);
               }
           }
           
            Collections.sort(Libre, new Comparator<TAL>() {

            public int compare(TAL p1, TAL p2) {
                return new Integer(p1.getTam()).compareTo(new Integer(p2.getTam()));
            }
        });
           
           
           for(int i=0;i<Libre.size();i++){
               if(Libre.get(i).getTam()==0){
                   Libre.remove(i);
               }
           }
                
           for(int i=0;i<Libre.size();i++){
               Libre.get(i).setOrden(i+1);
           }
           
           
    }
    
}
