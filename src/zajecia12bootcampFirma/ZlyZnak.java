package zajecia12bootcampFirma;

public class ZlyZnak extends Exception{
	public ZlyZnak(){
		System.out.println("Wprowadziles bledne polecenie ruchu. Mozliwy do wprowadzenia tylko 1 znak z puli 'W' / 'S' / 'A' / 'D'.");
	}
}
