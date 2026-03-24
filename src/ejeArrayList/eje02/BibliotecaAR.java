
 package ejeArrayList.eje02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BibliotecaAR
{
   public static void main ( String argv[]){
       
       List <Libro> disponibles = new ArrayList ();
       List <Libro> prestados =   new ArrayList ();
       Scanner sc = new Scanner(System.in);
       
       Libro nuevo = new Libro(19,"El Quijote"," Cervantes", Genero.NOVELA, 2012);
       
       disponibles.add(nuevo);
       disponibles.add(new Libro(20,"El Buscón","Quevedo",Genero.NOVELA,1997));
       disponibles.add(new Libro(21,"Romeo y Julieta","Shakespeare ",Genero.TEATRO,1997));
       disponibles.add(new Libro(22,"Mio Cid","Anónimo",Genero.POESIA,1989));
   
       prestados.add( new Libro(30,"Harry Potter I", "J. K. Rowling", Genero.NOVELA,1998));
       prestados.add( new Libro(34,"Guerra y Paz","León Tolstói",Genero.NOVELA,1975));
       prestados.add( new Libro(39,"El Decamerón","Giovanni Boccaccio",Genero.CUENTOS,1992));
      
       System.out.println(" Libros Disponibles:"+ disponibles);
       System.out.println(" Libros Prestados:" + prestados);
       
       System.out.println(" Prestamo de libros:");
       System.out.println(" ¿Que libro desea?:");
       String titulo = sc.nextLine();
       int resu = prestarLibro(titulo,prestados,disponibles);
       
       switch ( resu ){
          case  0:  System.out.println("El libro no está en el catalogo");break;
          case -1:  System.out.println("El libro está prestado"); break;
          case  1:  System.out.println("Su prestamo ha sido anotado"); break;
        }
       
       System.out.println(" Libros Disponibles:"+ disponibles);
       System.out.println(" Libros Prestados:" + prestados);
    }
   
   public static int prestarLibro ( String titulo, List<Libro> prestados, List<Libro> disponibles){
   
      Libro libroPrestado    = buscarId(prestados,titulo);
      Libro libroDisponible  = buscarId(disponibles,titulo);
      
      if ( libroPrestado == null && libroDisponible == null) return 0;
      if ( libroPrestado !=  null)  return -1;
      
      disponibles.remove(libroDisponible);
      prestados.add(libroDisponible);
      return 1;
    }

    private static Libro buscarId(List<Libro> listaLibros, String titulo) {
        Libro resu = null;
        for ( Libro l : listaLibros) {
            if (l.titulo.equals(titulo)) {
                resu = l;
                break;
            }
        }
        return resu;
    }
}