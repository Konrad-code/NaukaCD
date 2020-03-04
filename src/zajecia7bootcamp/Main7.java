package zajecia7bootcamp;

import java.util.Arrays;
import java.util.Scanner;

public class Main7 {
	
	// ZADANIE 15
	
	public static String kasujInne(String wprowadzony) {
		StringBuilder arg = new StringBuilder(wprowadzony);
		for(int i = 0; i < arg.length(); i++) {
			char a = arg.charAt(i);
			if(!((a <= 'Z' && a >= 'A') || (a <= 'z' && a >= 'a'))) {
				arg.setCharAt(i, ' ');
			}
		}
		String wynik = arg.toString();
		return wynik;
	}
	
	public static String[] wprowadzonaTablicaStringow(String wyrazy) {
		String[] tabString = wyrazy.split(" ");
		System.out.println(Arrays.toString(tabString));
		return tabString;
	}
	
	public static int wprowadzStringiRecznie() {
		int a = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj ciag wyrazow skladajacych sie wylacznie z duzych i malych liter: ");
		String wyrazy = scanner.nextLine();
		String wstepnieObrobiony = kasujInne(wyrazy);
		wprowadzonaTablicaStringow(wstepnieObrobiony);
		System.out.println("Czy ciag wyrazow jaki chciales podac to: " + wstepnieObrobiony);
		
		
//		System.out.println(Arrays.toString(strJava.split(" ")));
//		int wiek = Integer.parseInt(scanner.nextLine());
//		System.out.println(wyrazy);
    	scanner.close();
    	return a;
	}
	
	public static int najdluzszyString(String[] args) {
		int wynik = 0;
		
		return wynik;
	}
	
	// ZADANIE 16
	
	// OKRESLENIE ROZMIARU TABLICY KTORA POWSTANIE Z NIEPOWTARZAJACYCH SIE WEWNETRZNIE ELEMENTOW TABLICY MACIERZYSTEJ
    public static int liczIleRoznychLiczbWTablicy(int[] tab){
        int it = 0;
        int zmienna = 0;
        if(tab.length == 0)
        	it = 0;
        else {
        	for(int i = 0; i < tab.length; i++){
        		zmienna = 0;
            	for(int j = i + 1; j < tab.length; j++){
    	            if(tab[i] == tab[j]){
    	            	zmienna++;
    	                break;
    	            }
            	}
            	if(zmienna == 0)
            		it++;
            }
        }
        return it;
    }
    
    // STWORZENIE TABLICY KTORA SKLADA SIE Z NIEPOWTARZAJACYCH SIE WEWNETRZNIE ELEMENTOW TABLICY MACIERZYSTEJ
    public static int[] utworzTabliceLiczb(int[] tablica, int rozmiar){
    	int it = 0;
        int zmienna = 0;
        int przechowalnik = 0;
        int[] tab = new int[rozmiar];
        if(tablica.length == 0)
        	return tablica;
        else {
        	for(int i = 0; i < tablica.length; i++){
        		zmienna = 0;
        		przechowalnik = 0;
        		
        		// PRZESZUKANIE WSZYSTKICH ELEMENTOW j KOPII TABLICY LICZAC OD ELEMENTU i + 1 NASTEPUJACEGO PO OBECNIE ROZPATRYWANYM W TABLICY MACIERZYSTEJ
            	for(int j = i + 1; j < tablica.length; j++){
    	            if(tablica[i] == tablica[j] && zmienna < 1)
    	            	zmienna++;
            	}
            	// JESLI PO PRZESZUKANIU KOPII TABLICY DLA DANEGO ELEMENTU NIE WYSTEPUJE POWTORZENIE FLAGOWANE zmienna 
            	// TO NA PIERWSZY INDEKS it DOCELOWEJ TABLICY tab WJEZDZA TEN ELEMENT 
            	if(zmienna == 0){
            		tab[it] = tablica[i];
            		it++;
            	}
            }
        	tab[tab.length - 1] = tablica[tablica.length - 1];        	
        }
        return tab;
    }
	
    public static int[] czyPierwsze(int[] tablica) {
    	int zmienna = 0;
    	int temp = 0;
    	boolean czyPierwsza = true;
    	for(int i = 0; i < tablica.length; i++) {
    		czyPierwsza = true;
    		temp = 0;
    		if(tablica[i] > 1){
	    		for(int j = 2; j < tablica[i]; j++) {
	    			if(tablica[i] % j == 0 && czyPierwsza) {
	    				czyPierwsza = false;
	    				temp++;
	    			}
	    		}
	    		if(temp == 0)
	    			zmienna++;
    		}
    	}
    	
    	int[] tab = new int[zmienna];
    	for(int it = 0; it < tab.length; ) {
    		for(int i = 0; i < tablica.length; i++) {
	    		if(tablica[i] > 1){
	    			zmienna = 0;
		    		czyPierwsza = true;
		    		for(int j = 2; j < tablica[i]; j++) {
		    			if(tablica[i] % j == 0 && zmienna < 1) {
		    				czyPierwsza = false;
		    				zmienna++;
		    			}
		    		}
		    		if(czyPierwsza) {
		    			tab[it] = tablica[i];
		    			it++;
		    		}
	    		}
	    	}
    	}
    	return tab;
    }
    
	public static int[] dzielniki(int[] tablica) {
		int a = liczIleRoznychLiczbWTablicy(tablica);
		int[] tab = utworzTabliceLiczb(tablica, a);
		tab = czyPierwsze(tab);
		
		return tab;
	}
	
