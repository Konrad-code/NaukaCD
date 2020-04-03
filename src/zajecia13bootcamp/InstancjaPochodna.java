package zajecia13bootcamp;

public class InstancjaPochodna extends Instancja {
	{
		System.out.println("Blok inicjalizacyjny niestatyczny instancji pochodnej");
	}
	
	static{
		System.out.println("Blok inicjalizacyjny statyczny instancji pochodnej");
	}
	
	public InstancjaPochodna() {
		System.out.println("Konstruktor instancji pochodnej");
	}
	
	public static void wypisz(Integer i) {
		System.out.println(i);
	}
}
