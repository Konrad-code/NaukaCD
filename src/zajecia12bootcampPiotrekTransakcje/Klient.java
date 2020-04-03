package zajecia12bootcampPiotrekTransakcje;

public class Klient {
	String imie;
	int kasa;
	
	public Klient(String imie, int kasa) {
		this.imie = imie;
		this.kasa = kasa;
	}

	@Override
	public String toString() {
		return "Klient [imie=" + imie + ", kasa=" + kasa + "]";
	}
}