	// ZADANIE 17
	
	public static void newArray(boolean[] tablica) {
		int it = 0;
		for(int i = 0; i < tablica.length; i++) {
			if(tablica[i] == true)
				it++;
		}
		boolean[] tab = new boolean[it];
		for(int i = 0; i < tab.length; i++) {
			tab[i] = true;
		}
		wypiszTabBool(tab);
	}
	
	// ZADANIE 18
	
	public static void numberOfElements(int[] tablica, int k) {
		int suma = 0;
		for(int i = 0; i < tablica.length; i++)
		{
			if(k == tablica[i])
				suma++;
//			System.out.println(suma);
		}
		System.out.printf("Suma wystapien liczby %d w tablicy wynosi: %d", k, suma);
		System.out.println();
	}
	
	public static void wypiszTab(int[] tab){
        System.out.println();
		System.out.println("Elementy tablicy to: ");
        for(int i = 0; i < tab.length; i++)
            System.out.print(tab[i] + " ");
        System.out.println();
    }
	public static void wypiszTabBool(boolean[] tab){
        System.out.println();
		System.out.println("Elementy tablicy to: ");
        for(int i = 0; i < tab.length; i++)
            System.out.print(tab[i] + " ");
        System.out.println();
    }
	
	public static int[][] dwuWymiarowyBubbleSortMalejacy(int[][] tab){
		
	// ITERACJA PO WIERSZACH
			for (int wiersz = 0; wiersz < tab.length; wiersz++) {
				boolean zamiana = true;
	// SORTOWANIE BUBBLE SORT
				while (zamiana) {
					zamiana = false;
					for (int i = 0; i < tab[wiersz].length - 1; i++) {
						if (tab[wiersz][i] > tab[wiersz][i + 1]) {
							zamiana = true;
							int tmp = tab[wiersz][i];
							tab[wiersz][i] = tab[wiersz][i + 1];
							tab[wiersz][i + 1] = tmp;
						}
					}
				}
			}

	// ITERACJA PO KOLUMNACH
			for (int kolumna = 0; kolumna < tab.length; kolumna++) {
				boolean zamiana = true;
	// SORTOWANIE BUBBLE SORT
				while (zamiana) {
					zamiana = false;
					for (int i = 0; i < tab.length - 1; i++) {
						if (tab[i][kolumna] > tab[i + 1][kolumna]) {
							zamiana = true;
							int tmp = tab[i][kolumna];
							tab[i][kolumna] = tab[i + 1][kolumna];
							tab[i + 1][kolumna] = tmp;
						}
					}
				}
			}

	// WYPIS TABLICY PETLA FOR-EACH
			for (int[] t : tab) {
				for (int i : t)
					System.out.print(i + " ");
				System.out.println();
			}		
		return tab;
	}
	
	// ZLICZANIE LICZB UJEMNYCH O ZLOZONOSCI N DLA KWADRATOWEJ TABLICY DWUWYMIAROWEJ
	
	public static int liczUjemne(int[][] tab) {
		int suma2 = 0;
		int wiersz = 0;
		int kolumna = tab.length - 1;
		while(wiersz < tab.length && kolumna >= 0) {
			if(tab[wiersz][kolumna] < 0) {
				suma2 += kolumna + 1;
				wiersz++;
			}else
				kolumna--;		
		}
		System.out.println(suma2);
		return suma2;
	}
	
	// ZLICZANIE LICZB UJEMNYCH O ZLOZONOSCI N^2
	
	public static int liczUjemne2(int[][] tab) {
		boolean czyTrafiona = false;
		int suma = 0;
		for(int i = 0, zmienna = tab[i].length - 1; i < tab.length; i++) {
			czyTrafiona = false;
			for(int j = zmienna; j > 0; j--){
				if(tab[i][j] < 0 && !czyTrafiona) {
					czyTrafiona = true;
					suma += j + 1;
					zmienna = j + 1;
				}	
			}
		}
		System.out.println(suma);
		return suma;
	}
	
	public static void main(String[] args)
	{
		int[] tab69 = {1,2,3,3,3,4,3};
		int liczba = 3;
		int[] tab1 = {1,2,3,3,3,4,3};
		int liczba1 = 8;
		numberOfElements(tab69, liczba);
		numberOfElements(tab1, liczba1); 
		
		boolean[] tabBool = {false,true,true,false,false};
		boolean[] tabBool1 = {true,true,true,true,false,false,true};
		newArray(tabBool);
		newArray(tabBool1);
		
		int[] tabPierw = {1,9,9,99,31,17,11,41,11,91,67,69,79,23,83,0,89,83,1,0,2};
		int[]testowa = dzielniki(tabPierw);
		wypiszTab(testowa);
		
		wprowadzStringiRecznie();					// a1bc ! 7ghfA@2BC,d
		
		int[][] tab = new int[10][10];

		// IMPLEMENTACJA 2-WYMIAROWEJ TABLICY LICZB Z ZAKRESU<-10,10>
		for (int i = 0; i < tab.length; i++)
			for (int j = 0; j < tab[i].length; j++)
				tab[i][j] = (int) (Math.random() * 21) - 10;

//		int[] tablica = { 3, 4, 5, 6, 7, 2, 1, 2, 3, 2 };

		tab = dwuWymiarowyBubbleSortMalejacy(tab);
		
		liczUjemne(tab);
		liczUjemne2(tab);
	}
}
