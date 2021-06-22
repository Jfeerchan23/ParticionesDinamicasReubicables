
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrimerAjuste {
    static ArrayList<Evento> Eventos = new ArrayList();
    static ArrayList<Evento> Espera = new ArrayList();
    static ArrayList<TAL> Libre=new ArrayList();
    static ArrayList<TP> Particiones = new ArrayList();
   static int nPar=1;
   static int nLib=1;
    
    private static void inicializarEventos(){
        Eventos.add(new Evento("Llega","P1",78));
        Eventos.add(new Evento("Llega","P2",82));
        Eventos.add(new Evento("Llega","P3",60));
        Eventos.add(new Evento("Llega","P4",94));
        Eventos.add(new Evento("Llega","P5",74));
        Eventos.add(new Evento("Termina","P3",0));
        Eventos.add(new Evento("Llega","P6",96));
        Eventos.add(new Evento("Termina","P2",0));
        Eventos.add(new Evento("Llega","P7",74));
        Eventos.add(new Evento("Termina","P5",0));
        Eventos.add(new Evento("Termina","P7",0)); 
        Eventos.add(new Evento("Llega","P8",44));
        Eventos.add(new Evento("Llega","P9",28));
    }
    
    public static void dinamicaPrimerAjuste(int ram, int so){
        inicializarEventos();
        //RAM 1024 MB
        //SO 128 MB
        Libre.add(new TAL(nLib,ram-so,so+1,"D",1));
        nLib++;
   
        for(int i=0; i<Eventos.size();i++){
          
           if("Llega".equals(Eventos.get(i).getTipo())){
           //    System.out.println("\n\nEvento "+Eventos.get(i).getProceso()+" llega");
               llegada(Eventos.get(i));
           }else{
             //   System.out.println("Evento termina\n");
               finalizado(Eventos.get(i));
           }
            
        }
       
        imprimirArray(Particiones);
        System.out.println("\n------------------\n");
        imprimirArray(Libre);
        
    }
    
    private static void llegada(Evento evento){
        boolean x=false;
        for(int i=0;i<Libre.size();i++){
            if(evento.getTam()<=Libre.get(i).getTam()){
                Particiones.add(new TP(nPar,evento.getTam(),Libre.get(i).getLoc(),"A",evento.getProceso()));
            //    System.out.println("Hay espacio para el proceso\n");
                Libre.get(i).setTam(Libre.get(i).getTam()-evento.getTam());
                Libre.get(i).setLoc(Libre.get(i).getLoc()+evento.getTam());
                //System.out.println(Libre.get(i).toString());
                nPar++;
                x=true;
                break;
            }
        }
        
        //En caso de que no haya espacio, se pone en una lista de espera
        if(x==false){
           Espera.add(evento);
        }
        
    }
    private static void finalizado(Evento evento){
        for(int i=0; i<Particiones.size();i++){
            if(evento.getProceso().equals(Particiones.get(i).getAsign())){
                Particiones.get(i).setEstado("V");
                Libre.add(new TAL(nLib,Particiones.get(i).getTam(),Particiones.get(i).getLoc(),"D",nLib));
                ordenacion();
             
                
                nLib++;
            }
        } 
    }
    
    private static void imprimirArray(ArrayList array){
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i).toString());
        }
    }
    
    private static void ordenacion(){
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
           
                
           for(int i=0;i<Libre.size();i++){
               Libre.get(i).setOrden(i+1);
           }
           
           
    }
    
    
}
