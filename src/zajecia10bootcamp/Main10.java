package zajecia10bootcamp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class MojWyjatek extends Exception{
	
}

public class Main10 {
	public static void main(String[] args) {
		
		ArrayList<Character[]> arrayWprowadzonyWyraz = new ArrayList<Character[]>();
		List<Character[]> wyrazDoPorownania = new ArrayList<Character[]>();
		HashMap<String,ArrayList<String>> mapa = new HashMap<String, ArrayList<String>>();
		Set<String> keys = mapa.keySet();
		String wyraz = "";
		String wyrazSort;
		Scanner scanner = new Scanner(System.in);
    	System.out.println("Wprowadz dane: ");
    	boolean b = true;
        do{
        	while(b) {
        		wyraz = scanner.nextLine();
        		b = false;
        		try {
        			if(!(wyraz.charAt(0) <= 'Z' && wyraz.charAt(0) >= 'A'))
        				throw new MojWyjatek();
        		}catch(MojWyjatek mw) {
        			System.out.println("Podaj jeszcze raz poprawne slowo z duzej litery");
        			b = true;
        		}
        	}
        	b = true;
        	if(mapa.isEmpty())
        		mapa.put(wyraz, new ArrayList<String>(Arrays.asList(wyraz)));
        	else {
	        	keys = mapa.keySet();
	        	for(String s : keys) {
	        		if(s.equals(wyraz)) 
	        			break;
	        	}
	        	char[] tab =  wyraz.toCharArray();
	        	Arrays.sort(tab);
	        	StringBuilder nowyWyraz = new StringBuilder();
	        	for(int i = 0; i < tab.length; i++) {
	        		nowyWyraz.append(tab[i]);
	        	}
	        	System.out.println("Nowy wyraz to: " + nowyWyraz);
	        	wyrazSort = nowyWyraz.toString();
	        			
	        	for(String s : keys) {								// TU SYPIE CONCURRENT MODIFICATION
	        		char[] tab2 = s.toCharArray();
	        		Arrays.parallelSort(tab2);
	        		StringBuilder odczytKlucza = new StringBuilder();
		        	for(int j = 0; j < tab2.length; j++) {			// TU SYPIE OUT OF INDEX
		        		odczytKlucza.append(tab[j]);
		        	}
	        		if(s.equals(wyrazSort)) {
	        			mapa.get(s).add(wyraz);
	//        		System.out.println(s + " " + mapa.get(s));
	        		}
	        		else
	        			mapa.put(wyraz, new ArrayList<String>(Arrays.asList(wyraz)));
	        	}
        	}
	        for(String s : keys)
	        	System.out.println("Klucz: " + s + " a jego wartosci : " + mapa.get(s));
        }while(!(wyraz.equals("Koniec")));
        scanner.close();
        
	}
}
