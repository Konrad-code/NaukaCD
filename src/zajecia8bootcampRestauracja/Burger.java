package zajecia8bootcampRestauracja;

public class Burger extends Jedzenie {
	private boolean czyKanapka;
	protected String rodzaj;
	
//	Skladnik skladnikZListy = new Skladnik();
	
	{
		czyKanapka = true;
	}
	
	public Burger(String nazwa, int masa) {
		super(nazwa, 10, masa);
	}
}
