package zajecia8bootcamp;

public class Zwierze {
	int maxWiek;
	String nazwa;
	boolean czyKobieta;
	
	{
		System.out.println("Konstruktor inicjalizacyjny klasy zwierze");
	}
	
	public Zwierze(int maxWiek,String nazwa) {
		super();
		this.maxWiek = maxWiek;
		this.nazwa = nazwa;
	
		System.out.println("Konstruktor klasy zwierze");
	}
}
