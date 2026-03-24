package ejeHashMap.eje01;

import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;

public class Biblioteca_HashMap
{
   public static void main ( String argv[]){
       
       HashMap <String,Libro> disponibles = new HashMap <String,Libro> ();
       HashMap <String,Libro> prestados   = new HashMap <String,Libro> ();
       
       Scanner sc = new Scanner(System.in);
       
       Libro nuevo = new Libro(19,"El Quijote"," Cervantes", Genero.NOVELA, 2012);
       
       disponibles.put(nuevo.titulo, nuevo);
       disponibles.put("El Buscón", new Libro(20,"El Buscón","Quevedo",Genero.NOVELA,1997));
       disponibles.put("Romeo y Julieta",new Libro(21,"Romeo y Julieta","Shakespeare ",Genero.TEATRO,1997));
       disponibles.put("Mio Cid",new Libro(22,"Mio Cid","Anónimo",Genero.POESIA,1989));
   
       System.out.println("Libros disponibles:");
       verCatalogo(disponibles);
       
       prestados.put("Harry Potter I", new Libro(30,"Harry Potter I", "J. K. Rowling", Genero.NOVELA,1998));
       prestados.put("Guerra y Paz", new Libro(34,"Guerra y Paz","León Tolstói",Genero.NOVELA,1975));
       prestados.put("El Decamerón" ,new Libro(19,"El Decamerón","Giovanni Boccaccio",Genero.CUENTOS,1992));
      
       System.out.println("Libros prestados:");
       
       verCatalogo(prestados);
      
       System.out.println(" ¿Que libro desea?:");
       String titulo = sc.nextLine();
       int resu = prestarLibro(titulo,prestados,disponibles);
       if ( resu == 0) System.out.println("El libro no está en el catalogo");
          else if ( resu == -1) System.out.println("El libro está prestado");
            else System.out.println("Su préstamo ha sido anotado");
       
       System.out.println("Libros disponibles:");
       verCatalogoOrdenado(disponibles);
       
       System.out.println("Libros prestados:");
       verCatalogoOrdenado(prestados);
    }
   
    private static void verCatalogo ( HashMap <String,Libro> mlibros){
        int n = 1;
        for ( Libro l: mlibros.values()) {
            System.out.println(n+"º :"+ l);
            n++;
        }
    }
    
    private static void verCatalogoOrdenado ( HashMap <String,Libro> mlibros){
      var mlibrosaux =  new TreeMap <String,Libro>(mlibros);
      int n= 1;
      for ( Libro l: mlibrosaux.values()) {
        System.out.println(n+"º :"+ l);
          n++;
      }
    }
    
   public static int prestarLibro ( String titulo, HashMap<String,Libro> mprestados, HashMap <String,Libro> mdisponibles){
   
      Libro libroprestado     = mprestados.get(titulo);
      Libro librodisponible   = mdisponibles.get(titulo);
      
      if ( libroprestado == null && librodisponible == null) return 0;
      if ( libroprestado !=  null)  return -1;
      
      mdisponibles.remove(titulo);
      mprestados.put(titulo,librodisponible);
      return 1;
    }
}