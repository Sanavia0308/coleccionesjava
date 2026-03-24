package ejeArrayList.eje03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Eje03_ArrayList
{
    public static void main(String[] args) {
    	
    Random rd = new Random();	
        
    int nelementos = (int)(Math.random() * 11 + 20);
    nelementos = rd.nextInt(10, 21);

    ArrayList<Integer> lista = new ArrayList<Integer>();
    
    
    for (int i = 0; i < nelementos; i++) {
      lista.add(rd.nextInt(101));
    }
    
    System.out.println(" Contenido :"+lista);
   
    int suma = 0;
    for(int valor : lista) {
      suma += valor;
    }
    System.out.println("La suma total es : " + suma);
    
   
    
    
    
   
   
    Iterator  <Integer>  it= lista.iterator();
    while (it.hasNext()){
        if (it.next() % 2 == 0){
            it.remove();
        }
    }
        
    // Otra forma mas rápida
    lista.removeIf( valor -> valor % 2 == 0);
        
    System.out.println("Lista generada sin pares: " + lista);
    
    // CAMBIO LOS DIVISIBLES POR 3
    /*
    for (int i = 0; i < lista.size(); i++){
        if ( lista.get(i) % 3 == 0){
            lista.set(i, 0);
        }
    }    
    */
    // Otra forma más rapida aun 
    lista.replaceAll( x -> (x % 3 == 0) ? 0: x);
    System.out.println("Lista procesada : " + lista);
    
    
    /// INSERTAR 555 si hay divisible entre 5 
    
     for (int i = 0; i < lista.size(); i++){
         int valor = lista.get(i);
        if ( valor != 0 && valor % 5 == 0){
            lista.add(i, 555);
            i++; 
        }
    }  
    
    System.out.println("Lista generada: " + lista);
   
   }
}