package zajecia12bootcampFirma;

public class Klient implements Zakupy{
	private String imie;
	private int becel;
	private int numerKlienta;
	static int numer = 1;
	
	public Klient(String imie, int becel) {
		this.imie = imie;
		this.becel = becel;
		this.setNumerKlienta(numer);
		numer++;
	}

	public String getImie() {
		return imie;
	}

	@Override
	public int getBudzetZakupy() {
		return becel;
	}

	private void setBecel(int becel) {
		this.becel = becel;
	}
	
	public boolean removeBecel(int becel) {						// METODA REALIZUJACA OBCIAZENIE STANU KONTA KLIENTA PO DOKONANIU ZAKUPU
		boolean czyWeszlo = false;
		int nowyBecel = 0;
		nowyBecel = getBudzetZakupy() - becel;
		if(nowyBecel >= 0) {
			setBecel(nowyBecel);
			czyWeszlo = true;
		}
		else
			System.out.println("Klienta nie stac na dokonanie zakupu");
		return czyWeszlo;
	}

	@Override
	public int getNumer() {
		return numerKlienta;
	}

	public void setNumerKlienta(int numerKlienta) {
		this.numerKlienta = numerKlienta;
	}

	@Override
	public boolean dokonajZakupu(int hajs) {
		if(removeBecel(hajs))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString() {
		return "Klient o numerze: " + getNumer() + " [imie = " + getImie() + ", hajs do wydania na zakupach = " + getBudzetZakupy() + "]";
	}
}
