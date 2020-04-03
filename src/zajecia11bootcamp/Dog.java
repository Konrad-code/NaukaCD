package zajecia11bootcamp;

public interface Dog {
	public void bark(int iloscSzczekniec);
	
	public default void bark() {
//		System.out.println("Wykonanie domyslnego konstruktora metody abstrakcyjnej interfejsu");
	}
}
