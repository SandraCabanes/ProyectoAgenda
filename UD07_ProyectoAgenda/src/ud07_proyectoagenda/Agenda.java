/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ud07_proyectoagenda;

/**
 *
 * @author mati
 */
public class Agenda {
    private int anyo;
    private Pagina[] paginas;
    public Pagina abierta;
    
    Agenda (int anyo){
        this.anyo=anyo;
        if(anyo%4==0){
            inicializa(false);
        }
    }

    private void inicializa(boolean b) {
        this.paginas=new Pagina[b ? 366 : 365];
        int dia=0;
        for (int i = 0; i <= 31 ; i++) {
            paginas[dia++]=new Pagina(i, 1);            
        }
        for (int i = 0; i <= (b ? 29:28) ; i++) {
            paginas[dia++]=new Pagina(i, 2);            
        }
        for (int i = 0; i <= 31 ; i++) {
            paginas[dia++]=new Pagina(i, 3);            
        }
        for (int i = 0; i <= 30 ; i++) {
            paginas[dia++]=new Pagina(i, 4);            
        }
        for (int i = 0; i <= 31 ; i++) {
            paginas[dia++]=new Pagina(i, 5);            
        }
    }
    
    public Pagina buscarPagina(int dia, int mes){
        Pagina busqueda=null, temp;
        int cont=0;
        boolean encontrado=false;
        
        while(cont<paginas.length&&encontrado==false){
            temp=paginas[cont++];
            if(temp.getDia()==dia && temp.getMes()==mes){
                busqueda=temp;
                encontrado=true;
            }
        }
        return busqueda;
    }
   
}
