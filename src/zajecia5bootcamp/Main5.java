package zajecia5bootcamp;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main5 {
	
	public static void wypiszTab(int[] tab){
        System.out.println("Elementy tablicy to: ");
        for(int i = 0; i < tab.length; i++)
            System.out.print(tab[i] + " ");
        System.out.println();
    }
    
    public static void wypiszTab2(int[][] tab){
        System.out.println("Elementy tablicy to: ");
        for (int[] tab1 : tab) {
            for (int j = 0; j < tab1.length; j++) {
                System.out.print(tab1[j] + " ");
            }
        }
        System.out.println();
    }
    
    //  MOJ KLASYCZNY KOD:
    
//            for(int i = 0; i < tab.length; i++)
//                for(int j = 0; j < tab[i].length; j++)
//                System.out.println(tab[i][j] + " ");
    
    // OKRESLENIE ROZMIARU TABLICY KTORA POWSTANIE Z NIEPOWTARZAJACYCH SIE WEWNETRZNIE ELEMENTOW TABLICY MACIERZYSTEJ
    public static int liczIleRoznychLiczbWTablicy(int[] tab)
    {
        int it = 0;
        int zmienna = 0;
        if(tab.length == 0)
        	it = 0;
        else 
        {
        	for(int i = 0; i < tab.length; i++)
            {
        		zmienna = 0;
            	for(int j = i + 1; j < tab.length; j++)
            	{
    	            if(tab[i] == tab[j])
    	            {
//    	            	System.out.printf("Element %d znajdujacy sie na pozycji %d pokrywa sie z tym samym %d na pozycji %d", tab[i], i, tab[j], j);
//    	            	System.out.println();
    	            	zmienna++;
    	                break;
    	            }
            	}
            	if(zmienna == 0)
            		it++;
            }
        }
//        System.out.println("W tablicy jest " + it + " roznych elementow");
        return it;
    }
    
    // STWORZENIE TABLICY KTORA SKLADA SIE Z NIEPOWTARZAJACYCH SIE WEWNETRZNIE ELEMENTOW TABLICY MACIERZYSTEJ
    public static int[] utworzTabliceLiczb(int[] tablica, int rozmiar)
    {
    	int it = 0;
    	boolean czyPowtarza = false;
        int zmienna = 0;
        int przechowalnik = 0;
        int[] tab = new int[rozmiar];
        if(tablica.length == 0)
        	return tablica;
        else 
        {
        	for(int i = 0; i < tablica.length; i++)
            {
        		zmienna = 0;
        		przechowalnik = 0;
        		
        		// PRZESZUKANIE WSZYSTKICH ELEMENTOW j KOPII TABLICY LICZAC OD ELEMENTU i + 1 NASTEPUJACEGO PO OBECNIE ROZPATRYWANYM W TABLICY MACIERZYSTEJ
            	for(int j = i + 1; j < tablica.length; j++)
            	{
    	            if(tablica[i] == tablica[j] && zmienna < 1)
    	            {
//    	            	System.out.printf("Element %d znajdujacy sie na pozycji %d pokrywa sie z tym samym %d na pozycji %d", tablica[i], i, tablica[j], j);
//    	            	System.out.println();
    	            	zmienna++;
    	            }
            	}
            	
            	// JESLI PO PRZESZUKANIU KOPII TABLICY DLA DANEGO ELEMENTU NIE WYSTEPUJE POWTORZENIE FLAGOWANE zmienna 
            	// TO NA PIERWSZY INDEKS it DOCELOWEJ TABLICY tab WJEZDZA TEN ELEMENT 
            	if(zmienna == 0)
            	{
            		tab[it] = tablica[i];
//            		System.out.println(it);
//            		System.out.println("Wartosc: " + tab[it] + " trafia na miejsce " + it);
            		it++;
            	}
            }
        	tab[tab.length - 1] = tablica[tablica.length - 1];        	
        }
        return tab;
    }
    
    public static int[] znajdzWsp(int[] tab, int[] tab2){
        
        // ZLICZANIE ELEMENTOW WSPOLNYCH W CELU OKRESLENIA ROZMIARU NOWEJ TABLICY
        int rozmiarNowej = 0;                                                           // licz - tutaj rozmiar tablicy wspolneAB
        int it = 0;

        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0; j < tab2.length; j++)
                if(tab[i] == tab2[j])
                {
                    rozmiarNowej++;
                    break;
                }    
        }

        // ZAPISANIE NOWEJ TABLICY WARTOSCIAMI A, KTORE WYSTAPILY TEZ W B
        int[] wspolneAB = new int[rozmiarNowej];                                    // inicjalizacja tablicy wspolneAB o rozmiarze dlugosc
        for(int i = 0; i < tab.length; i++)
        {
            for(int j = 0; j < tab2.length; j++)
            {
                if(tab[i] == tab2[j])
                {
//                    System.out.println("Element wspolny tablicy A " + tab[i] + " z miejsca " + i + " jest rowny elementowi " + tab2[j] + " z polozenia " + j);
                    wspolneAB[it] = tab2[j];
//                    System.out.println("Iterator ma wskazanie: " + it);
                    it++;
                    break;
                }
            }    
        }
        return wspolneAB;
    }
    
    public static int[] iloscWystapien(int[] tablica)
    {
    	int[] tab = new int[tablica.length];
    	for(int i = 0; i < tablica.length; i++)
    	{
    		
    	}
    	return tab;
    }
    
    public static int znajdzMax(int[] tab){
        
        int zmienna = 0;
        for(int i = 0; i < tab.length; i++)
            {
                if(tab[i] > zmienna)
                    zmienna = tab[i];
            }
        return zmienna;
    }
    
    public static int znajdzMin(int[] tab){
        
        int zmienna = tab[0];
        for(int i = 0; i < tab.length; i++)
            {
                if(tab[i] < zmienna)
                    zmienna = tab[i];
            }
        return zmienna;
    }
    
    public static int[] sortMin(int[] tab)
    { 
		int[] tabPom = new int[tab.length];
		tabPom[0] = znajdzMin(tab);
		
        int zmienna = znajdzMax(tab);
        int a = zmienna;
        for(int i = 1; i < tabPom.length; i++)
        {
	        zmienna = a;
        	for(int j = 0; j < tab.length; j++)
	            {
	                if(tab[j] < zmienna && tab[j] > tabPom[i - 1])
	                    zmienna = tab[j];
	            }
        	tabPom[i] = zmienna;
        }
        return tabPom;
    }
    
    public static int[] countingSort(int[] tablica){
        
        int a = tablica.length;
        wypiszTab(tablica);
        
        int ileRoznychLiczb = liczIleRoznychLiczbWTablicy(tablica);             // ROZMIAR TABLICY ROZNE LICZBY

        int[] tab = utworzTabliceLiczb(tablica, ileRoznychLiczb);   			// TABLICA ROZNYCH LICZB
        wypiszTab(tab);
              
        int[] tab2 = sortMin(tab);												// POSORTOWANA TABLICA ROZNYCH LICZB ROSNACO
        wypiszTab(tab2);
        
//        int[] tab3 = znajdzWsp(tab, tab2);                                      // STWORZENIE TABLICY WSPOLNYCH DZIELNIKOW
//        wypiszTab(tab3);
//        int wynik = znajdzMax(tab3);                                            // WYSZUKANIE NWD Z TABLICY WSPOLNYCH DZIELNIKOW 
        
        return tab2;
}
    public static void main(String[] args) throws FileNotFoundException {

    	int tablica[] = {3,3,9,1,5,2,9,1,7};
    	int tablica1[] = {3,3,3,9,1,1,2,1,1,2,3,9,9,3,2,1,1,1}; 
    	countingSort(tablica);
    	
    	int liczba = 452;
//    	Scanner scanner = new Scanner(System.in);
//    	String tekst = scanner.nextLine();
//    	scanner.close();
    	
    	// PRZELICZANIE LICZBY MIEDZY SYSTEMEM BINARNYM A DZIESIETNYM I Z POWROTEM
    	
    	/*
    	int dzielnik = 8;
    	int licznik = 0;
//    	int[] reszty = new int[];
    	int liczbaDzielona = 452;
    	while(liczbaDzielona > 1)
		{
    		System.out.println(liczbaDzielona + " " + licznik);
    		liczbaDzielona /= dzielnik;
			licznik++;
//			System.out.println(liczbaDzielona + " " + licznik);		
		}
    	System.out.println(licznik);
    	
//    	for(int i = 0; i < liczba; i++)
//    	{
//    		
//    	}
    	*/
    	

    
    }
}
