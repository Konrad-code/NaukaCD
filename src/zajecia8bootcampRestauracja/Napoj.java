package zajecia8bootcampRestauracja;

public class Napoj extends Produkt{
	private int litraz;
	
	public Napoj(String nazwa, int cena, int litraz) {
		super(nazwa, cena);
		this.litraz = litraz;
	}
}
