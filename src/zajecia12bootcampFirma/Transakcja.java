package zajecia12bootcampFirma;

import java.util.ArrayList;

public class Transakcja {
	
	static ArrayList<Transakcja> transakcje = new ArrayList<Transakcja>();	// inicjalizacja ArrayListy o nazwie "transakcje" dla obiektow typu klasy Transakcja
	Klient kupujacyKlient;					// deklaracja obiektu na potencjalengo klienta w liscie (jesli w danej transakcji uczestniczy Pracownik to obiekt jest nullem)
	Pracownik kupujacyPracownik;			// deklaracja obiektu na potencjalengo pracownika w liscie (jesli w danej transakcji uczestniczy Klient to obiekt jest nullem)
	Firma sprzedajacy;						// deklaracja obiektu klasy Firma, ktory bierze udzial w operacjach klasy Transakcja i jest archiwizowany jako atrybut obiektow tejze klasy gromadzonych na liscie "transakcje"
	Zakupy[] zakupy;						// deklaracja tablicy interfejsow klasy Zakupy, ktorych obiektami (za sprawa wspolnej implementacji interfejsu) sa obiekty 3 klas dziedziczacych po klasie rodzica Pracownik oraz obiekty klasy Klient
	private int hajs;
	private int numerTransakcji;
	static int numer = 1;
	public boolean czySiePowiodla = false;
	
	private Transakcja(Firma s, int hajs) {	// nadkonstruktor pomocniczy obiektu klasy Transakcja realizujacy podstawowa obrobke argumentow i atrybutow dla kazdego nowego obiektu (wlacznie z realizacja iteracji dla numeracji transakcji)
		this.setHajs(hajs);
		this.setNumerTransakcji(numer);
		numer++;
		this.sprzedajacy = s;
	}
	
	public Transakcja(Zakupy[] zakupy, int i, Firma s, int hajs) {		// konstruktor glowny klasy Transakcja, realizujacy bardziej skomplikowane operacje zakupow, transakcji i operowania na obiektach za pomoca metody "realizujZakupy()"
		this(s, hajs);						// wywolanie konstruktora nadrzednego
		this.zakupy = zakupy;
		
		realizujZakupy(zakupy, i, s);
		transakcje.add(this);
	}
	
	public void realizujZakupy(Zakupy[] zakupy, int i, Firma s) {	// metoda realizujaca zakupy
		int stanKontaPrzejsciowy = 0;
		stanKontaPrzejsciowy = zakupy[i].getBudzetZakupy();
		
		if(zakupy[i] instanceof Klient) 							// funkcjonalnosc rozpoznajaca obiekty z tablicy "zakupy" i przypisujaca je odpowiednio jako obiekt klasy Klient lub Pracownik
			this.kupujacyKlient = (Klient)zakupy[i];
		else if(zakupy[i] instanceof Pracownik)
			this.kupujacyPracownik = (Pracownik)zakupy[i];

		if(zakupy[i].dokonajZakupu(hajs)) {							// operacja transakcji i komunikat z raportem po jej przeprowadzeniu
			s.addSzmalec(hajs);
			czySiePowiodla = true;
			System.out.printf("Transakcja sie powiodla; transakcja o numerze %d wykonana przez przedstawiciela %s o numerze %d, imieniu %s i stanie konta %d na kwote %d powodujac aktualny stan konta %d", 
														getNumerTransakcji(), zakupy[i].getClass().getSimpleName(), zakupy[i].getNumer(), zakupy[i].getImie(), stanKontaPrzejsciowy, getHajs(), zakupy[i].getBudzetZakupy());
			System.out.println();
		}else
			System.out.printf("Transakcja zakonczona niepowodzeniem; transakcja o numerze %d wykonana przez przedstawiciela %s o numerze %d, imieniu %s i stanie konta %d na kwote %d powodujac aktualny stan konta %d\n",
																	getNumerTransakcji(), zakupy[i].getClass().getSimpleName(), zakupy[i].getNumer(), zakupy[i].getImie(), stanKontaPrzejsciowy, getHajs(), zakupy[i].getBudzetZakupy());
	}
	
	public int getHajs() {
		return hajs;
	}

	private void setHajs(int hajs) {
		this.hajs = hajs;
	}

	public int getNumerTransakcji() {
		return numerTransakcji;
	}

	private void setNumerTransakcji(int numerTransakcji) {
		this.numerTransakcji = numerTransakcji;
	}

	@Override
	public String toString() {
		if(this.kupujacyKlient != null)				// KUPUJACY TO KLIENT
			return "Transakcja numer " + getNumerTransakcji() + ": [kupujacy to " + kupujacyKlient.getClass().getSimpleName() + " o numerze indeksu " + kupujacyKlient.getNumer() + " = " + kupujacyKlient.getImie() + ", sprzedajacy = " + sprzedajacy.getNazwa() + ", kwota transakcji = " + getHajs() + "]";
		else if(this.kupujacyPracownik != null)		// KUPUJACY TO PRACOWNIK
			return "Transakcja numer " + getNumerTransakcji() + ": [kupujacy to " + kupujacyPracownik.getClass().getSimpleName() + " o numerze indeksu " + kupujacyPracownik.getNumer() + " = " + kupujacyPracownik.getImie() + ", sprzedajacy = " + sprzedajacy.getNazwa() + ", kwota transakcji = " + getHajs() + "]";
		else
			return "Cos poszlo nie tak i zarowno pracownik jak i klient nie byli strona zakupu - w obecnej transakcji byli nullami";
	}
}
