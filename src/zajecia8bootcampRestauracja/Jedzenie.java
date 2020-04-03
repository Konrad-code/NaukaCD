package zajecia8bootcampRestauracja;

public class Jedzenie extends Produkt{
	protected int masa;
	
	Skladnik skladnikZListy = new Skladnik();
	
	public Jedzenie(String nazwa, int cena, int masa) {
		super(nazwa, cena);
		this.masa = masa;
	}
}
