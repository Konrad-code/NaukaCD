package zajecia9bootcamp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main9 {
	public static void main(String[] args) {
		
		/*
		int idy = 3;
		int idx = idy;
		while(idx == idy ? true : false) {
			System.out.println("idx to " + idx + " a idy to " + idy);
		        System.out.println(idx <<= idy);
		    System.out.println("idx to " + idx + " a idy to " + idy);
		}
		*/
		
		
		ArrayList<String> lista = new ArrayList<String>();
		String[] tab = {"Papuga", "Waran", "Bocian"};
		ArrayList<String> listaStr = new ArrayList<String>(Arrays.asList(tab));
		
		String[] nowa = listaStr.toArray(new String[listaStr.size()]);
		
		Integer tablica1[] = {3,3,9,1,5,2,9,1,7};
    	Integer tablica2[] = {3,3,3,9,1,1,2,1,1,2,3,9,9,3,2,1,1,1}; 
    	List<Integer> lista1 = new ArrayList<Integer>();
    	List<Integer> lista2 = new ArrayList<Integer>();
    	List<Integer> listaTemp = new ArrayList<Integer>();
    	List<Integer> listaTemp2 = new ArrayList<Integer>();
    	List<Integer> listaTemp3 = new ArrayList<Integer>();
    	List<Integer> listaNiewspolna = new ArrayList<Integer>();
    	List<Integer> listaAuB = new ArrayList<Integer>();
    	List<Integer> listaAnB = new ArrayList<Integer>();
    	List<Integer> listaAminusB = new ArrayList<Integer>();
    	List<Integer> listaBminusA = new ArrayList<Integer>();
    	
//		ArrayList<Integer> arrayList1 = new ArrayList<Integer>();

    	
		ArrayList<Integer> arrayList1 = new ArrayList<Integer>(Arrays.asList(tablica1));		
    	ArrayList<Integer> arrayList2 = new ArrayList<Integer>(Arrays.asList(tablica2));

    	lista1.addAll(arrayList1);									// A n B z przerzutem zapisu
    	lista2.addAll(arrayList2);
    	System.out.println("Elementy listy 1: " + lista1);
    	System.out.println("Elementy listy 2: " + lista2);
    	
    	listaAnB.addAll(lista1);
    	listaAnB.addAll(lista2);
    	listaAnB.retainAll(lista2);
    	
    	arrayList1.retainAll(arrayList2);							// A n B
    	System.out.println("lista (A n B): " + arrayList1);
    	
    	listaAuB.addAll(arrayList1);
    	listaAuB.addAll(arrayList2);
    	System.out.println("lista (A u B): " + listaAuB);			// A u B
    	
    	listaTemp.addAll(lista1);
    	listaTemp.removeAll(lista2);
    	listaAminusB.addAll(listaTemp);								// B - A
    	System.out.println("lista (A - B): " + listaAminusB);
    	
    	listaTemp2.addAll(lista2);
    	listaTemp2.removeAll(lista1);
    	listaBminusA.addAll(listaTemp2);							// B - A
    	System.out.println("lista (B - A): " + listaBminusA);
    	
    	listaTemp3.addAll(listaAminusB);
    	listaTemp3.addAll(listaBminusA);
    	listaNiewspolna.addAll(listaTemp3);							// A celownik B
    	System.out.println("lista (B celownik A): " + listaNiewspolna);
    	
    	// put na mape i get

    	// T R A N S L A T O R
    	
    	HashMap<String, String> hashMap = new HashMap<>();
    	String wyraz ="";
    	System.out.println("Wprowadz dane: ");
    	Scanner input = new Scanner(System.in);
    	while(input.hasNextLine()){
            wyraz = input.nextLine();
            String[] inputTab = wyraz.split(" ");
            String zapiszDo = inputTab[0];					// tutaj dorob getowanie z hashmapy, potem sklej zappenduj i wyswietl
            System.out.println(wyraz);
        }
    	input.close();
    	
    	File translator = new File("C:\\Users\\mHm_MaXi\\Desktop\\AKADEMIA KODU\\bazaTranslatora.txt");
        
    	try{
            Scanner odczyt = new Scanner(translator);
            while(odczyt.hasNextLine()){
                wyraz = odczyt.nextLine();
                String[] odczytTab = wyraz.split("#");
                hashMap.put(odczytTab[0], odczytTab[1]);
            }
            odczyt.close();
        }catch(FileNotFoundException e){
            System.out.println("Brak hasel w bazie translatora (pusta baza = brak pliku)");
            e.printStackTrace();
        }
    	
    	// 
    	
    	try{
            FileWriter output = new FileWriter("C:\\Users\\mHm_MaXi\\Desktop\\AKADEMIA KODU\\zaszyfrowany.txt");
            output.write(wyraz);
            output.close();
                System.out.println("Zapis zakonczony powodzeniem");
            } catch(IOException e){
                System.out.println("Pojawil sie blad podczas zapisu");
                e.printStackTrace();
            }
	}
}