package zajecia12bootcampFirma;

public class Sezonowy extends Pracownik {

	private double czescEtatu = 0;
	private int numerSezonowego;
	static int numer = 1;
	
	Sezonowy(String imie, int budzetZakupy, int stawka, boolean czyZatrudniony, double czescEtatu) {
		super(imie, budzetZakupy);
		this.czyZatrudniony = czyZatrudniony;
		this.czescEtatu = czescEtatu;
		ustawWynagrodzenie(stawka * czescEtatu);
		this.setNumerSezonowego(numer);
		numer++;
		if(czyZatrudniony)
			dodajLiczbaZatrudnionychPracownikow();
	}
		
	@Override
	public int getNumer() {
		return numerSezonowego;
	}

	private void setNumerSezonowego(int numerSezonowego) {
		this.numerSezonowego = numerSezonowego;
	}

	public boolean getCzyZatrudniony() {
		return czyZatrudniony;
	}

	public double getCzescEtatu() {
		return czescEtatu;
	}

	@Override
	public void ustawWynagrodzenie(double mnoznikStawkiICzesciEtatu) {
		if(getCzyZatrudniony())
			super.setWynagrodzenie((int)(mnoznikStawkiICzesciEtatu * 160));
	}

	@Override
	public String toString() {
		String zatrudniony = "zatrudniony";
		String nieZatrudniony = "niezatrudniony";
		return "Sezonowy o numerze: " + getNumer() + " [imie = " + getImie() + ", pracujacy na " + getCzescEtatu() + " czesci etatu, a jest " + (czyZatrudniony ? zatrudniony : nieZatrudniony) + " i jego wynagrodzenie = " + getWynagrodzenie() + "]";
	}
}
