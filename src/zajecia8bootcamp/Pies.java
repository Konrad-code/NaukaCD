package zajecia8bootcamp;

public class Pies extends Zwierze {
	private int dlugoscOgona;
	
	{
		System.out.println("Blok inicjalizacyjny klasy pies");
	}
	
	public Pies(int maxWiek, String nazwa, int dlugoscOgona) {
		super(maxWiek, nazwa);
		this.dlugoscOgona = dlugoscOgona;
		
		System.out.println("Konstruktor klasy pies");
	}
}
