package zajecia11bootcampPiotrek;

interface Ruch {

	public void wykonajRuch(int iloscJednostek);

	public default void wykonajRuch() {
		System.out.println("Domy�lna konfiguracja wykonywania ruchu.");
	}
}