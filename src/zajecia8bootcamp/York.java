package zajecia8bootcamp;

public class York extends Pies{
	
	private boolean czyMiniaturka;
	private int iloscSzczepien;
	{
		iloscSzczepien = 0;
		System.out.println("Blok inicjalizacyjny klasy York");
	}
	
	public York(int maxWiek, String nazwa, int dlugoscOgona, boolean czyMiniaturka) {
		super(maxWiek, nazwa, dlugoscOgona);
		this.czyMiniaturka = czyMiniaturka;
		
		System.out.println("Konstruktor klasy York");
	}
}
