package kartkowka2;

import java.util.Scanner;

import zajecia12bootcampFirma.ZlyZnak;

public class MainKartkowka2 {
	
	public static void rysujMape(char[][] mapa) {
    	for(int i = 0; i < mapa.length; i++) {
			for(int j = 0; j < mapa[i].length; j++) {
				System.out.print(mapa[i][j] + "|");
			}
			System.out.println("");
		}
	}
		
	public static void main(String[] args) {
   	
    	int x = 0;			// pozycja X
    	int y = 0; 			// pozycja Y
    	int sciany = 20;	// ilosc barier
    	int moby = 3;		// moby do skasowania
    	int iloscGraczy = 1;
    	int wspGrX, wspGrY, wspPot1X, wspPot2X, wspPot3X, wspPot1Y, wspPot2Y, wspPot3Y;
    	wspGrX = wspGrY = wspPot1X = wspPot2X = wspPot3X = wspPot1Y = wspPot2Y = wspPot3Y = 0;
    	int itPotworow = 1;
    	
		char[][] mapa = new char[10][10];						// inicjalizacja planszy o wymiarze 10 x 10
		
		for(int i = 0; i < mapa.length; i++) {					// zapelnij tablice reprezentujaca plansze gry wolnymi polami w postaci spacji
			for(int j = 0; j < mapa[i].length; j++) {
				mapa[i][j] = ' ';
//				System.out.println(mapa[i][j] + " ");
			}
//			System.out.println();
		}
//		System.out.println(Arrays.deepToString(mapa));
    	
    	while(sciany > 0) {
    		x = (int)(Math.random() * 10);
    		y = (int)(Math.random() * 10);
    		if((mapa[x][y] != 'X') && (mapa[x][y] != 'G') && (mapa[x][y] != 'K')) {
    			mapa[x][y] = 'X';
    			sciany--;
    		}
    	}

    	while(iloscGraczy > 0) {
    		x = (int)(Math.random() * 10);
    		y = (int)(Math.random() * 10);
    		if((mapa[x][y] != 'X') && (mapa[x][y] != 'G') && (mapa[x][y] != 'K')) {
    			mapa[x][y] = 'G';
    			wspGrX = x;
    			wspGrY = y;
    			iloscGraczy--;
    		}
    	}
    	
    	while(moby > 0) {
    		x = (int)(Math.random() * 10);
    		y = (int)(Math.random() * 10);
    		if((mapa[x][y] != 'X') && (mapa[x][y] != 'G') && (mapa[x][y] != 'K')) {
    			mapa[x][y] = 'K';
    			if(itPotworow == 1) {
    				wspPot1X = x;
    				wspPot1Y = y;
    			}else if(itPotworow == 2) {
    				wspPot2X = x;
    				wspPot2Y = y;
    			}else if(itPotworow == 3) {
    				wspPot3X = x;
    				wspPot3Y = y;
    			}
    			itPotworow++;
    			moby--;
    		}
    	}
    	
    	Gracz gracz  = new Gracz(wspGrX, wspGrY);
    	Potwor potwor1 = new Potwor(wspPot1X, wspPot1Y);
    	Potwor potwor2 = new Potwor(wspPot2X, wspPot2Y);
    	Potwor potwor3 = new Potwor(wspPot3X, wspPot3Y);
    	    	
    	rysujMape(mapa);
    	  	
    	boolean koniecGry = false;
//    	boolean czyMozeSieRuszyc = true;	// do potencjalnego zabezpieczenia gdyby gracz nie mogl sie ruszyc
    	char wprowadzonyRuch = ' ';
    	String wprowadzonyString = "";
    	boolean czyPoprawnieWprowadzonyRozkaz = true;
    	
    	Scanner input = new Scanner(System.in);
    	while(!koniecGry) {
    		czyPoprawnieWprowadzonyRozkaz = true;
    		while(czyPoprawnieWprowadzonyRozkaz && !koniecGry) 
    		try{
    			System.out.println("Wprowadz ruch (W/S/A/D)");
    			wprowadzonyString = input.nextLine();
    			if((wprowadzonyString.length() != 1) || !((wprowadzonyString.charAt(0) == 'W') || (wprowadzonyString.charAt(0) == 'S') || (wprowadzonyString.charAt(0) == 'A') || (wprowadzonyString.charAt(0) == 'D'))) 
    				throw new ZlyZnak();
    				
    			wprowadzonyRuch = wprowadzonyString.charAt(0);
	    		char[][] mapaTemp = mapa;
	    		
	    		if(gracz.sprawdzRuch(wprowadzonyRuch, mapa)) {
		    		mapaTemp = gracz.wykonajRuch(wprowadzonyRuch, mapa);
		    		if(potwor1.getSkasowanyPotwor() && potwor2.getSkasowanyPotwor() && potwor3.getSkasowanyPotwor()) {
		    			koniecGry = true;
		    			input.close();
		    			System.out.println("Powinno przerwac");
		    		}
		    		else {
			    		if(!potwor1.getSkasowanyPotwor()) {
			    			mapaTemp = potwor1.ruszPotwora(mapaTemp);
//			    			System.out.printf("Wspolrzedne potwor1: %d, %d\n", wspPot1X, wspPot1Y);
			    		}
			    		if(!potwor2.getSkasowanyPotwor()) {
			    			mapaTemp = potwor2.ruszPotwora(mapaTemp);
//			    			System.out.printf("Wspolrzedne potwor2: %d, %d\n", wspPot2X, wspPot2Y);
			    		}
			    		if(!potwor3.getSkasowanyPotwor()) {
			    			mapaTemp = potwor3.ruszPotwora(mapaTemp);
//			    			System.out.printf("Wspolrzedne potwor3: %d, %d\n", wspPot3X, wspPot3Y);
			    		}
		    		}
		    		mapa = mapaTemp;
	    		}else
	    			System.out.println("Nie mozesz ruszyc sie w ta strone. Rusz sie ponownie");
//	    		System.out.println(potwor1.getSkasowanyPotwor() + " " + potwor2.getSkasowanyPotwor() + " "  + potwor3.getSkasowanyPotwor());
	    		rysujMape(mapa);
//	    		int wspX = gracz.getPozycjaX();
//	    		int wspY = gracz.getPozycjaY();
//	    		System.out.printf("Wspolrzedne gracza: %d, %d\n", wspX, wspY);
    		}catch(ZlyZnak zz) {
    			czyPoprawnieWprowadzonyRozkaz = false;
    		}
    	}
    	System.out.println("KONIEC GRY");    	
	}
}
