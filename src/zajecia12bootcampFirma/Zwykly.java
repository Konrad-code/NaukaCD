package zajecia12bootcampFirma;

public class Zwykly extends Pracownik{
	private int numerZwyklego;
	static int numer = 1;
	
	Zwykly(String imie, int budzetZakupy, int stawka) {
		super(imie, budzetZakupy);
		this.czyZatrudniony = true;
		ustawWynagrodzenie(stawka);
		this.setNumerZwyklego(numer);
		numer++;
		if(czyZatrudniony)
			dodajLiczbaZatrudnionychPracownikow();
	}
	
	public int getNumer() {
		return numerZwyklego;
	}

	private void setNumerZwyklego(int numerZwyklego) {
		this.numerZwyklego = numerZwyklego;
	}

	@Override
	public void ustawWynagrodzenie(double stawka) {
		super.setWynagrodzenie((int)stawka * 160);
	}

	@Override
	public String toString() {
		return "Zwykly o numerze: " + getNumer() + " [imie = " + getImie() + ", wynagrodzenie = " + getWynagrodzenie() + "]";
	}
}
