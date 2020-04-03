package zajecia13bootcamp;

public class Pajak {
	String nazwa;
	int masaCiala;
	
	public Pajak(String nazwa, int masaCiala) {
		this.masaCiala = masaCiala;
		this.nazwa = nazwa;
	}
	
	public static void modyfikuj(int a) {
		a = 5;
	}
	
	public static void modyfikujMaseCiala(Pajak pajak) {
		pajak.masaCiala = 0;
	}
}
