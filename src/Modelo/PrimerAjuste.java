
package Modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrimerAjuste {
    static ArrayList<Evento> Eventos = new ArrayList();
    static ArrayList<Evento> Espera = new ArrayList();
    static ArrayList<TAL> Libre=new ArrayList();
    static ArrayList<TP> Particiones = new ArrayList();
    static ArrayList<TP> Finalizados = new ArrayList();
   static int nPar=1;
   static int nLib=1;
   static int nSO=0;
    
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
        Eventos.add(new Evento("Termina","P1",0)); 
        Eventos.add(new Evento("Llega","P8",44));
        Eventos.add(new Evento("Llega","P9",28));
    }
    
    public static void dinamicaPrimerAjuste(int ram, int so){
        inicializarEventos();
        //RAM 1024 MB
        //SO 128 MB
        Libre.add(new TAL(nLib,ram-so,so,"D",1));
        nLib++;
        nSO=so;
        for(int i=0; i<Eventos.size();i++){
          
           if("Llega".equals(Eventos.get(i).getTipo())){
               llegada(Eventos.get(i));
           }else{
               if("Termina".equals(Eventos.get(i).getTipo()))
               finalizado(Eventos.get(i));
           }
          
            
        }
        System.out.println("\nPROCESOS ACTIVOS\n");
        imprimirArray(Particiones);
         System.out.println("\nPROCESOS FINALIZADOS\n");
        imprimirArray(Finalizados);
        System.out.println("\nPROCESOS EN ESPERA\n");
         imprimirArray(Espera);
        System.out.println("\nAREAS LIBRES\n");
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
                ordenarTP();
                x=true;
                break;
            }
        }
        
        //En caso de que no haya espacio, se hace la reubicación
        if(x==false){
           reubicacion(evento);
        }
        
    }
    private static void finalizado(Evento evento){
        for(int i=0; i<Particiones.size();i++){
            if(evento.getProceso().equals(Particiones.get(i).getAsign())){
                Particiones.get(i).setEstado("V");
                Libre.add(new TAL(nLib,Particiones.get(i).getTam(),Particiones.get(i).getLoc(),"D",nLib));
                ordenarTAL();
                Finalizados.add(Particiones.get(i));
                Particiones.remove(i);
                nLib++;
            }
        } 
       
        if(!Espera.isEmpty()){
        procesosEspera();
        }
       
        
    }
    
    private static void imprimirArray(ArrayList array){
        for(int i=0;i<array.size();i++){
            System.out.println(array.get(i).toString());
        }
    }
    
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
           
           for(int i=0;i<Libre.size();i++){
               if(Libre.get(i).getTam()==0){
                   Libre.remove(i);
               }
           }
                
           for(int i=0;i<Libre.size();i++){
               Libre.get(i).setOrden(i+1);
           }
           
           
    }
    
  
    private static void reubicacion(Evento evento){
           int cantidad=0;
        
           for(int i=0;i<Libre.size();i++){
               cantidad=cantidad+Libre.get(i).getTam();
           }
               
               
         if(cantidad>=evento.getTam()){
             
        while(Libre.get(0).getTam()<evento.getTam() && Libre.size()!=1){
            int i=0;
            
            try{
            Libre.get(i+1).setTam(Libre.get(i).getTam()+Libre.get(i+1).getTam());
            Libre.get(i+1).setLoc(Libre.get(i+1).getLoc()-Libre.get(i).getTam());
            Libre.get(i+1).setNo(Libre.get(i).getNo());
            Libre.remove(i);
            }catch(Exception e){
                break;
            }
        
        i++;
        }
           recorrerProcesos();
           llegada(evento);
         }else{
              
             
               Espera.add(evento);
         }
  
        
    }
    
    
    
    private static void ordenarTP(){
          Collections.sort(Particiones, new Comparator<TP>() {

            public int compare(TP p1, TP p2) {
                return new Integer(p1.getLoc()).compareTo(new Integer(p2.getLoc()));
            }
        });
    }
    
    private static void procesosEspera(){
        int cantidad=0;
        boolean x=false;
      for(int i=0;i<Libre.size();i++){
          cantidad=cantidad+Libre.get(i).getTam();
      }
      
      for(int i=0;i<Espera.size();i++){
          
          for(int j=0;j<Libre.size();j++){
         if(Espera.get(i).getTam()<=Libre.get(j).getTam()){
             
             llegada(Espera.get(i));
             Espera.remove(i);
             x=true;
             break;
         }
              
              
          }
          try{
          if(cantidad>Espera.get(i).getTam()&&x==false){
              reubicacion(Espera.get(i));
              Espera.remove(i);
          }}catch(Exception e){
              
          }
          
          
         
      }  
      
      
      
        
    }
    
    
    private static void recorrerProcesos(){
         Particiones.get(0).setLoc(nSO);
        for(int i=0;i<Particiones.size()-1;i++){
           Particiones.get(i+1).setLoc(Particiones.get(i).getLoc()+Particiones.get(i).getTam());
          if((Particiones.get(i+1).getLoc()+Particiones.get(i+1).getTam())==Libre.get(0).getLoc()){
              break;
          }
        }
        
      
    }
    
    
}
