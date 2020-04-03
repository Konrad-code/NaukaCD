package zajecia12bootcampPiotrekTransakcje;

public class Firma {
	String nazwa;
	int kasa;
	
	public Firma(String nazwa, int kasa) {
		this.nazwa = nazwa;
		this.kasa = kasa;
	}

	@Override
	public String toString() {
		return "Firma [nazwa=" + nazwa + ", kasa=" + kasa + "]";
	}
}
