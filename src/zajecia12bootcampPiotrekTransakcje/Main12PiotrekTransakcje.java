package zajecia12bootcampPiotrekTransakcje;

public class Main12PiotrekTransakcje {

		public static void main(String[] args) {

			Klient k1 =  new Klient("Adaœ", 200);
			Klient k2 =  new Klient("Kasia", 2000);
			Klient k3 =  new Klient("Basia", 100);
			
			Firma f1 = new Firma("Samsung", 100000);
			
			Tranzakcja t1 = new Tranzakcja(k1, f1, 50);
			Tranzakcja t2 = new Tranzakcja(k2, f1, 2000);
			Tranzakcja t3 = new Tranzakcja(k1, f1, 100);
			
			Tranzakcja.tranzakcje.forEach(e -> System.out.println(e));
		}
	}