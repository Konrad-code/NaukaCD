package zajecia12bootcampFirma;

import java.util.ArrayList;

public abstract class Pracownik implements Zakupy {
	private String imie;
	private int wynagrodzenie;
	private int budzetZakupy;
	protected boolean czyZatrudniony;
	static ArrayList<Pracownik> pracownicy = new ArrayList<Pracownik>();	// ARRAYLISTA PRACONIKOW PRZEKAZYWANA DO OBROBKI NA POTRZEBY STWORZENIA KOSZTORYSU W KLASIE FIRMA
	private static int liczbaZatrudnionychPracownikow = 0;
	
	Pracownik(String imie, int budzetZakupy){
		this.imie = imie;
		this.budzetZakupy = budzetZakupy;
		pracownicy.add(this);
	}

	@Override
	public int getBudzetZakupy() {
		return budzetZakupy;
	}

	private void setBudzetZakupy(int budzetZakupy) {
		this.budzetZakupy = budzetZakupy;
	}
	
	public static void dodajLiczbaZatrudnionychPracownikow() {
		Pracownik.liczbaZatrudnionychPracownikow++;
	}

	public static int getLiczbaZatrudnionychPracownikow() {
		return liczbaZatrudnionychPracownikow;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public int getWynagrodzenie() {
		return wynagrodzenie;
	}

	protected void setWynagrodzenie(int wynagrodzenie) {
		this.wynagrodzenie = wynagrodzenie;
	}

	public abstract void ustawWynagrodzenie(double wynagrodzenie);

	public boolean lowerCash(int szmal) {
		boolean czyWeszlo = false;
		int nowyBudzet = 0;
		nowyBudzet = getBudzetZakupy() - szmal;
		if(nowyBudzet >= 0) {
			setBudzetZakupy(nowyBudzet);
			czyWeszlo = true;
		}
		else
			System.out.println("Pracownika nie stac na dokonanie zakupu");
		return czyWeszlo;
	}

	@Override
	public boolean dokonajZakupu(int hajs) {
		if(lowerCash(hajs))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "Pracownik [imie = " + getImie() + ", wynagrodzenie = " + getWynagrodzenie() + ", budzet na zakupy = " + getBudzetZakupy() + "]";
	}
}
