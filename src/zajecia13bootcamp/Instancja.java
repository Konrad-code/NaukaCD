package zajecia13bootcamp;

public class Instancja {
	
	{
		System.out.println("Blok inicjalizacyjny niestatyczny");		// KONFIGURACJA PREINICJALIZACYJNA OBIEKTOW
	}
	
	static 
	{
		System.out.println("Blok inicjalizacyjny statyczny");			// PRZY PIERWSZYM ODNIESIENIU DO KLASY WYKONUJE SIE JAKO PIERWSZY
	}																	// 1. POWINNY FABRYKOWAC WSZYSTKIE ZMIENNE STATYCZNE 
																		// 2. WYKONYWAC WSZYSTKIE CZYNNOSCI PREWYWOLAWCZE DLA KLASY
	public Instancja() {
		System.out.println("Konstruktor");
	}
	
	public static void wypisz() {
		System.out.println("Metoda statyczna");
	}
}
