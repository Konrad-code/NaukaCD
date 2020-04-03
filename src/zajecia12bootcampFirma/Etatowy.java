package zajecia12bootcampFirma;

public class Etatowy extends Pracownik {

	private int stazPracy = 0;
	private int progPremii = 0;
	private int numerEtatowego;
	static int numer = 1;
	
	Etatowy(String imie, int budzetZakupy, int stawka, int stazPracy) {
		super(imie, budzetZakupy);
		this.czyZatrudniony = true;
		this.setStazPracy(stazPracy);
		ustawWynagrodzenie(stawka);
		this.setNumerEtatowego(numer);
		numer++;
		if(czyZatrudniony)
			dodajLiczbaZatrudnionychPracownikow();
	}
	
	@Override
	public int getNumer() {
		return numerEtatowego;
	}

	private void setNumerEtatowego(int numerEtatowego) {
		this.numerEtatowego = numerEtatowego;
	}

	public int getStazPracy() {
		return stazPracy;
	}

	private void setStazPracy(int stazPracy) {
		this.stazPracy = stazPracy;
	}
	
	private void setProgPremii(int progPremii) {
		this.progPremii = progPremii;
	}

	public int getProgPremii() {
		return progPremii;
	}

	@Override
	public void ustawWynagrodzenie(double stawka) {
		double mnoznik = 1;
		
		if(getStazPracy() > 20)
			mnoznik = 1.6;
		else {
			for(int i = 1; i <= 4; i++) 
				if((getStazPracy() / 5) == i) {
					mnoznik += (0.15 * i);
					setProgPremii(i);
				}
		}
		super.setWynagrodzenie((int)(mnoznik * stawka * 160));
	}

	@Override
	public String toString() {
		return "Etatowy  o numerze: " + getNumer() + " [imie = " + getImie() + ", prog premii = " + getProgPremii() + "; wynagrodzenie = " + getWynagrodzenie() + "]";
	}
}
