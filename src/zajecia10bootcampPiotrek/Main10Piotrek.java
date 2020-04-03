package zajecia10bootcampPiotrek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main10Piotrek {

	public static void main(String[] args) {
//		ArrayList<String> lista = new ArrayList<String>();
//		String[] tabStr = {"Papuga", "Waran", "Bocian"};
//		ArrayList<String> listaStr = new ArrayList<String>(Arrays.asList(tabStr));
//		
//		String[] nowa = listaStr.toArray(new String[listaStr.size()]);
//		
//		System.out.println(listaStr);
//		
//		ArrayList<Object> l = new ArrayList<Object>();
//		l.add(4);
//		l.add("Komputer");
//		
//		ArrayList<Integer[]> listaTablic = new ArrayList<Integer[]>();
//		
//		HashMap<String, Integer> mapaZwierzakow = new HashMap<String, Integer>();
//		mapaZwierzakow.put("Szympans",5);
//		mapaZwierzakow.put("S³oñ", 2);
//		mapaZwierzakow.put("Kuoka", 9);

//		System.out.printf("Zwierze %s w liczebnosci: %d", "Szympans", mapaZwierzakow.get("Szympans"));
//		
//		System.out.println();
//		for(int i = 0; i < listaStr.size(); i++)
//			System.out.print(listaStr.get(i) + " ");
//		
//		System.out.println();
//		
//		Iterator<String> it = listaStr.iterator();
//		
//		while(it.hasNext())
//			System.out.print(it.next() + " ");

//		Set<String> keys = mapaZwierzakow.keySet();
//		
//		for(String s : keys)
//			System.out.println(s + " " + mapaZwierzakow.get(s));
//		
//		keys.forEach(System.out::println);
//		
//		System.out.println(keys);

		HashMap<String, ArrayList<String>> mapa = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> mapaSorted = new HashMap<String, ArrayList<String>>();
		List<String> preSort = new ArrayList<String>();
		List<String> sort = new ArrayList<String>();
		TreeMap<String, ArrayList<String>> mapaPosortowana = new TreeMap<String, ArrayList<String>>();
		
		String koniec;
		Scanner input = new Scanner(System.in);

		do {
			koniec = input.nextLine();
			
			if(!koniec.equalsIgnoreCase("koniec")) {
				Set<String> klucze = mapa.keySet();
				
				boolean wystapilo = false;
				for(String k : klucze) {
					if(czyZgodnaZKluczem(k, koniec)) {
						wystapilo = true;
						mapa.get(k).add(koniec);
					}
				}
				
				if(!wystapilo) {
					ArrayList<String> lista = new ArrayList<String>();
					lista.add(koniec);
					mapa.put(koniec, lista);
				}
			}
			
			pokazMapa(mapa);
		} while (!koniec.equalsIgnoreCase("koniec"));
		
		
		HashMapToTreeMap(mapa, mapaPosortowana);
		pokazMapa(mapaPosortowana);
	}
	
	public static boolean czyZgodnaZKluczem(String s1, String s2) {
		char[] tab1 = s1.toCharArray();
		char[] tab2 = s2.toCharArray();
		
		Arrays.sort(tab1);
		Arrays.sort(tab2);
		
		return new String(tab1).equals(new String(tab2));
	}
	
	public static void pokazMapa(Map<String, ArrayList<String>> mapa) {
		for(String k : mapa.keySet()) {			
			System.out.println(k + ": " + mapa.get(k));
		}
	}
	
	public static void HashMapToTreeMap(HashMap<String, ArrayList<String>> hashMapa, TreeMap<String, ArrayList<String>> treeMapa) {
		for(String k : hashMapa.keySet()) {
			ArrayList<String> lista = new ArrayList<String>();
			lista.addAll(hashMapa.get(k));
			treeMapa.put(k, lista);
		}
	}
	
	public static void HashMapToHashMap(HashMap<String, ArrayList<String>> mapa1, HashMap<String, ArrayList<String>> mapa2) {
		for(String k : mapa1.keySet()) {
			ArrayList<String> lista = new ArrayList<String>();
			lista.addAll(mapa1.get(k));
			mapa2.put(k, lista);
		}
	}

}
