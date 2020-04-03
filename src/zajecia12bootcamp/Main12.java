package zajecia12bootcamp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main12 {
	public static void main(String[] args) {
	
		Kotek k1 = new Kotek("Filemon");
		Kotek k2 = new Kotek("Garfield");
		Kotek k3 = new Kotek("Tom");
		Kotek k4 = Kotek.getInstance();
		Kotek k5 = Kotek.getInstance();
		
		System.out.printf("Imie: %s, kotek zostal stworzony w kolejnosci o numerze: %d\n", k1.imie, k1.numerKotka);
		System.out.printf("Imie: %s, kotek zostal stworzony w kolejnosci o numerze: %d\n", k2.imie, k2.numerKotka);
		System.out.printf("Imie: %s, kotek zostal stworzony w kolejnosci o numerze: %d\n", k3.imie, k3.numerKotka);
		
		System.out.printf("Imie: %s, kotek zostal stworzony w kolejnosci o numerze: 4\n", k4.imie);
		System.out.printf("Imie: %s, kotek zostal stworzony w kolejnosci o numerze: 5\n", k5.imie);
		
		List<Bron> bronie = new ArrayList<Bron>();
		List<PosrednikBroniWybuchowej> bronieDlugieWybuchowe = new ArrayList<>();
		
//		Bron bron1 = new Bron("noz");
		
		BronDluga bronDluga1 = new BronDluga("muszkiet", 100, 5, 50);
		BronDluga bronDluga2 = new BronDluga("karabin", 300, 10, 200);
		BronDluga bronDluga3 = new BronDluga("karabin snajperski", 50, 25, 500);
		
		BronWybuchowa bronWybuchowa1 = new BronWybuchowa("mina", 3, 5, 60);
		BronWybuchowa bronWybuchowa2 = new BronWybuchowa("granat", 2, 10, 60);
		BronWybuchowa bronWybuchowa3 = new BronWybuchowa("C4", 1, 15, 90);
		
		BronSzturmowa bronSzturmowa1 = new BronSzturmowa("F2000 ASSAULT", 500, 50, 50);
		BronSzturmowa bronSzturmowa2 = new BronSzturmowa("STG. 77 AUG", 500, 65, 70);
		BronSzturmowa bronSzturmowa3 = new BronSzturmowa("M416", 500, 85, 95);
		BronSzturmowa bronSzturmowa4 = new BronSzturmowa("M16A2", 500, 100, 120);
		
//		bronieDlugieWybuchowe.addAll((Collection<? extends PosrednikBroniWybuchowej>) bron1);
		
//		bronieDlugieWybuchowe.addAll((Collection<? extends PosrednikBroniWybuchowej>) bronDluga1);
//		bronieDlugieWybuchowe.addAll((Collection<? extends PosrednikBroniWybuchowej>) bronDluga2);
//		bronieDlugieWybuchowe.addAll((Collection<? extends PosrednikBroniWybuchowej>) bronDluga3);
		
		bronieDlugieWybuchowe.add(bronWybuchowa1);
		bronieDlugieWybuchowe.add(bronWybuchowa2);
		bronieDlugieWybuchowe.add(bronWybuchowa3);
		
		bronieDlugieWybuchowe.add(bronSzturmowa1);
		bronieDlugieWybuchowe.add(bronSzturmowa2);
		bronieDlugieWybuchowe.add(bronSzturmowa3);
		bronieDlugieWybuchowe.add(bronSzturmowa4);
		
//		bronWybuchowa1.setPoleRazenia(50);
//		bronSzturmowa1.se
		
		bronie.add(bronDluga1);
		bronie.add(bronWybuchowa1);
		bronie.add(bronSzturmowa1);
		bronie.forEach(e -> System.out.println(e));
		
	}
}
