/*
 *  Simulación sencilla de una carrera de coches
 */
package ejeArrayList.eje01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CarreradeCoches {
	
	public static void main(String[] args) {
			
		Random valor = new Random();  
		final int META = 1500; 		
		var parrilla = new ArrayList<Coche>(); 
	    
		
		parrilla.add( new Coche ("Ferrari",300));
		parrilla.add( new Coche ("600",100));
		parrilla.add( new Coche ("BMW",220));
		parrilla.add( new Coche ("Seat",150));
		parrilla.add( new Coche ("La Cabra",10));
		
	
		Coche c1 = parrilla.get(0);
		Coche c2 = parrilla.get(1);
		c1.acelera(10);
		c2.frena(20);
		c1.parar();
		c2.recorre();
	
		
		
		for ( Coche c: parrilla) {
			c.arrancar();
		}
		
		
		
		
		do {
			for (Coche c : parrilla) {
				c.acelera(valor.nextInt(40));
				c.recorre();
				c.frena(valor.nextInt(10));
				System.out.println(c.info());
			}
			System.out.println("----------------------------------------");
				
		} while ( ! alcanzarMeta ( parrilla, META) );

		
	    Collections.sort( parrilla, (a, b) -> (b.getKilometros() - a.getKilometros()));
		
		
		for(int i=0; i< parrilla.size(); i++){
			System.out.println((i+1)+"º Clasificado "+ parrilla.get(i).info());
		}
		
	
	}

	
	
	static public boolean alcanzarMeta ( ArrayList<Coche> parrilla, int distancia){
		boolean fin = false;
		for (int t = 0; t < parrilla.size(); t++) {
		     if ( parrilla.get(t).getKilometros() >= distancia ){
		    	 fin = true; 
		    	 break;
		     }
		}
		return fin;
	}
	
	
}
	

