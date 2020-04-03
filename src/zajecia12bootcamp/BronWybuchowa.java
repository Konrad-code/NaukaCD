package zajecia12bootcamp;

public class BronWybuchowa extends Bron implements PosrednikBroniWybuchowej{
	private int poleRazenia;
	private int iloscSztuk;
	
	public BronWybuchowa(String nazwa, int iloscSztuk, int poleRazenia, int obrazenia) {
		super(nazwa);
		this.iloscSztuk = iloscSztuk;
		this.poleRazenia = poleRazenia;
		setZadawaneObrazenia(obrazenia);
	}
	
	public void setPoleRazenia(int nowePoleRazenia) {
		this.poleRazenia = nowePoleRazenia;
	}
	
	public void ranWybuchem() {
		System.out.println("Wywolales metode BronWybuchowa.ranWybuchem()");
	}
	
	@Override
	public void setZadawaneObrazenia(int noweObrazenia) {
		super.obrazenia = noweObrazenia * poleRazenia;
	}

	@Override
	public void zadajObrazenia() {
		System.out.println("Moge wybuchaæ!");		
	}
	
	@Override
	public String toString() {
		return "BronWybuchowa [poleRazenia = " + poleRazenia + ", obrazenia = " + obrazenia + "]";
	}
}
