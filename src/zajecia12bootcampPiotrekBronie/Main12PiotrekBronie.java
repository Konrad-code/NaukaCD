package zajecia12bootcampPiotrekBronie;

import java.util.ArrayList;
import java.util.List;

public class Main12PiotrekBronie {
	public static void main(String[] args) {
		BronDluga MP40 = new BronDluga("MP40", 100, 150);
		BronWybuchowa C4 = new BronWybuchowa("C4", 50);
		BronDlugaWybuchowa AK47 = new BronDlugaWybuchowa("AK-47 z Granatnikiem M320", 200, 100, 30);
		
		List<Bron> listaBroni = new ArrayList<Bron>();
		listaBroni.add(MP40);
		listaBroni.add(C4);
		listaBroni.add(AK47);
		
		listaBroni.forEach(e -> System.out.println(e));
	}
}
