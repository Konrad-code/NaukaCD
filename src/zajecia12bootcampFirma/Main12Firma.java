package zajecia12bootcampFirma;

public class Main12Firma {
	public static void main(String[] args) {
		
		// INICJALIZACJA OBIEKTOW Klient ZA POMOCA KONSTRUKTORA
		Klient k1 =  new Klient("Adaœ", 200);		// 0
		Klient k2 =  new Klient("Kasia", 20000);	// 1
		Klient k3 =  new Klient("Basia", 100);		// 2
		
		// INICJALIZACJA OBIEKTU JEDNOINSTANCYJNEJ KLASY Firma
		Firma f1 = Firma.getInstance();
		f1.addSzmalec(100000);
		
		// INICJALIZACJA 3 PODTYPOW KLASY Pracownik ZA POMOCA KONSTRUKTOROW ODPOWIEDNICH KLAS POTOMNYCH
		Zwykly z1 = new Zwykly("Patryk", 300, 11);	// 3
		Zwykly z2 = new Zwykly("Bartek", 300, 12);	// 4
		Zwykly z3 = new Zwykly("Cyryl", 300, 13);	// 5
		Zwykly z4 = new Zwykly("Konrad", 300, 14);	// 6
		Zwykly z5 = new Zwykly("Pawel", 300, 15);	// 7
		Zwykly z6 = new Zwykly("Jasiek", 300, 16);	// 8

		Etatowy e1 = new Etatowy("Patryk", 300, 14, 4);	// 9
		Etatowy e2 = new Etatowy("Bartek", 300, 15, 5);	// 10
		Etatowy e3 = new Etatowy("Cyryl", 300, 16, 6);	// 11
		Etatowy e4 = new Etatowy("Konrad", 300, 17, 10);// 12
		Etatowy e5 = new Etatowy("Pawel", 300, 18, 11);	// 13
		Etatowy e6 = new Etatowy("Jasiek", 300, 19, 27);// 14
		
		Sezonowy s1 = new Sezonowy("Patryk", 300, 8, true, 0.75);	// 15
		Sezonowy s2 = new Sezonowy("Bartek", 300, 9, false, 1.0);	// 16
		Sezonowy s3 = new Sezonowy("Cyryl", 300, 10, true, 1.75);	// 17
		Sezonowy s4 = new Sezonowy("Konrad", 300, 11, false, 1.25);	// 18
		Sezonowy s5 = new Sezonowy("Pawel", 300, 12, true, 0.5);	// 19
		Sezonowy s6 = new Sezonowy("Jasiek", 300, 13, false, 0.75);	// 20
		
		System.out.println(z1);
		System.out.println(e1);
		System.out.println(s1);
//		System.out.println(s2);
//		System.out.println(s3);
//		System.out.println(s4);
//		System.out.println(s5);
//		System.out.println(s6);
		
		// INICJALIZACJA TABLICY OBIEKTOW TYPU INTERFEJSOWEGO Zakupy KTORY IMPLEMENTUJE KLASA Klient ORAZ Pracownik
		// (Z KTOREGO DZIEDZICZA RELACJE 3 KLASY POTOMNE PODTYPOW KLASY Pracownik - Zwykly, Etatowy ORAZ Sezonowy)
		Zakupy[] zakupy = {k1, k2, k3, z1, z2, z3, z4, z5, z6, e1, e2, e3, e4, e5, e6, s1, s2, s3, s4, s5, s6};
		
		// SEKCJA DOKONYWANIA TRANSAKCJI
		System.out.println("\n\nSEKCJA DOKONYWANIA TRANSAKCJI:\n");
		Transakcja t0 = new Transakcja(zakupy, 0, f1, 50);
		Transakcja t1 = new Transakcja(zakupy, 1, f1, 18500);
		Transakcja t2 = new Transakcja(zakupy, 2, f1, 150);
		
		Transakcja t3 = new Transakcja(zakupy, 3, f1, 100);
		Transakcja t4 = new Transakcja(zakupy, 4, f1, 50);
		Transakcja t5 = new Transakcja(zakupy, 5, f1, 150);
		Transakcja t6 = new Transakcja(zakupy, 6, f1, 100);
		Transakcja t7 = new Transakcja(zakupy, 7, f1, 50);
		Transakcja t8 = new Transakcja(zakupy, 8, f1, 150);
		
		Transakcja t9 = new Transakcja(zakupy, 9, f1, 100);
		Transakcja t10 = new Transakcja(zakupy, 10, f1, 50);
		Transakcja t11 = new Transakcja(zakupy, 11, f1, 150);
		Transakcja t12 = new Transakcja(zakupy, 12, f1, 100);
		Transakcja t13 = new Transakcja(zakupy, 13, f1, 50);
		Transakcja t14 = new Transakcja(zakupy, 14, f1, 150);
		
		Transakcja t15 = new Transakcja(zakupy, 15, f1, 100);
		Transakcja t16 = new Transakcja(zakupy, 16, f1, 50);
		Transakcja t17 = new Transakcja(zakupy, 17, f1, 150);
		Transakcja t18 = new Transakcja(zakupy, 18, f1, 100);
		Transakcja t19 = new Transakcja(zakupy, 19, f1, 100);
		Transakcja t20 = new Transakcja(zakupy, 20, f1, 50);
		
		Transakcja t21 = new Transakcja(zakupy, 1, f1, 2500);
		Transakcja t22 = new Transakcja(zakupy, 20, f1, 250);
		
		// SEKCJA WYSWIETLANIA TRANSAKCJI
		System.out.println("\n\nSEKCJA WYSWIETLANIA TRANSAKCJI:\n");
		Transakcja.transakcje.forEach(e -> System.out.println(e));
		
		// SEKCJA KOSZTORYSU DLA KLASY Firma
		int dochod = f1.liczDochodSprzedaz();
		int koszta = f1.liczKosztaPracownikow();
		f1.skeszujWyplatyPracownikow(koszta);
		int saldo = f1.saldo();
		System.out.printf("\n\nKOSZTORYS FIRMY:\nDochod firmy %s z poczynionych %d transakcji sprzedazy wynosi: \n\t\t%d\nKoszt firmy %s wynikajacy z posiadania %d zatrudnionych pracownikow wynosi: \n\t\t%d\nNatomiast finalnie saldo firmy %s za biezacy miesiacwynosi: \n\t\t%d\nGdzie aktualne konto firmy %s to dokladnie: \n\t\t%d\n",
															f1.getNazwa(),	 zakupy.length, 						dochod, 	f1.getNazwa(),	Pracownik.getLiczbaZatrudnionychPracownikow(), 			koszta,								f1.getNazwa(), 						saldo,						f1.getNazwa(),		f1.getSzmalec());
	}
}
