
package Modelo;

import java.util.ArrayList;

public class PrimerAjuste {
    ArrayList<Evento> Eventos = new ArrayList();
    ArrayList<Evento> Espera = new ArrayList();
    
    
    
    
    private void inicializarEventos(){
        Eventos.add(new Evento("LLega","P1",78));
        Eventos.add(new Evento("LLega","P2",82));
        Eventos.add(new Evento("LLega","P3",60));
        Eventos.add(new Evento("LLega","P4",94));
        Eventos.add(new Evento("LLega","P5",74));
        Eventos.add(new Evento("Termina","P3",0));
        Eventos.add(new Evento("LLega","P6",96));
        Eventos.add(new Evento("Termina","P2",0));
        Eventos.add(new Evento("LLega","P7",74));
        Eventos.add(new Evento("Termina","P5",0));
        Eventos.add(new Evento("Termina","P7",0)); 
        Eventos.add(new Evento("LLega","P8",44));
        Eventos.add(new Evento("LLega","P9",28));
    }
    
    public void dinamicaPrimerAjuste(){
        
        
        
    }
    
    
    
}
