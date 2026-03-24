
package ejeArrayList.eje04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.TreeSet;

public class Eje04 {

	public static void main(String[] args) {
		  Random rd = new Random();	
	        
		  
		    ArrayList<Integer> lista = new ArrayList<Integer>();
		    
		    // Relleno con valores entre 0 y 100
		    for (int i = 1; i <=20; i++) {
		      lista.add(rd.nextInt(50));
		    }
		    
		    Collections.sort(lista);
		  
		    System.out.println(lista);
		    
		    TreeSet <Integer> conjunto = new TreeSet<Integer>(lista);
		    
		    System.out.println(conjunto);
		
	}

}
