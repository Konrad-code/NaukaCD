package zajecia12bootcamp;

public class BronDluga extends Bron{
	public int zasieg;
	public int ammo;
	
	public BronDluga(String nazwa, int ammo, int obrazenia, int zasieg) {
		super(nazwa);
		this.ammo = ammo;
		setZasieg(zasieg);
		setObrazenia(obrazenia);
	}
	
	public int getZasieg() {
		return zasieg;
	}

	public void setAmmo(int ammo) {
		this.ammo = ammo;
	}

	private void setZasieg(int nowyZasieg) {
		this.zasieg = nowyZasieg;
	}
	
	public void ranStrzalem() {
		System.out.println("Wywolales metode BronDluga.ranStrzalem()");
	}

	@Override
	public void setZadawaneObrazenia(int obrazenia) {
		if(obrazenia > 0)
			super.obrazenia = obrazenia / zasieg; 
	}
	
	@Override
	public String toString() {
		return "BronDluga [obrazenia = " + obrazenia + "]";
	}
}
