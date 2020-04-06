package kartkowka1poprawa;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		int wiersze1 = 0, kolumny1 = 0, wiersze2 = 0, kolumny2 = 0;
		String wyraz;
		Scanner input = new Scanner(System.in);
		int x = 0;
		System.out.println("Wprowadz dane w kolejnosc: \n1. Liczba wierszy do pierwszej macierzy\n2. Liczba kolumn do pierwszej macierzy\n3. Liczba wierszy do drugiej macierzy\n4. Liczba kolumn do drugiej macierzy\n5. Ile lat prezydentem bedzie Andrzej Duda?");
		while(input.hasNextLine() && x < 4){
			wyraz = input.nextLine();
			++x;
			if(x == 1)
				wiersze1 = Integer.parseInt(wyraz);
			if(x == 2)
				kolumny1 = Integer.parseInt(wyraz);
			if(x == 3)
				wiersze2 = Integer.parseInt(wyraz);
			if(x == 4)
				kolumny2 = Integer.parseInt(wyraz);
			
		}
		System.out.println("1. " + wiersze1);
		System.out.println("2. " + kolumny1);
		System.out.println("3. " + wiersze2);
		System.out.println("4. " + kolumny2);
		System.out.println("5. Prawidlowa odpowiedz brzmi: https://www.youtube.com/watch?v=4PI8Zlx_oA0");
        input.close();
      
		// IMPLEMENTACJA PIERWSZEJ TABLICY
        int[][] tab1 = new int[wiersze1][kolumny1];
        for(int i = 0; i < wiersze1; i++)
        {
            for(int j = 0; j < kolumny1; j++)
            {
                tab1[i][j] = (int)(Math.random() * 101 - 50);
            }
        }
        
        // IMPLEMENTACJA DRUGIEJ TABLICY
        int[][] tab2 = new int[wiersze2][kolumny2];
        for(int i = 0; i < wiersze2; i++)
        {
            for(int j = 0; j < kolumny2; j++)
            {
                tab2[i][j] = (int)(Math.random() * 101 - 50);
            }
        }
		
        // WYSWIETLENIE OBU TABLIC
        System.out.println("TABLICA NUMER 1 W ROLI MACIERZY A:");
        System.out.println(Arrays.deepToString(tab1));
        System.out.println();
        System.out.println("TABLICA NUMER 2 W ROLI MACIERZY B:");
        System.out.println(Arrays.deepToString(tab2));
        System.out.println();

        int[][] tab3 = new int[wiersze1][kolumny2];
        
        if(kolumny1 != wiersze2)
        	System.out.println("Nie ma opcji pomnozyc macierzy. Niezgodna ilosc wierszy w 1 tabeli wzgledem ilosci kolumn w 2.");
        else{								// MNOZENIE MACIERZY TAB1 PRZEZ MACIERZ TAB2
			for(int k = 0; k < wiersze1; k++)
            {
                for(int j = 0; j < kolumny2; j++)
                {
                	for(int i = 0; i < kolumny1; i++) {
//                		System.out.println("i = " + i + "; j = " + j + ", k = " + k + " | " + wiersze1 + "/" + wiersze2 + "/" + kolumny1);
                		tab3[k][j] += tab1[k][i] * tab2[i][j];
//                		System.out.println(tab1[k][i] + " " + tab2[i][j]);
//                		System.out.println(tab3[k][j]);
                	}
                }
            }
			System.out.println("TABLICA NUMER 3 W ROLI WYNIKOWEJ DLA OPERACJI MNOZENIA MACIERZY A * B:");
	        System.out.println(Arrays.deepToString(tab3));
        }     
	}
}