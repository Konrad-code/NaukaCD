package zajecia13bootcamp;

public class Main13 {
	public static int suma(int... tab) {
		int suma = 0;
		for(int liczba : tab)
			suma += liczba;
		
		return suma;
	}
	
	public static void main(String[] args) {
//		System.out.println(suma(1, 5, -2, 9, 10, 4, 15));
		
//		new Instancja();
		
//		Instancja.wypisz();
//		Instancja.wypisz();
		
//		new InstancjaPochodna();
		
//		InstancjaPochodna.wypisz(5);
		
		Pajak pajak = new Pajak("Celestia", 100);
		Pajak.modyfikujMaseCiala(pajak);
		
		System.out.println(pajak.masaCiala);
		
		int a = 10;
		Pajak.modyfikuj(a);
		System.out.println(a);

		// SPRAWDZANIE OBIEKTU RODZICA Z KLASA RODZICA
		
		if(pajak instanceof Pajak)				// ZAWSZE UZYWANY DO RZUTOWANIA W DOL, BIERZE DOKLADNIE JESLI JEST TEJ KLASY I TYLKO TEJ (ZADNE POTOMNE)
			System.out.println("Tak");
		else
			System.out.println("Nie");
		
		if(pajak.getClass() == Pajak.class)		// MA SZERSZY ZAKRES NIZ TA OPCJA POWYZEJ - LAPIE TEZ DZIECI
			System.out.println("Tak");
		else
			System.out.println("Nie");
		
		CzarnaWdowa czarnaWdowa = new CzarnaWdowa("Czarnuch", 100);
		
		// SPRAWDZANIE OBIEKTU DZIECKA Z KLASA RODZICA
		
		System.out.println("SPRAWDZANIE OBIEKTU DZIECKA Z KLASA RODZICA");
		if(czarnaWdowa instanceof Pajak)				
			System.out.println("Tak");
		else
			System.out.println("Nie");
		
//		if(czarnaWdowa.getClass() == Pajak.class)		
//			System.out.println("Tak");
//		else
//			System.out.println("Nie");
		
		// SPRAWDZANIE OBIEKTU DZIECKA Z KLASA DZIECKA
		
		System.out.println("SPRAWDZANIE OBIEKTU DZIECKA Z KLASA DZIECKA");
		if(czarnaWdowa instanceof CzarnaWdowa)				
			System.out.println("Tak");
		else
			System.out.println("Nie");
		
		if(czarnaWdowa.getClass() == CzarnaWdowa.class)		
			System.out.println("Tak");
		else
			System.out.println("Nie");
		
		// SPRAWDZANIE OBIEKTU RODZICA Z KLASA DZIECKA
		
		System.out.println("SPRAWDZANIE OBIEKTU RODZICA Z KLASA DZIECKA");
		if(pajak instanceof CzarnaWdowa)				
			System.out.println("Tak");
		else
			System.out.println("Nie");
				
		if(pajak.getClass() == CzarnaWdowa.class)		
			System.out.println("Tak");
		else
			System.out.println("Nie");		
		
		Ptasznik ptasznik = new Ptasznik("Ptasznik mozambijski", 400);
		
		// SPRAWDZANIE OBIEKTU JEDNEGO DZIECKA Z KLASA DRUGIEGO DZIECKA
		
		System.out.println("SPRAWDZANIE OBIEKTU RODZICA Z KLASA DZIECKA");
//		if(ptasznik instanceof CzarnaWdowa)				
//			System.out.println("Tak");
//		else
//			System.out.println("Nie");
//				
//		if(ptasznik.getClass() == CzarnaWdowa.class)		
//			System.out.println("Tak");
//		else
//			System.out.println("Nie");	
		
		System.out.println(ptasznik.getClass().getSimpleName());
	}
}
