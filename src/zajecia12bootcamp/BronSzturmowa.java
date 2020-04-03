package zajecia12bootcamp;

public class BronSzturmowa extends BronDluga implements PosrednikBroniWybuchowej {
	public BronSzturmowa(String nazwa, int ammo, int obrazenia, int zasieg) {
		super(nazwa, ammo, obrazenia, zasieg);
	}

	@Override
	public void setZadawaneObrazenia(int noweObrazenia) {
		
	}
	
	@Override
	public void zadajObrazenia() {
		System.out.println("Wywolales metode BronSzturmowa.zadajObrazenia()");		
	}

	@Override
	public String toString() {
		return "BronSzturmowa [zasieg = " + zasieg + ", ammo = " + ammo + ", nazwa = " + nazwa + ", obrazenia = " + obrazenia
				+ "]";
	}
}
